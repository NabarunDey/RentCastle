package com.util;

import java.io.InputStream;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.transferObjects.ExampleDTO;
import com.transferObjects.UniversalTransferObject;

public class TransferObjectReceiver {

	public static Object getTransferObject(String request)
	{

		Object response=null;
		try
		{
			Properties prop = new Properties();
			InputStream inputStream = TransferObjectReceiver.class.getClassLoader().getResourceAsStream("transferObjectsMapping.properties");
			prop.load(inputStream);
			String filepath=prop.getProperty(request);
			inputStream = TransferObjectReceiver.class.getClassLoader().getResourceAsStream(filepath);
			JAXBContext jaxbContext = JAXBContext.newInstance(UniversalTransferObject.class);
			inputStream = TransferObjectReceiver.class.getClassLoader().getResourceAsStream("xml\\"+filepath);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			response = jaxbUnmarshaller.unmarshal(inputStream);
		}
		 catch (JAXBException e) {
				e.printStackTrace();
			  }
		catch(Exception e)
		{

		}
		return response;
	}

}
