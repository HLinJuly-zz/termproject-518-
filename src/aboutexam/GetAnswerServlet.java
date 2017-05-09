package aboutexam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionsDAO;
import dao.TakeExamDAO;
import model.Question;

/**
 * Servlet implementation class GetAnswerServlet
 */
//@WebServlet("/GetAnswerServlet")
public class GetAnswerServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException{
		//test
		System.out.println("get the answer");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        //the No. of the question
		int i = (int)request.getSession().getAttribute("i");
        
        //save the answer to a list??
	    //List answer = new ArrayList();
        
	    //get the questionId
        int j = (int)request.getSession().getAttribute("j");
        
	    QuestionsDAO questionDAO = new QuestionsDAO();
	    TakeExamDAO takeExamDao = new TakeExamDAO();
        
        Question newQ = new Question();
        newQ = questionDAO.getQuestionById(j);
        
	    String type = (String)request.getSession().getAttribute("type");
	    
	    
	    
	    if(type.equals("numerical")){
	    	
	    	//input the answer of question i 
	    	//??how
	    	String answer = request.getParameter("answerQ");
	    	
            //answer of question i set in session answeri 
	    	request.getSession().setAttribute("answer"+i, answer);
	    	response.sendRedirect("/termproject/nextQ.jsp");
	    	
	    }else{
	    	//the times answered
	    	int x = (int)request.getSession().getAttribute("x") +1;
	    	
        	String answer = request.getParameter("answerMQ");
        	
        	//get the parameter of the question
        	if(answer.equals(newQ.getQRightA())){
        		
        		request.getSession().setAttribute("feedback", "the answer is right");
    	    	response.sendRedirect("/termproject/nextQ.jsp");
        		
        	} else {
        		if(x ==1){
        			
        			String hint1 = (String)request.getSession().getAttribute("hint1");
            		request.getSession().setAttribute("feedback", "the answer is wrong");
            		request.getSession().setAttribute("hint", hint1);
    	        	response.sendRedirect("/termproject/answerMQ.jsp");	
        			
        		} else if(x ==2){
        			
        			String hint2 = (String)request.getSession().getAttribute("hint2");
            		request.getSession().setAttribute("feedback", "the answer is wrong");
            		request.getSession().setAttribute("hint", hint2);
    	        	response.sendRedirect("/termproject/answerMQ.jsp");	
        			
        		}  else if(x ==3){
        			
        			String hint3 = (String)request.getSession().getAttribute("hint3");
            		request.getSession().setAttribute("feedback", "the answer is wrong");
            		request.getSession().setAttribute("hint", hint3);
    	        	response.sendRedirect("/termproject/answerMQ.jsp");	
        			
        		} else{
        			request.getSession().setAttribute("feedback", "still wrong");
        			String hint4 = (String)request.getSession().getAttribute("option1");
            		request.getSession().setAttribute("hint", hint4);
        	    	response.sendRedirect("/termproject/nextQ.jsp");
        		}
        		
        		
        		
	        	response.sendRedirect("/termproject/answerMQ.jsp");
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
