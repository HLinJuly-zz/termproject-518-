package aboutexam;
import dao.QuestionsDAO;
import model.Question;
import dao.ExamDAO;
import model.Exam;

import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import dao.QuestionsDAO;

/**
 * Servlet implementation class ViewQServlet
 */
//@WebServlet("/ViewQServlet")
public class ViewEServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		
		
		Connection ct = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		//ViewQServlet
		
		//System.out.println("viewQS");
		try{
			//System.out.println("viewQS");
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
			System.out.println("driver is not working");
		}
		try{
			ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/term", "root", "063374");
		} catch(SQLException e){
			System.out.println("cannot connect to the database");			
		}
		try{
			System.out.println("viewQS");
			st = ct.createStatement();
			System.out.println("viewQS0");
			//search in the database
			
			rs = st.executeQuery("select count(*) from exam");// questions
			//System.out.println(rs);
			System.out.println("viewQS1");
			//rs = ps.executeQuery();
			//System.out.println("viewQS2");
			

		

			ExamDAO eDao = new ExamDAO();
			Question q = new Question();
			//List all = qdao.getQuestionById
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<img src = '/termproject/css/image/welcome.jpg' ><br>");
			//pw.println("<link rel="stylesheet" type ="text/css" href="/termproject/css/style.css">");
			pw.println("the exam list");
			pw.println("<table>");
			pw.println("<tr><th>Id</th><th>name</th></tr>");
			
			int i = 1;
			st = ct.createStatement();
			//System.out.println("viewQS0");
			//search in the database
			
			rs = st.executeQuery("select * from exam");
			
			while(rs.next()){
				pw.println("<tr>");
				//System.out.println("this in the while");
				//pw.println("this is a test");
				//System.out.println(rs.next());
				pw.println("<td>"+rs.getInt("eId")+"</td>");
				pw.println("<td>"+rs.getString("eName")+"</td>");				
				//pw.println("<td>"+rs.getString("question")+"</td>");
				pw.println("</tr>");
				
				
			}
				
			
			pw.println("</table><br>");
			pw.println("</html>");
			
		}catch (SQLException e){
			System.out.println("cannot find in the database");
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
