package com.training.entity;

import java.util.List;

public class Customer {

	private String customerName;
	private String phoneNumber;
	private String carNumber;
	private Car serviceList;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerName, String phoneNumber, String carNumber, Car serviceList) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.carNumber = carNumber;
		this.serviceList = serviceList;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public Car getServiceList() {
		return serviceList;
	}
	public void setServiceList(Car serviceList) {
		this.serviceList = serviceList;
	}
	
	public Customer(String customerName, String phoneNumber, String carNumber) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.carNumber = carNumber;
	}
	@Override
	public String toString() {
		return "ServiceComapny [customerName=" + customerName + ", phoneNumber=" + phoneNumber + ", carNumber="
				+ carNumber + ", serviceList=" + serviceList + "]";
	}
	
}
