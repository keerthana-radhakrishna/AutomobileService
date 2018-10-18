package com.training.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.dao.impl.DAOImpl;

@Path("/insurance")
public class InsuranceResource {
DAOImpl dao;
	
	public InsuranceResource() {
		 dao=new DAOImpl();
	}

	@GET
	@Path("/getInsurance")
	@Produces(MediaType.TEXT_PLAIN)
	public double getInsurance(@QueryParam("vehicleNum") String vehicleNum,@QueryParam("service") String service) {
		//System.out.println("in resource"+vehicleNum);
		//System.out.println("in resource"+service);
		double amt= dao.getInsuranceAmt(vehicleNum, service);
		System.out.println(amt);
		return amt;
	}
}
