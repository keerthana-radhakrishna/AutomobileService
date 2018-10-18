package com.training.ifaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import org.apache.log4j.*;

import com.training.connection.DbConnection;
import com.training.entity.Car;
import com.training.entity.Customer;
import com.training.entity.Employee;

public class DAOImpl implements DAO {
	
	
	private Connection con;
	
	public DAOImpl() {
		super();
		DbConnection db= new DbConnection();
		con=db.getConnection();
	}

	
	
	public boolean checkCredentials(String username,String passWord) throws Exception {
		String pwd =null;
		boolean check=false;
		String sql="select password from loginkr where username=?";
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			 pwd = rs.getString("password");
			}
		System.out.println(pwd);
//		System.out.println(passWord);
		if(pwd.equals(passWord)) {
			check=true;
		}
	
	return check;
}



	public int registerEmp(String username, String password,String empid) throws Exception {
	
		String sql="insert into loginkr values(?,?,?)";
		int rowadded=0;
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, empid);
		rowadded=pstmt.executeUpdate();
		return rowadded;
	}
	public int addCustomer(Customer cust) throws Exception {
		
		String sql1="insert into customerk values(?,?,?)";
		int custadded=0;
		PreparedStatement pstmt1=null;
		
		pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, cust.getCustomerName());
		pstmt1.setString(2, cust.getPhoneNumber());
		pstmt1.setString(3, cust.getCarNumber());
		System.out.println(cust.getCarNumber());
		custadded=pstmt1.executeUpdate();
		
		String sql2="insert into carservices values ("+"ser_id.nextval"+",?,?)";
		PreparedStatement pstmt2=null;
		pstmt2=con.prepareStatement(sql2);
		pstmt2.setString(1, cust.getCarNumber());

		
		Car service= cust.getServiceList();
		
		if(service.getPolishing().equals("true")) {
			pstmt2.setString(2, "polishing");
			custadded=pstmt2.executeUpdate();
		}
		 if(service.getWheelBalancing().equals("true")) {
			pstmt2.setString(2, "wheelbalancing");
			custadded=pstmt2.executeUpdate();
		}
		if(service.getDecors().equals("true")) {
			pstmt2.setString(2, "decors");
			custadded=pstmt2.executeUpdate();
		}
		custadded=pstmt2.executeUpdate();
		Logger log=Logger.getLogger("second");
		log.info("customer name: "+cust.getCustomerName()+"Phone number: "+cust.getPhoneNumber()+"car number: "+cust.getCarNumber()+"services: "+service);
		return custadded;
	}

	public Customer retreiveDetails(String mobileNumber) throws Exception {
		Customer cus=null;
		//System.out.println("gg");
		String sql="select * from customerk where phonenumber=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, mobileNumber);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			String customerName=rs.getString("cusname");
			String carNumber=rs.getString("carnumber");
			
			Car ct=retreiveServiceDetails(carNumber);
			cus=new Customer(customerName,mobileNumber,carNumber,ct);
			
		}
		System.out.println(cus);
		return cus;
	}

	public Car retreiveServiceDetails(String carNumber) throws Exception {
	
		Car car=new Car();
		String sql="select * from carservices where carnumber=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, carNumber);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			String service=rs.getString("services");
			//Car car= cust.getServiceList();
			if(service.equals("polishing")) {
				car.setPolishing("polishing");
			}
			if(service.equals("wheelbalancing")) {
				car.setWheelBalancing("wheelBalancing");
			}
			if(service.equals("decors")) {
				car.setDecors("decors");
			}
		}
		System.out.println(car);
		return car;
	}
	
}