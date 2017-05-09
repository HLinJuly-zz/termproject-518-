package aboutexam;
import dao.ExamDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChooseExamServlet
 */
//@WebServlet("/ChooseExamServlet")
public class ChooseExamServlet extends HttpServlet {

	
	public void init(ServletConfig config)throws ServletException{
		System.out.println("choose a exam");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   String b = request.getParameter("cEId");
		
	   if(b.equals("")||b.equals(null)){
		   
		   request.getSession().setAttribute("info_chooseexam", "input the id of the exam");
	       response.sendRedirect("/termproject/chooseanexam.jsp");
	   } else{
	   
	   
		int examId = Integer.parseInt(b);
	    
	    String info_chooseexam = "";
	    
	    ExamDAO examDAO = new ExamDAO();
	    
	    int a = examDAO.checkExam(examId);
	    //if(a)
	    if(a!=-1){
	    	//begin the exam
	    	//the number of exam is examId
	    	request.getSession().setAttribute("eId",examId );
	    	
	    	
	    	//init the i to calculate the No. of questions.
	    	request.getSession().setAttribute("i", 0);
	    	
	    	response.sendRedirect("/termproject/beginexam.jsp");
	    	

	    	
	    } else {
	    	
	    	request.getSession().setAttribute("info_chooseexam", "input the real id of the exam");
	    	response.sendRedirect("/termproject/chooseanexam.jsp");
	    }
	   }
	    

	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
