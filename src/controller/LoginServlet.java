package controller;
import model.User;
import dao.AuthDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	public void init(ServletConfig config)throws ServletException{
		System.out.println("beginLogin");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String info="";
		int id = 0;
		
		AuthDAO auth_login=new AuthDAO();
		
		if((username.equals("")||username.equals(null))&&(password.equals("")||password.equals(null))){
			request.getSession().setAttribute("info", "please input the username and the password");
			response.sendRedirect("/termproject/login.jsp");
			
		} else if (username.equals("")||username.equals(null)){			
			request.getSession().setAttribute("info", "please input the username");
			response.sendRedirect("/termproject/login.jsp");	
		} else if (username.equals(null)&&password.equals(null)){
			request.getSession().setAttribute("info", "please input the username and the password");
			response.sendRedirect("/termproject/login.jsp");
		}else if ((id=auth_login.checkUserPass(username, password, role))!=-1){
			//System.out.println("this is also a test");
			User newuser = new User();
			newuser = auth_login.getUserById(id);
			request.getSession().setAttribute("username", newuser.getUsername());
			request.getSession().setAttribute("role", newuser.getRole());
			request.getSession().setAttribute("firstname", newuser.getFirstName());
            request.getSession().setAttribute("lastname", newuser.getLastName());
            if(role.equals("instructor")){
            	response.sendRedirect("/termproject/instructorlogin.jsp");
            }
            else if(role.equals("student")){
            	response.sendRedirect("/termproject/studentlogin.jsp");
            }
            else{
			response.sendRedirect("/termproject/TAlogin.jsp");
			}
            
						
		}
		else {
			request.getSession().setAttribute("info", "Invalid input");
			response.sendRedirect("/termproject/login.jsp");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
	
}
