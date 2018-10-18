package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DAOImpl {
	Connection con;

	public DAOImpl() {
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/ds1");
			con=dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double getInsuranceAmt(String carNumber,String service) {
		double amt = 0.0;
		double netamt = 0.0;
		try {
			System.out.println(con);
			String sql="select * from insurancekr where carnumber=? and services=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, carNumber);
			ps.setString(2, service);
			//System.out.println("in dao"+carNumber);
			//System.out.println("in dao"+service);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				amt = rs.getDouble("amt");
			}
			netamt = calcNetAmt(amt,service);
		}
		
		catch (Exception e) {
				e.printStackTrace();
			}
		Logger log=Logger.getLogger("second");
		log.info("insurance amount: "+netamt);
		return netamt;
	}

	private double calcNetAmt(double amt,String service) {
		
		PreparedStatement pstm = null;
		double servicePrice = 0.0;
		double netAmount = 0.0;
		String sql = "select grossamt from serviceskr where services = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, service);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				servicePrice = rs.getDouble("grossamt");
			}
			netAmount = servicePrice - amt;
			//System.out.println(netAmount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return netAmount;
	}
}
