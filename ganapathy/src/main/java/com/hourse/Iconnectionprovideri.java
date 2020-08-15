package com.hourse;

import java.sql.Connection;
import java.sql.DriverManager;

public class Iconnectionprovideri implements Iprovidei {
static Connection con=null;
	
	
	public static Connection getCon() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(connUrl,username,password);
			System.out.println("Connection Created"+con);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;

}

}
