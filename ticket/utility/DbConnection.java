package com.ticket.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	/*public static void main(String[] args) {
		getConnection();
	}*/

	public static Connection con=null;
	public static Connection getConnection()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root123");
			System.out.println("connection establish");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//this id edited
			return con;
	}
	
}
