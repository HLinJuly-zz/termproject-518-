package aboutexam;

import dao.QuestionsDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddQuestionServlet
 */
//@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    // to control the version?   
    /**
     * @see HttpServlet#HttpServlet()
     
    public AddQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void init() throws ServletException{
		System.out.println("add question");
		
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//use post because the data will be big
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//System.out.println("begin to add a question");
		//numerical some parameter is null
		String role = request.getParameter("role");
		String question = request.getParameter("question");
		String qRA = request.getParameter("rightA");
		String qWA1 = request.getParameter("wrongA1");
		String qWA2 = request.getParameter("wrongA2");
		String qWA3 = request.getParameter("wrongA3");
		String qH1 = request.getParameter("hint1");
		String qH2 = request.getParameter("hint2");		
		String qH3 = request.getParameter("hint3");
		
		QuestionsDAO  qDao_add = new QuestionsDAO();
		if(role.equals("multiple")){
		

			
			if(question.equals("")||question.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter question");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");
			} else if (qRA.equals("")||qRA.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the right answer");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");				
			} else if (qWA1.equals("")||qWA1.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the wrong answer");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");					
			} else if (qWA2.equals("")||qWA2.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the wrong answer");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");					
			} else if (qWA3.equals("")||qWA3.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the wrong answer");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");					
			}  else if (qH1.equals("")||qH1.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the hint");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");					
			}  else if (qH2.equals("")||qH2.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the hint");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");					
			}  else if (qH3.equals("")||qH3.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the hint");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");					
			}//qR,qWs should be not the same  
			/*else if (qDao_add.checkAnswerDifferent(qRA, qWA1, qWA2, qWA3)){
				request.getSession().setAttribute("info_addq", "The answers should be different");
				response.sendRedirect("/termproject/instructor/addMQ.jsp");
			}*/
			
			else {
				//insert new question
				qDao_add.insertNewQuestion(role, question,qRA, qWA1, qWA2, qWA3, qH1, qH2, qH3);
				request.getSession().setAttribute("qRole", role);
				request.getSession().setAttribute("question", question);
                request.getSession().setAttribute("qRA", qRA);
				request.getSession().setAttribute("qWA1", qWA1);
				request.getSession().setAttribute("qWA2", qWA2);
				request.getSession().setAttribute("qWA3", qWA3);
				request.getSession().setAttribute("qH1", qH1);
				request.getSession().setAttribute("qH2", qH2);
				request.getSession().setAttribute("qH3", qH3);
				response.sendRedirect("/termproject/instructorlogin.jsp");

				
			}		
		}
		else {
			if(question.equals("")||question.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter question");
				response.sendRedirect("/termproject/instructor/addNQ.jsp");
			} else if (qRA.equals("")||qRA.equals(null)){
				
				request.getSession().setAttribute("info_addq", "Enter the right answer");
				response.sendRedirect("/termproject/instructor/addNQ.jsp");				
			}else{				
				//insert new question
				qDao_add.insertNewQuestion(role, question,qRA, qWA1, qWA2, qWA3, qH1, qH2, qH3);
				request.getSession().setAttribute("qRole", role);
				request.getSession().setAttribute("question", question);
                request.getSession().setAttribute("qRA", qRA);
				request.getSession().setAttribute("qWA1", qWA1);
				request.getSession().setAttribute("qWA2", qWA2);
				request.getSession().setAttribute("qWA3", qWA3);
				request.getSession().setAttribute("qH1", qH1);
				request.getSession().setAttribute("qH2", qH2);
				request.getSession().setAttribute("qH3", qH3);
				response.sendRedirect("/termproject/instructorlogin.jsp");
			}
			
			
		}

    }
}
