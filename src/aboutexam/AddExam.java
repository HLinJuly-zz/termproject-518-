package aboutexam;
import dao.ExamDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddExam
 */
//@WebServlet("/AddExam")
public class AddExam extends HttpServlet {

	public void init() throws ServletException{
		System.out.println("add exam");
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//test
		System.out.println("into addexam?");
		String eName = request.getParameter("eName");
	 String e1 = request.getParameter("q1");
	 String e6 = request.getParameter("q6");
	 String e2 = request.getParameter("q2");
	 String e3 = request.getParameter("q3");
	 String e4 = request.getParameter("q4");
	 String e5 = request.getParameter("q5");


	 String info_addexam = "";
	 
	 ExamDAO addexam = new ExamDAO();
	 
	 if(eName.equals("")|| eName.equals(null)){
		 request.getSession().setAttribute("info_addexam", "Enter the name of the exam");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");
		 
	 } else if (e1.equals("")|| e1.equals(null)){
		 
		 request.getSession().setAttribute("info_addexam", "Enter the number of the question 1");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");		 
	 } else if (e2.equals("")|| e2.equals(null)){
		 
		 request.getSession().setAttribute("info_addexam", "Enter the number of the question 2");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");		 
	 } else if (e3.equals("")|| e3.equals(null)){
		 
		 request.getSession().setAttribute("info_addexam", "Enter the number of the question 3");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");		 
	 } else if (e4.equals("")|| e4.equals(null)){
		 
		 request.getSession().setAttribute("info_addexam", "Enter the number of the question 4");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");		 
	 } else if (e5.equals("")|| e5.equals(null)){
		 
		 request.getSession().setAttribute("info_addexam", "Enter the number of the question 5");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");		 
	 } else if (e6.equals("")|| e6.equals(null)){
		 
		 request.getSession().setAttribute("info_addexam", "Enter the number of the question 6");
		 response.sendRedirect("/termproject/instructor/addexam.jsp");		 
	 } else {
		 int q1 = Integer.parseInt(e1);
		 int q2 = Integer.parseInt(request.getParameter("q2"));
		 int q3 = Integer.parseInt(request.getParameter("q3"));
		 int q4 = Integer.parseInt(request.getParameter("q4"));
		 int q5 = Integer.parseInt(request.getParameter("q5"));
		 int q6 = Integer.parseInt(request.getParameter("q6"));
		 
		 if(addexam.checkQuestionExist(q1)&&addexam.checkQuestionExist(q2)&&addexam.checkQuestionExist(q3)&&addexam.checkQuestionExist(q4)&&addexam.checkQuestionExist(q5)&&addexam.checkQuestionExist(q6)){
		 addexam.insertNewExam(eName, q1, q2, q3, q4, q5, q6);
		 request.getSession().setAttribute("eName", eName);
		 request.getSession().setAttribute("q1", q1);		 
		 request.getSession().setAttribute("q2", q2);
		 request.getSession().setAttribute("q3", q3);
		 request.getSession().setAttribute("q4", q4);
		 request.getSession().setAttribute("q5", q5);
		 request.getSession().setAttribute("q6", q6);
		 response.sendRedirect("/termproject/instructorlogin.jsp");
		 }
		 else{
			 request.getSession().setAttribute("info_addexam", "the number of question is wrong");
			 response.sendRedirect("/termproject/instructor/addexam.jsp");	
			 
			 
		 }
	 
	 }
		 
	 
	 
	 
	 
	}

}
