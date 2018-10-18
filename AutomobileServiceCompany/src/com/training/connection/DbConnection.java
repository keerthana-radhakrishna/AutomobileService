package com.training.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {
	
	private Connection con;
	public Connection getConnection() {
	try {
		Context ctx=new InitialContext();
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		try {
			con=dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	} catch (NamingException e) {
		
		e.printStackTrace();
	}
	return con;
	}
}
