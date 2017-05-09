package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class TakeExamDAO {

	
	
	/*
	public static boolean editAnswer(int tId, int n, String answer){
		//will be changed the answer
		String name=null ;
		if(n==1){
			
			name = "a1";
		}else if(n==2){
			
			name = "a2";
		}else if(n==3){
			
			name = "a3";
		}else if(n==4){
			
			name = "a4";
		}else if(n==5){
			
			name = "a5";
		}else if(n==6){
			
			name = "a6";
		}
		
		
		Connection connect = null;
		String sql;
		int result;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("driver is not working");
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/term", "root", "063374");
		} catch (SQLException e) {
			System.out.println("can not connect to database");
		}
		try {
			
			int id = 1;
			Statement sm=connect.createStatement();
			ResultSet rs = sm.executeQuery("select * from takeexam");
            //edit 
			sql = "UPDATA takeexam set "+name+" = 'answer' where tId = 'tId'";
			result = sm.executeUpdate(sql);
			
		}catch(SQLException e){
			
			System.out.println("failded to change");
		}
		return true;
	}
		
		*/
		
	
	
	public static boolean inputAnswer(int eId, String username, String a1, String a2,  String a3,  String a4,  String a5,  String a6 ){
		
		Connection connect = null;
		String sql;
		int result;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("driver is not working");
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/term", "root", "063374");
		} catch (SQLException e) {
			System.out.println("can not connect to database");
		}
		try {
			
			int id = 1;
			Statement sm=connect.createStatement();
			ResultSet rs = sm.executeQuery("select * from takeexam");
			while(rs.next()){
				
				id++;
			}
			sql = "insert into takeexam(tId, eId, username, a1,a2,a3,a4,a5,a6) values('"+id+"','"+eId+"','"+username+"','"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"')";
			result = sm.executeUpdate(sql);
			
		}catch(SQLException e){
			
			System.out.println("failded to insert");
		}
		return true;
	}
}
