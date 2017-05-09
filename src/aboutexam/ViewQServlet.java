package aboutexam;
import dao.QuestionsDAO;
import model.Question;

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
public class ViewQServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	/*	
	int pageNow = 1;
	String s_pageNow = request.getParameter("pageNow");
	if(s_pageNow!=null){
		
		pageNow = Integer.parseInt(s_pageNow);
	}
	//5:5questions one page
	QuestionsDAO questionsDao = new QuestionsDAO();
	ArrayList al = questionsDao.getQuestionsByPage(pageNow, 5);
	int pageCount = questionsDao.getPageCount(5);
	
	request.setAttribute("al", al);
	request.setAttribute("pageCount", pageCount);
	
	request.getRequestDispatcher("/instructor/viewquestion.jsp").forward(request, response);
	
	*/
		
		//int pageSize = 3;
		//int pageNow = 1;
		//int rowCount=0;
		//int pageCount=0;
		
		
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
			//数据库检索
			
			rs = st.executeQuery("select count(*) from questions");// questions
			//System.out.println(rs);
			System.out.println("viewQS1");
			//rs = ps.executeQuery();
			//System.out.println("viewQS2");
			

			/*
			//pagecount
			if(rowCount%pageSize ==0){
				
				pageCount =  rowCount/pageSize;
			}else{
				pageCount = rowCount/pageSize+1;
			}
			//System.out.println(rowCount);get
			//System.out.println(pageCount);get
			
			//数据库检索不到??
			st = ct.createStatement();
			System.out.println("viewQS2");
			//rs = st.executeQuery("select top 3 * from questions where qId not in (select top "+pageSize*(pageNow -1)+" qId from questions)");
			PrintWriter pw = response.getWriter();
			System.out.println("viewQS3");
			
			pw.println("<html>");
			pw.println("<table>");
			pw.println("<tr><th>Id</th><th>type</th><th>question</th></tr>");
			//don't show the question
			System.out.println("viewQS4");
			while (rs.next()){
				pw.println("<tr>");
				System.out.println("this in the while");
				pw.println("this is a test");
				pw.println("<td>"+rs.getInt("qId")+"</td>");
				pw.println("<td>"+rs.getString("qRole")+"</td>");				
				pw.println("<td>"+rs.getString("question")+"</td>");
				pw.println("</tr>");
				
			}
			pw.println("</table><br>");
			
			if(pageNow !=1)
				pw.println("<a href=ViewQServlot?pageNow="+(pageNow-1)+" >last</a>");
				
				
				for(int j = pageNow;j<=pageNow+pageSize-1; j ++)
				{
					pw.println("<a href=ViewQServlot?pageNow="+j+" > <"+j+"> </a>");
				}
				//
				//int pageCount = udao.getPageCount();
				
				if(pageNow != pageCount)
				pw.println("<a href=ViewQServlot?pageNow="+(pageNow+1)+" >next</a><br><br>");
				
			

			
			pw.println("</html>");
			*/
			QuestionsDAO qDao = new QuestionsDAO();
			Question q = new Question();
			//List all = qdao.getQuestionById
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<img src = '/termproject/css/image/welcome.jpg' ><br>");
			//pw.println("<link rel="stylesheet" type ="text/css" href="/termproject/css/style.css">");
			pw.println("the questions list");
			pw.println("<table>");
			pw.println("<tr><th>Id</th><th>type</th><th>question</th></tr>");
			
			int i = 1;
			st = ct.createStatement();
			//System.out.println("viewQS0");
			//数据库检索
			
			rs = st.executeQuery("select * from questions");
			
			/*
			if(i<rowCount+1){
				q = qDao.getQuestionById(i);
				pw.println("<tr>");
				//System.out.println("this in the while");
				pw.println("this is a test");
				//System.out.println(rs.next());
				pw.println("<td>"+q.getQId()+"</td>");
				pw.println("<td>"+q.getRole()+"</td>");				
				pw.println("<td>"+q.getQuestion()+"</td>");
				pw.println("</tr>");
				*/
			while(rs.next()){
				pw.println("<tr>");
				//System.out.println("this in the while");
				//pw.println("this is a test");
				//System.out.println(rs.next());
				pw.println("<td>"+rs.getInt("qId")+"</td>");
				pw.println("<td>"+rs.getString("qRole")+"</td>");				
				pw.println("<td>"+rs.getString("question")+"</td>");
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
