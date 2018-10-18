package com.training.entity;

public class Employee {

	private String empName;
	private String password;
	private String empId;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName, String password, String empId) {
		super();
		this.empName = empName;
		this.password = password;
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", password=" + password + ", empId=" + empId + "]";
	}
	
}
