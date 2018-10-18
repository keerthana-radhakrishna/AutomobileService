package com.training.ifaces;

import java.util.List;

import com.training.entity.Car;
import com.training.entity.Customer;

public interface DAO {

	public boolean checkCredentials(String username,String password) throws Exception;
	public int registerEmp(String username,String password,String empid) throws Exception;
	public int addCustomer(Customer cust) throws Exception;
	public Customer retreiveDetails(String mobileNumber) throws Exception;
	public Car retreiveServiceDetails(String carNumber)throws Exception;
}
