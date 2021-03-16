package com.client;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ClassProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Properties obj = new Properties();
		
		OutputStream op = null;
		try {
			op = new FileOutputStream("C:\\Users\\Relifin\\eclipse-workspace\\ClientProject\\WebContent\\WEB-INF\\classes\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		System.out.println(e);
		}	
		obj.setProperty("http", "//10.20.0.172:1880/restgateway/services/InsertTable/insert");
		obj.setProperty("path-2","update3");
		try {
			obj.store(op, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
