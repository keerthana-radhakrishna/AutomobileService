package com.training.entity;

public class Car {

	private String polishing;
	private String wheelBalancing;
	private String decors;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String polishing, String wheelBalancing, String decors) {
		super();
		this.polishing = polishing;
		this.wheelBalancing = wheelBalancing;
		this.decors = decors;
	}
	public String getPolishing() {
		return polishing;
	}
	public void setPolishing(String polishing) {
		this.polishing = polishing;
	}
	public String getWheelBalancing() {
		return wheelBalancing;
	}
	public void setWheelBalancing(String wheelBalancing) {
		this.wheelBalancing = wheelBalancing;
	}
	public String getDecors() {
		return decors;
	}
	public void setDecors(String decors) {
		this.decors = decors;
	}
	@Override
	public String toString() {
		return "Car [polishing=" + polishing + ", wheelBalancing=" + wheelBalancing + ", decors=" + decors + "]";
	}

	
}
