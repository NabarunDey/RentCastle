package com.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;

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
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static Map<String,ProductsDBBean> getProductMap(List<ProductsDBBean> list)
	{
		Map<String, ProductsDBBean>  map= new HashMap<String, ProductsDBBean>();
		for(ProductsDBBean item :list)
		{
				String key = String.valueOf(item.getProductid());
				map.put(key, item);
		}
		
		return map;
	}
	
	public static Map<String,RentOffersDBBean> getRentMap(List<RentOffersDBBean> list)
	{
		Map<String, RentOffersDBBean>  map= new HashMap<String, RentOffersDBBean>();
		for(RentOffersDBBean item :list)
		{
				String key = String.valueOf(item.getRentid());
				map.put(key, item);
		}
		
		return map;
	}

}
