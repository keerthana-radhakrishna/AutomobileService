package com.training;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.training.ifaces.DAO;
import com.training.ifaces.DAOImpl;


/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginServlet() {
        // TODO Auto-generated constructor stub
    }
    Connection con;

	@Override
	public void init() throws ServletException {
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		DAO dao= new DAOImpl();
		HttpSession session=request.getSession();
		String checkRequest=(String) session.getAttribute("checkRequest");
		 boolean isValidUser=false;
		if(checkRequest.equals("Login")) {
		String uname=request.getParameter("empName");
		String pword=request.getParameter("password");
		
			try {
				//System.out.println(isValidUser);
				isValidUser = dao.checkCredentials(uname, pword);
				//System.out.println(isValidUser);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		int newUser=0;
		if(checkRequest.equals("register")) {
		String usname=request.getParameter("Name");
		String psword=request.getParameter("passWord");
		String empid=request.getParameter("empId");
		//int id=Integer.parseInt(empid);
	
	
		try {
			newUser=dao.registerEmp(usname, psword, empid);
			//newUser=1;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}
		
//		System.out.println(pword);
		
	String errorMessage="Invalid username or password";
	
		RequestDispatcher dispatcher = null;
		
		request.setAttribute("errMsg", errorMessage);
		if(isValidUser || newUser==1){
			System.out.println(isValidUser);
			dispatcher=request.getRequestDispatcher("customer.html");
			
		}
	
		else{
			dispatcher=request.getRequestDispatcher("failure.jsp");
			
		}
		dispatcher.forward(request, response);
		//doGet(request, response);
	
	}

}
