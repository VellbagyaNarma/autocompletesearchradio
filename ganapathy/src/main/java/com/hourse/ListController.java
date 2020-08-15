package com.hourse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
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
		doGet(request, response);
		
		TemployeeDAOimpl cd=new TemployeeDAOimpl();
		System.out.println("welcome to the listcontroller");
//		      InputStream is=request.getInputStream();
//		ByteArrayOutputStream os=new ByteArrayOutputStream();
//		byte[] buf = new byte[32];
//        int r=0;
//        while( r >= 0 ) {
//            r = is.read(buf);
//            if( r >= 0 ) os.write(buf, 0, r);
//        }
//        String s = new String(os.toByteArray(), "UTF-8");
//        String decoded = URLDecoder.decode(s, "UTF-8");
//        System.err.println(">>>>>>>>>>>>> DECODED: " + decoded);
//
//        System.err.println("================================");
//
//       Enumeration<String> e = request.getParameterNames();
//       System.out.println(e);
//        System.out.println("requestgetparameternames");
//       while( e.hasMoreElements() ) {
//           String ss = (String) e.nextElement();
//          System.err.println("    >>>>>>>>> " + ss);
//        }
//
//        System.err.println("================================");
//
//       Map<String,String> map = querying.makeQueryMap(s);
//       System.err.println(map);
//		
//		String categories=map.get("categories");
//		System.out.println(categories);
//       // String categories=decoded.categories;
		ArrayList<Foodmenu> Foodies=cd.getfooddetails();
		 Gson gson = new Gson();
		for(Foodmenu fo:Foodies)
		{
			System.out.println(fo.getProductname());
			System.out.println(fo.getProductdescription());
			System.out.println(fo.getCategories());
			
		}
		   String jsonarrayy=gson.toJson(Foodies);
		   System.out.println(jsonarrayy);
		   PrintWriter out=response.getWriter();
		   response.setContentType("application/json");
		   response.setCharacterEncoding("UTF-8");
		   
		   out.print(jsonarrayy)  ;
		   
	        
	        
	}

}
