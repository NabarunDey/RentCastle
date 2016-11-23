package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.dao.CurrentHoldingsDao;
import com.databaseBeans.CurrentHoldingsDBBean;
import com.structures.status.CurrentHoldingStatus;

import currentHoldings.appService.CurrentHoldingsAppService;

public class RenewCurrentHoldingsJob  implements Job{

	private CurrentHoldingsDao currentHoldingsDao;
	private CurrentHoldingsAppService currentHoldingsAppService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub

		List<CurrentHoldingsDBBean> currentHoldingsDBBeans = currentHoldingsDao.getAllCurrentHoldingsToBeRenewed();
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));

		ArrayList<Integer> holdingIdsForUpcoming = new ArrayList<Integer>();


		for(CurrentHoldingsDBBean currentHoldingsDBBean : currentHoldingsDBBeans)
		{
			try{
				String dateStr =currentHoldingsDBBean.getRentexpirydate();
				DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
				Date expiryDate = (Date)formatter.parse(dateStr);

				Date todaydate = Calendar.getInstance().getTime();

				long diff = expiryDate.getTime() - todaydate.getTime();
				long daysLeft = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);


				if(!CurrentHoldingStatus.UPCOMING.toString().equals(currentHoldingsDBBean.getStatus()) 
						&& currentHoldingsDBBean.isAutorenew()
						&& 0<daysLeft && daysLeft<=5)
				{
					holdingIdsForUpcoming.add(currentHoldingsDBBean.getHoldingid());
				}

				else if(todaydate.after(expiryDate) && currentHoldingsDBBean.isAutorenew())
				{
					currentHoldingsAppService.renewCurrentHoldingDefault(currentHoldingsDBBean);

				}
				
				else if(todaydate.after(expiryDate) && !currentHoldingsDBBean.isAutorenew())
				{
					currentHoldingsAppService.endCurrentHolding(String.valueOf(currentHoldingsDBBean.getHoldingid()), true);
				}

			}catch (Exception e) {
				System.out.println("Error Renewing CurrentHolding Id : "+currentHoldingsDBBean.getHoldingid());
			}

		}


	}

	public CurrentHoldingsDao getCurrentHoldingsDao() {
		return currentHoldingsDao;
	}

	public void setCurrentHoldingsDao(CurrentHoldingsDao currentHoldingsDao) {
		this.currentHoldingsDao = currentHoldingsDao;
	}

	public CurrentHoldingsAppService getCurrentHoldingsAppService() {
		return currentHoldingsAppService;
	}

	public void setCurrentHoldingsAppService(
			CurrentHoldingsAppService currentHoldingsAppService) {
		this.currentHoldingsAppService = currentHoldingsAppService;
	}

}
