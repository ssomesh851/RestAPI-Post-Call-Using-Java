package com.client;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
//import com.service.use.TestRun;
//import com.sun.security.ntlm.Client;
import com.sun.jersey.api.client.Client;


/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("Record insertion process to the server has been triggered");
		final Logger logger = Logger.getLogger(ClientServlet.class);
        logger.info("creating a client object");
		Client client = Client.create();
		String Reference_Id = (String)request.getParameter("reference_id");
		String Name = (String)request.getParameter("username");
		String Amount = (String)request.getParameter("amt");
		String Serial_No = (String)request.getParameter("srno");
		
		Form form = new Form();
		form.add("reference_id", Reference_Id);
		form.add("username", Name);
		form.add("amt", Amount);
		form.add("srno", Serial_No);
		
		
		WebResource webResource = client.resource("http://10.20.0.172:1880/restgateway/services/InsertTable/insert");
		ClientResponse resp = webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(ClientResponse.class, form);
		
		logger.info("response"+resp);
		
		
		//System.out.println(resp);
	
		if(resp.getStatus() == 200) {
			String output = resp.getEntity(String.class);
			logger.info("The response from the client server:"+output);
			System.out.println(output);
		}
		
		//doGet(request, response);
		
		//doGet(request, response);
		
		//System.out.println("Record got inserted");
		
		Properties obj = new Properties();
		OutputStream op = new FileOutputStream("C:\\Users\\Relifin\\eclipse-workspace\\ClientProject\\WebContent\\WEB-INF\\classes\\config.properties");
		
		obj.setProperty("url", "http://10.20.0.172:1880/restgateway/services/InsertTable/insert");
		obj.setProperty("path","insert");
		obj.store(op, null);
			
	}
	
}