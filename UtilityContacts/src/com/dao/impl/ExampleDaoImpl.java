package com.dao.impl;

import com.dao.ExampleDao;
import com.transferObjects.ExampleDTO;
import com.util.TransferObjectReceiver;

public class ExampleDaoImpl implements ExampleDao{

	@Override
	public String exampleFunctionDao() {
		
		ExampleDTO exampleDTO=(ExampleDTO)TransferObjectReceiver.getTransferObject("exampleRequest");
		return "Hello from ExampleDaoImpl"+exampleDTO;
	}

}
