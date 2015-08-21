package com.appService.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.appService.UserFunctionsAppService;
import com.appService.inputBean.UserFunctionsAppSrvcIB;
import com.appService.outputBean.UserFunctionsAppSrvcOB;
import com.dao.UserFunctionsDao;
import com.databaseBeans.UserLoginDBBean;

public class UserFunctionsAppServiceImpl implements UserFunctionsAppService {

	UserFunctionsDao userFunctionsDao;

	@Override
	public UserFunctionsAppSrvcOB login(UserFunctionsAppSrvcIB userFunctionsAppSrvcIB) {
		// TODO Auto-generated method stub

		UserFunctionsAppSrvcOB userFunctionsAppSrvcOB = new UserFunctionsAppSrvcOB();
		List<UserLoginDBBean> userLoginDBBeans =userFunctionsDao.getAllUserLogin();

		if( null!= userLoginDBBeans && null != userFunctionsAppSrvcIB 
				&& StringUtils.isNotEmpty(userFunctionsAppSrvcIB.getUsername()) && StringUtils.isNotEmpty(userFunctionsAppSrvcIB.getPassword()))
		{
			if(checkIfUserExists(userLoginDBBeans, userFunctionsAppSrvcIB))
			{
				userFunctionsAppSrvcOB.setUserExists(true);
				if(checkCredential(userLoginDBBeans, userFunctionsAppSrvcIB))
				{
					userFunctionsAppSrvcOB.setCredentialMatch(true);
					
				}

			}
		}
		return userFunctionsAppSrvcOB;
	}

	private boolean checkIfUserExists(List<UserLoginDBBean> userLoginDBBeans, UserFunctionsAppSrvcIB userFunctionsAppSrvcIB)
	{
		for(UserLoginDBBean userLoginDBBean : userLoginDBBeans)
		{
			if((userFunctionsAppSrvcIB.getUsername()).equals(userLoginDBBean.getUsername()))
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkCredential(List<UserLoginDBBean> userLoginDBBeans, UserFunctionsAppSrvcIB userFunctionsAppSrvcIB)
	{
		for (UserLoginDBBean userLoginDBBean :userLoginDBBeans)
		{
			if(userFunctionsAppSrvcIB.getUsername().equals(userLoginDBBean.getUsername())
					&& userFunctionsAppSrvcIB.getPassword().equals(userLoginDBBean.getPassword()))
			{
				return true;
			}
		}
		return false;
	}

	public UserFunctionsDao getUserFunctionsDao() {
		return userFunctionsDao;
	}

	public void setUserFunctionsDao(UserFunctionsDao userFunctionsDao) {
		this.userFunctionsDao = userFunctionsDao;
	}
}
