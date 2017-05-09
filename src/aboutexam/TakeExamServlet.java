package aboutexam;

import dao.*;
import aboutexam.*;
import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;



/**
 * Servlet implementation class TakeExamServlet
 */
//@WebServlet("/TakeExamServlet")
public class TakeExamServlet extends HttpServlet {
	
	public void init(ServletConfig config)throws ServletException{
		System.out.println("begin a exam");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	// different jsp for different type question
		
		System.out.println("into takeexamservlet");
		
		String username = (String)request.getSession().getAttribute("username");
		
	    int eId = (int)request.getSession().getAttribute("eId");
	    
	    ExamDAO examDAO = new ExamDAO();
	    
	    
	    System.out.println(eId);
	    Exam newexam = new Exam();
	    newexam = examDAO.getExamById(eId);
	    
	    int q1No = newexam.getQ1();
	    int q2No = newexam.getQ2();
	    int q3No = newexam.getQ3();
	    int q4No = newexam.getQ4();
	    int q5No = newexam.getQ5();
	    int q6No = newexam.getQ6();
	    
	    
	    System.out.println(q6No);
	    
	    //add the qId to a list for loop
	    List qNo  = new ArrayList();
	    //qNo = new List();
	    qNo.add(q1No);
	    qNo.add(q2No);
	    qNo.add(q3No);
	    qNo.add(q4No);
	    qNo.add(q5No);
	    qNo.add(q6No);
	    
	    int w = (int)qNo.get(1);
	    
	    System.out.println(w);
	    
	    //get the answer
	    //List answerfirst = new ArrayList();
	    
	    
	    
	    QuestionsDAO questionDAO = new QuestionsDAO();
	    TakeExamDAO takeExamDao = new TakeExamDAO();
	    
        //i++ for every loop
        int i = (int)request.getSession().getAttribute("i")+1;
        
	    System.out.println(i);
        
	    //request.getSession().setAttribute("nQuestion", i);
	    //if i<7 loop for questions
	    if(i<7){
	        Question newQ = new Question();

		    //request.getSession().setAttribute("nQuestion", i);
	        int j = (int)qNo.get(i);
	        
	        //get the questionId
	        request.getSession().setAttribute("j", j);
		    System.out.println("in the loop");
	        System.out.println(j);
	        
	        
	        //get the question
	        newQ = questionDAO.getQuestionById(j);
	        request.getSession().setAttribute("question", newQ.getQuestion());
	        
	        
	        //the type of the question
	        request.getSession().setAttribute("type", newQ.getRole());
	        System.out.println("type");
	        String n = newQ.getRole();
	        //test
	        System.out.println(n);
	        if (newQ.getRole().equals("numerical")){
	        	
	        	response.sendRedirect("/termproject/answerNQ.jsp");
	        	
	        } else{
	        	
	        	//x means the times the mQ be answered
	        	request.getSession().setAttribute("x", 0);
	        	//options
	        	request.getSession().setAttribute("option1", newQ.getQRightA());
	        	request.getSession().setAttribute("option2", newQ.getQWrongA1());
	        	request.getSession().setAttribute("option3", newQ.getQWrongA2());
	        	request.getSession().setAttribute("option4", newQ.getQWrongA3());
	        	
	        	
	        	
	        	request.getSession().setAttribute("hint1", newQ.getHint1());
	        	request.getSession().setAttribute("hint2", newQ.getHint2());
	        	request.getSession().setAttribute("hint3", newQ.getHint3());
	        	
	        	
	        	//answerfirst.add("mutiple");
	        	response.sendRedirect("/termproject/answerMQ.jsp");

	        }
	   
	    
	   }else {
		   //insert the answers to database
		   //to be continue
		   
		    List answerfirst  = new ArrayList();
		    //qNo = new List();
		   
		   for(int y=0;y<6;y++){
			   if((String)request.getSession().getAttribute("answer"+y)==null){
				   
				   answerfirst.add("Multiple");
				   
				   
			   }else{ 
				   String z = (String)request.getSession().getAttribute("answer"+y);
				   answerfirst.add(z);
			   }
			   
		   }
		   
		   String a1 = (String)answerfirst.get(0);
		   String a2 = (String)answerfirst.get(1);
		   String a3 = (String)answerfirst.get(2);
		   String a4 = (String)answerfirst.get(3);
		   String a5 = (String)answerfirst.get(4);
		   String a6 = (String)answerfirst.get(5);
		   
		   
		   
		   
		   //insert to database
		   takeExamDao.inputAnswer(eId, username, a1, a2, a3, a4, a5, a6);
		   response.sendRedirect("/termproject/examOver.jsp");
	   }
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
