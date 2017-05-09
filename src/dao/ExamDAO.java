package dao;
import model.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ExamDAO {
	
	public static int checkExam(int id){
		
		Connection connect = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
			System.out.println("driver is not working");
		}
		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/term", "root", "063374");
		} catch(SQLException e){
			System.out.println("cannot connect to the database");			
		}
		try{
			Statement smt = connect.createStatement();
			ResultSet rs = smt.executeQuery("select * from exam");
			while(rs.next()){
				int e_id = rs.getInt("eId");
				if(e_id==id){
					return e_id;
				}
				//system.out.println(d_name + " " + d_password + " " +d_role);
				//system.out.println("test");
			}
		
		
	
	}catch (SQLException e){
		System.out.println("cannot find in the database");
	}
	return -1;
}
	
	
	public static Exam getExamById(int eId){
		//return a user object(with all attributes set) of user with Id==userId
		String e_name=null;
		int e_id=0;
		int e_q1 = 0;
		int e_q2 = 0;
		int e_q3 = 0;
		int e_q4 = 0;
		int e_q5 = 0;
		int e_q6 = 0;

		Connection connect=null;
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
			ResultSet rs= smt.executeQuery("select * from exam");
			//test
			//System.out.println(rs.next());
			while(rs.next()){
				e_name=rs.getString("eName");
				e_id=rs.getInt("eId");
				e_q1=rs.getInt("q1");
				e_q2=rs.getInt("q2");
				e_q3=rs.getInt("q3");
				e_q4=rs.getInt("q4");
				e_q5=rs.getInt("q5");
				e_q6=rs.getInt("q6");				
						
		}
	} catch (SQLException e) {
		System.out.println("cannot search");
	}



	Exam exam=new Exam(e_id,e_name, e_q1,e_q2, e_q3,e_q4,e_q5, e_q6);
	return exam;
	}
	
	//check the question exist or not
	public	static boolean checkQuestionExist(int qId){
		
		Connection connect = null;


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

		try {
			Statement smt = connect.createStatement();
			ResultSet rs = smt.executeQuery("select * from questions");
			while (rs.next()) {
				int q_Id = rs.getInt(qId);
				if(q_Id==qId) return true;
			}
		} catch (SQLException e) {
			System.out.println("can not search");
		}

		return false;
		
		
		
		
		
	}
	
	public static boolean insertNewExam(String eName, int q1, int q2, int q3, int q4, int q5, int q6){
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
			ResultSet rs = sm.executeQuery("select * from exam");
			while(rs.next()){
				
				id++;
			}
			//System.out.println("sql insert");
			sql = "insert into exam(eId,eName,q1,q2,q3,q4,q5,q6) values('"+id+"','"+eName+"','"+q1+"','"+q2+"','"+q3+"','"+q4+"','"+q5+"','"+q6+"')";
			result = sm.executeUpdate(sql);
			if(result !=1){
				
				return false;
			}
			
		} catch(SQLException e){
			
			System.out.println("failded to insert");
		}
	return true;	
	}
	//not finished
	//to be continue
	/*
	public static Question getQuestionByEidQnum(int eId, int qNum){
		
		String e_name=null;
		int e_id=0;
		int e_q1 = 0;
		int e_q2 = 0;
		int e_q3 = 0;
		int e_q4 = 0;
		int e_q5 = 0;
		int e_q6 = 0;

		Connection connect=null;
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
			ResultSet rs= smt.executeQuery("select * from exam");
			//test
			//System.out.println(rs.next());
			while(rs.next()){
				e_name=rs.getString("eName");
				e_id=rs.getInt("eId");
				e_q1=rs.getInt("q1");
				e_q2=rs.getInt("q2");
				e_q3=rs.getInt("q3");
				e_q4=rs.getInt("q4");
				e_q5=rs.getInt("q5");
				e_q6=rs.getInt("q6");				
						
		}
	} catch (SQLException e) {
		System.out.println("cannot search");
	}



	Question question =new Question (e_id,e_name, e_q1,e_q2, e_q3,e_q4,e_q5, e_q6);
	return question;
		
		
	}
	*/

}
