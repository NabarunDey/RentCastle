/*package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class AWSBucketHandler {
	private static String bucketName     = "rentcastleproductimages";

	private static AWSCredentials Credentials = new BasicAWSCredentials(
			"AKIAIYRFMQWKVC4Z5VUQ", 
			"v+ABcAIqLgPuZZhTwlkGcFCUOdwiOjUwd6r1O+nj");

	public static void uploadfile(File file,String fileName)
	{
		AmazonS3 s3client = new AmazonS3Client(Credentials);

		try {
			System.out.println("Uploading a new object to S3 from a file\n");
			s3client.putObject(new PutObjectRequest(
					bucketName, fileName, file));

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which " +
					"means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which " +
					"means the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}

	void deletefile(String fileName)
	{
		AmazonS3 s3client = new AmazonS3Client(Credentials);
		try {
			s3client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}

	void getfile(String fileName) throws IOException
	{
		AmazonS3 s3client = new AmazonS3Client(Credentials);
		try {
			System.out.println("Downloading an object");
			S3Object s3object = s3client.getObject(new GetObjectRequest(
					bucketName, fileName));
			System.out.println("Content-Type: "  + 
					s3object.getObjectMetadata().getContentType());	 
			InputStream input = s3object.getObjectContent();

			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while (true) {
				String line = reader.readLine();
				if (line == null) break;

				System.out.println("    " + line);
			}
			System.out.println();   
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which" +
					" means your request made it " +
					"to Amazon S3, but was rejected with an error response" +
					" for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means"+
					" the client encountered " +
					"an internal error while trying to " +
					"communicate with S3, " +
					"such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}

}


*/