package com.hourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TemployeeDAOimpl implements TemployeeDAO {
	static Connection con;
	static PreparedStatement ps;
	public ArrayList<Foodmenu> getfooddetails(){
		ArrayList<Foodmenu> food=new ArrayList<Foodmenu>();
		try
		{
			con=Iconnectionprovideri.getCon();
			ps=con.prepareStatement("SELECT * FROM  foodlist.foodmenu WHERE categories='veg' ");

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Foodmenu f=new Foodmenu();
				f.setId(rs.getString("id"));
				f.setProductname(rs.getString("productname"));
				f.setProductdescription(rs.getString("productdescription"));
				f.setCategories(rs.getString("categories"));
				food.add(f);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return food;
		
	}

}
