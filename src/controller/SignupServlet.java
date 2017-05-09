package controller;

import dao.AuthDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignupServlet extends HttpServlet{

	public void init(ServletConfig config) throws ServletException{
		//test
		System.out.println("Signup");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("this is a test");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String info_signup = "";
//test name
		
		//System.out.println("role");

		AuthDAO auth_signup = new AuthDAO();

		if (username.equals("") || username.equals(null)) {
			request.getSession().setAttribute("info_signup", "Enter username");
			response.sendRedirect("/termproject/signup.jsp");
		} else if (password.equals("") || password.equals(null)) {
			request.getSession().setAttribute("info_signup", "Enter password");
			response.sendRedirect("/termproject/signup.jsp");
		} else if (firstName.equals("") || firstName.equals(null)) {
			request.getSession().setAttribute("info_signup", "Enter FitstName");
			response.sendRedirect("/termproject/signup.jsp");
		} else if (lastName.equals("") || lastName.equals(null)) {
			request.getSession().setAttribute("info_signup", "Enter LastName");
			response.sendRedirect("/termproject/signup.jsp");
		} else {
			if (auth_signup.checkUserNameAvailable(username)) {
				auth_signup.enterNewUser(username, password, role, firstName, lastName);
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("role", role);
				request.getSession().setAttribute("firstname", firstName);
				request.getSession().setAttribute("lastname", lastName);
				response.sendRedirect("/termproject/successful.jsp");
			} else {
				request.getSession().setAttribute("info_signup", "Invalid username");
				response.sendRedirect("/termproject/signup.jsp");
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
