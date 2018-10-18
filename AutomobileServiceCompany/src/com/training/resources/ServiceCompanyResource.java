package com.training.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.*;

import com.training.entity.Customer;
import com.training.ifaces.DAO;
import com.training.ifaces.DAOImpl;

@Path("/customer")
public class ServiceCompanyResource {
	
	DAO imp;
	public ServiceCompanyResource() {
		super();
		imp=new DAOImpl();
	}
	
	@GET
	@Path("/retreive")
	@Produces(MediaType.TEXT_PLAIN)
	public String retreiveCustomer() {
		
	return "hello";
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public int addCustomer(Customer cust) {

		int custadded=0;
		System.out.println(cust);
		try {
			custadded= imp.addCustomer(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cust);
		return custadded;
	}
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer retreiveDetails(@QueryParam("phoneNumber") String mobileNumber) {
		Customer cust=null;
		try {
			//System.out.println("check");
			cust=imp.retreiveDetails(mobileNumber);
	System.out.println(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}
}
	