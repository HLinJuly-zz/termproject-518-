package controller;
import model.User;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException{
		//test
		System.out.println("Logout");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
		
        //System.out.println("test logout");
		
		String info="";	
		request.getSession().setAttribute("info", "Successfully log out.");;
		//hs.setMaxInactiveInterval(5);
		
		//System.out.println("this is a test");
		//System.out.println("index");
		//hs.setAttribute("info", "Successfully logged out.");
		//User user = (User)request.getSession().getAttribute("user");
		//user.setLoggedin(false);
		//response.setContentType("text/html");
		System.out.println("text index");
		response.sendRedirect("/termproject/index.jsp");
		System.out.println(info);
		//request.getSession().removeAttribute("user");

	}
	
}
