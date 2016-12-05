package com.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.databaseBeans.UsersDBBean;

public class CommonUtility {

	public static void copyBean(Object sourceBean, Object destinationBean)
	{
		Map<String, Object> elementsMap = null;
		try {
			elementsMap = PropertyUtils.describe(destinationBean);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!= elementsMap )
		{
			Set<String> elementSet = elementsMap.keySet();
			for(String element : elementSet )
			{
				Object value = null;
				try {

					value = PropertyUtils.getProperty(sourceBean, element);

					if(null!= value && !element.equals("class"))
					{

						PropertyUtils.setProperty(destinationBean, element, value);
					}
				} catch (IllegalArgumentException e) {
					try {
						PropertyUtils.setProperty(destinationBean, element, value.toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					System.out.println(e.getMessage());
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static Map<String,ProductsDBBean> getProductMap(List<ProductsDBBean> list)
	{
		Map<String, ProductsDBBean>  map= new HashMap<String, ProductsDBBean>();
		if(null!= list && list.size()>0)
		{
			for(ProductsDBBean item :list)
			{
				String key = String.valueOf(item.getProductid());
				map.put(key, item);
			}
		}

		return map;
	}
	
	public static Map<String,UsersDBBean> getUsersmap(List<UsersDBBean> list)
	{
		Map<String, UsersDBBean>  map= new HashMap<String, UsersDBBean>();
		if(null!= list && list.size()>0)
		{
			for(UsersDBBean item :list)
			{
				String key = String.valueOf(item.getUsername());
				map.put(key, item);
			}
		}

		return map;
	}

	public static Map<String,RentOffersDBBean> getRentMap(List<RentOffersDBBean> list)
	{
		Map<String, RentOffersDBBean>  map= new HashMap<String, RentOffersDBBean>();
		if(null!= list && list.size()>0)
		{
			for(RentOffersDBBean item :list)
			{
				String key = String.valueOf(item.getRentid());
				map.put(key, item);
			}
		}

		return map;
	}

	public static Map<String,OrdersDBBean> getOrdersMap(List<OrdersDBBean> list)
	{
		Map<String, OrdersDBBean>  map= new HashMap<String, OrdersDBBean>();
		if(null!= list && list.size()>0)
		{
			for(OrdersDBBean item :list)
			{
				String key = String.valueOf(item.getOrderid());
				map.put(key, item);
			}
		}
		return map;
	}

	public static Date addDate(Date currentDate, String periodUnit,String periodValue)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		if(periodUnit.equals("Months"))
		{
			cal.add(Calendar.MONTH, Integer.parseInt(periodValue));
		}
		if(periodUnit.equals("Days"))
		{
			cal.add(Calendar.DATE, Integer.parseInt(periodValue));
		}
		if(periodUnit.equals("Years"))
		{
			cal.add(Calendar.YEAR, Integer.parseInt(periodValue));
		}
		return cal.getTime();
	}
}
