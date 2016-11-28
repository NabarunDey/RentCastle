package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import payment.appService.inputBeans.PaymentAppServiceIB;

import com.dao.CurrentHoldingsDao;
import com.dao.OrdersDao;
import com.dao.PaymentsDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.CurrentHoldingsDBBean;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.PaymentsDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.structures.status.CurrentHoldingStatus;
import com.structures.status.PaymentStatus;

import currentHoldings.appService.inputBeans.CurrentHoldingsAppServiceIB;

public class RenewCurrentHoldingsJob {

	private CurrentHoldingsDao currentHoldingsDao;
	private PaymentsDao paymentsDao;
	private ProductsDao productsDao;
	private OrdersDao ordersDao;
	private RentOffersDao rentOffersDao;

	public void execute() {

		System.out.println("----------------------------------------------------------");
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
					renewCurrentHoldingDefault(currentHoldingsDBBean);

				}

				else if(todaydate.after(expiryDate) && !currentHoldingsDBBean.isAutorenew())
				{
					endCurrentHolding(String.valueOf(currentHoldingsDBBean.getHoldingid()), true);
				}

			}catch (Exception e) {
				System.out.println("Error Renewing CurrentHolding Id : "+currentHoldingsDBBean.getHoldingid());
			}

		}
		if(null!= holdingIdsForUpcoming && holdingIdsForUpcoming.size()>0)
			currentHoldingsDao.setStatusAsUpcoming(holdingIdsForUpcoming);
	}


	private void endCurrentHolding(String currentHoldingId, boolean systemCall)
	{
		CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB = new CurrentHoldingsAppServiceIB();
		currentHoldingsAppServiceIB.setCurrentHoldinsId(currentHoldingId);
		currentHoldingsAppServiceIB.setStatus(CurrentHoldingStatus.ENDREQUESTED.toString());
		CurrentHoldingsDBBean currentHoldingsDBBean =  currentHoldingsDao.modiFyCurrentHoldingStatus(currentHoldingsAppServiceIB,null,systemCall);

		OrdersDBBean ordersDBBean =  ordersDao.getOrder(currentHoldingsDBBean.getOrderid());
		PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
		paymentAppServiceIB.setOrderid(ordersDBBean.getOrderid());
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForOrder(paymentAppServiceIB);

		for(PaymentsDBBean paymentsDBBean : paymentsDBBeans)
		{
			if(StringUtils.isNotEmpty(paymentsDBBean.getSecuritymoney())&& !paymentsDBBean.getSecuritymoney().equals("0"))
			{
				PaymentAppServiceIB paymentAppServiceIB2 = new PaymentAppServiceIB();
				paymentAppServiceIB2.setFromusername(paymentsDBBean.getTousername());
				paymentAppServiceIB2.setOrderid(currentHoldingsDBBean.getOrderid());
				paymentAppServiceIB2.setPaymentStatus(PaymentStatus.PENDING.toString());
				paymentAppServiceIB2.setSecuritymoney(paymentsDBBean.getSecuritymoney());
				paymentAppServiceIB2.setTousername(paymentsDBBean.getFromusername());

				List<PaymentAppServiceIB> paymentAppServiceIBs = new ArrayList<PaymentAppServiceIB>();
				paymentAppServiceIBs.add(paymentAppServiceIB2);
				paymentsDao.addPayment(paymentAppServiceIBs);
			}
		}
	}

	private void renewCurrentHoldingDefault(CurrentHoldingsDBBean currentHoldingsDBBean)
	{
		try{
			RentOffersDBBean rentOffersDBBean = rentOffersDao.getRentOffersById(currentHoldingsDBBean.getRentOfferid());
			Date today  = Calendar.getInstance().getTime();
			Date newExpDate = CommonUtility.addDate(today, rentOffersDBBean.getPeriodunit(), rentOffersDBBean.getPeriodvalue());
			currentHoldingsDBBean.setStatus(CurrentHoldingStatus.ONGOING.toString());
			currentHoldingsDBBean.setRentexpirydate(newExpDate.toString());

			currentHoldingsDao.renewCurrentHolding(currentHoldingsDBBean);

			ProductsDBBean productsDBBean = productsDao.getProductDetails(currentHoldingsDBBean.getProductid());

			PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
			paymentAppServiceIB.setFromusername(currentHoldingsDBBean.getUsername());
			paymentAppServiceIB.setOrderid(currentHoldingsDBBean.getOrderid());
			paymentAppServiceIB.setRentamount(rentOffersDBBean.getAmount());
			paymentAppServiceIB.setTousername(productsDBBean.getUsername());

			List<PaymentAppServiceIB> paymentAppServiceIBs = new ArrayList<PaymentAppServiceIB>() ;
			paymentAppServiceIBs.add(paymentAppServiceIB);
			paymentsDao.addPayment(paymentAppServiceIBs);

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public CurrentHoldingsDao getCurrentHoldingsDao() {
		return currentHoldingsDao;
	}

	public void setCurrentHoldingsDao(CurrentHoldingsDao currentHoldingsDao) {
		this.currentHoldingsDao = currentHoldingsDao;
	}

	public PaymentsDao getPaymentsDao() {
		return paymentsDao;
	}


	public void setPaymentsDao(PaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}


	public ProductsDao getProductsDao() {
		return productsDao;
	}


	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}


	public OrdersDao getOrdersDao() {
		return ordersDao;
	}


	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}


	public RentOffersDao getRentOffersDao() {
		return rentOffersDao;
	}


	public void setRentOffersDao(RentOffersDao rentOffersDao) {
		this.rentOffersDao = rentOffersDao;
	}

}
