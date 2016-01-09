package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class RentMeBeanFactory {

	private static ApplicationContext applicationContext;

	public static Object getBean(String beanId)
	{
		Object object = null;
		try{
			/* applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			object =ctx.getBean(beanId);*/
		}catch (Exception exception)
		{

		}
		return object;
	}
}
