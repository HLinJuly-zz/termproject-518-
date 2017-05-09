package model;
import java.io.Serializable;

public class Question {
	
	
	private int qId;//the id of the questions
	private String role;//multiple or numerical question
	private String question;//the question
	private String qRightA;//right answer
	private String qWrongA1;//wrong answer
	private String qWrongA2;
	private String qWrongA3;
	private String qHint1;//the hint after the wrong answer
	private String qHint2;
	private String qHint3;
	
	
	public Question(){
		this.qId = -1;
		this.role = null;
		this.question = null;
		this.qRightA = null;
		this.qWrongA1 = null;
		this.qWrongA2 = null;
		this.qWrongA3 = null;
		this.qHint1 = null;
		this.qHint2 = null;	
		this.qHint3 = null;
		
	}
	
	public Question(int q_id, String q_role, String q_question, String q_qRightA, String q_qWrongA1, String q_qWrongA2,String q_qWrongA3,String q_qHint1,String q_qHint2,String q_qHint3){
		
		this.qId = q_id;
		this.role = q_role;
		this.qRightA = q_qRightA;
		this.qWrongA1 = q_qWrongA1;
		this.qWrongA2 = q_qWrongA2;
		this.qWrongA3 = q_qWrongA3;
		this.qHint1 = q_qHint1;
		this.qHint2 = q_qHint2;
		this.qHint3 = q_qHint3;		
		
	}
	/*
	public Question(int q_id, String q_role, String q_question, String q_qRightA){
		
		this.qId = q_id;
		this.role = q_role;
		this.question = q_question;
		this.qRightA = q_qRightA;
		
	}
	*/
	
    public int getQId(){
    	
    	return qId;
    }
    public void setQId(int id){
    	
    	this.qId = id;
    }
    
    
    public String getRole(){
    	
    	return role;
    }
    public void setRole(String role){
    	
    	this.role = role;
    }
    
    
    public String getQuestion(){
    	
    	return question;
    }
    public void setQuestion(String question){
    	
    	this.question = question;
    }
    
    public String getQRightA(){
    	
    	return qRightA;
    }
    public void setQRightA(String qRightA){
    	
    	this.qRightA = qRightA;
    }
    
    public String getQWrongA1(){
    	
    	return qWrongA1;
    }
    public void setWrongA1(String qWrongA1){
    	
    	this.qWrongA1 = qWrongA1;
    }
    
    public String getQWrongA2(){
    	
    	return qWrongA2;
    }
    public void setWrongA2(String qWrongA2){
    	
    	this.qWrongA2 = qWrongA2;
    }
    
    public String getQWrongA3(){
    	
    	return qWrongA3;
    }
    public void setWrongA3(String qWrongA3){
    	
    	this.qWrongA3 = qWrongA3;
    }
    
    
    public String getHint1(){
    	
    	return qHint1;
    }
    public void setHint1(String hint1){
    	
    	this.qHint1 = hint1;
    }
    
    
    public String getHint2(){
    	
    	return qHint2;
    }
    public void setHint2(String hint2){
    	
    	this.qHint2 = hint2;
    }
    
    
    public String getHint3(){
    	
    	return qHint3;
    }
    public void setHint3(String hint3){
    	
    	this.qHint3 = hint3;
    }
	
	
}
