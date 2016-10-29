package com.dao;

import help.appService.inputBeans.HelpAppServiceIB;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.HelpDBBean;
import com.structures.status.HelpStatus;
import com.util.CommonUtility;

@Transactional
public class HelpDao {

	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	
	public boolean submitHelpRequest(HelpAppServiceIB helpAppServiceIB)
	{
		boolean result = false;
		try{
		HelpDBBean helpDBBean = new HelpDBBean();
		CommonUtility.copyBean(helpAppServiceIB, helpDBBean);
		helpDBBean.setStatus(HelpStatus.PENDING.toString());
		template.save(helpDBBean);
		result= true;
		}catch(Exception e)
		{
			System.out.println("Exception in submitHelpRequest");
		}
		return result;
		
	}
	
}
