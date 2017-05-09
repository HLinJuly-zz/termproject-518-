package dao;
import model.Question;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class QuestionsDAO {

	
	public static boolean checkAnswerDifferent(String a, String b, String c, String d){
	
		
		if(a==b){
					
					return false;
				}else if(a==c){
					return false;
				}else if (a==d){
					
					return false;
				}
				else if(b==c){
					return false;
				}else if(b==d){
					return false;
				}else if(d==c){
					return false;
				}
				
				//return true;
			
		

		return true;
		}		
	
		
		
		
		
	
	
	
	public static Question getQuestionById(int qId){
		//return a question object by qId
		String q_role = null;
		String q_question = null;
		String q_RA = null;
		String q_WA1 = null;
		String q_WA2 = null;
		String q_WA3 = null;
		String q_H1 = null;
		String q_H2 = null;	
		String q_H3 = null;
		
		
		//Question question = new Question();
		int q_id = 0;
		//int q_id2 = 0;
		
		Connection connect = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			
			System.out.println("driver doesn't work");
		}
		try{
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/term","root", "063374");
		}catch(SQLException e){
			System.out.println("cannot connect to database");
		}
		try{
			Statement smt = connect.createStatement();
			ResultSet rs= smt.executeQuery("select * from questions");
			while(rs.next()){
				
				q_role = rs.getString("qRole");
				q_question = rs.getString("question");
				q_id = rs.getInt("qId");
				if(q_id==qId){
				//to be continue
				
				q_RA = rs.getString("qRA");
				q_WA1 = rs.getString("qWA1");
				q_WA2 = rs.getString("qWA2");
				q_WA3 = rs.getString("qWA3");
				q_H1 = rs.getString("qH1");
				q_H2 = rs.getString("qH2");
				q_H3 = rs.getString("qH3");	
				break;
				}	
				}
				
			}catch (SQLException e) {
				System.out.println("cannot search");
	}
		Question question = new Question();
		return question;
	}
	
	public static boolean insertNewQuestion(String role, String question, String qRA, String qWA1, String qWA2, String qWA3, String qH1, String qH2, String qH3){
		//insert a new question in DB. 
		//include multiple choice and numerical
		//return true if success else false
		Connection connect = null;
		String sql;
		int result;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("driver is not working");
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/term", "root", "063374");
		} catch (SQLException e) {
			System.out.println("can not connect to database");
		}
		try{
			int id = 1;
			Statement sm=connect.createStatement();
			ResultSet rs = sm.executeQuery("select * from questions");
			while(rs.next()){
				
				id++;
			}
			//System.out.println("sql insert");
			sql = "insert into questions(qId,qRole,question,qRA, qWA1, qWA2, qWA3, qH1, qH2, qH3) values('"+id+"','"+role+"','"+question+"','"+qRA+"','"+qWA1+"','"+qWA2+"','"+qWA3+"','"+qH1+"','"+qH2+"','"+qH3+"')";
			result = sm.executeUpdate(sql);
			if(result !=1){
				
				return false;
			}
			
		} catch(SQLException e){
			
			System.out.println("failded to insert");
		}
	return true;	
	}
	
	//delete the question by id
	//to be continue
	
}
