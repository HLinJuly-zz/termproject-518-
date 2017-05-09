package model;

import java.io.Serializable;


public class TakeExam implements Serializable{
	
	private int tId;
	private int eId;
	private String username;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String a5;
	private String a6;
	
	public TakeExam(){
		this.tId = -1;
		this.eId = -1;
		this.username = null;
		this.a1 = null;
		this.a2 = null;
		this.a3 = null;
		this.a4 = null;
		this.a5 = null;
		this.a6 = null;		
		
	}
	
	public TakeExam(int t_id, int t_eid, String t_username, String t_a1, String t_a2, String t_a3, String t_a4, String t_a5, String t_a6){
		
		this.tId = t_id;
		this.eId = t_eid;
		this.username = t_username;
		this.a1 = t_a1;
		this.a2 = t_a2;
		this.a3 = t_a3;
		this.a4 = t_a4;
		this.a5 = t_a5;
		this.a6 = t_a6;
		
	}
	
	public int getTId(){
		
		return tId;
	}
	
	public void setTId(int id){
		
		this.tId = id;
	}

	public int getEId(){
		
		return eId;
	}
	
	public void setEId(int id){
		
		this.eId = id;
	}
	
	public String getUserName(){
		
		return username;
	}
	
	public void setUserName(String name){
		
		this.username = name;
	}
	
	public String getA1(){
		
		return a1;
	}
	public void setA1(String a1){
		
		this.a1 = a1;
	}
	
	public String getA2(){
		
		return a2;
	}
	public void setA2(String a2){
		
		this.a2 = a2;
	}
	
	public String getA3(){
		
		return a3;
	}
	public void setA3(String a3){
		
		this.a3 = a3;
	}
	
	public String getA4(){
		
		return a4;
	}
	public void setA4(String a4){
		
		this.a4 = a4;
	}
	
	public String getA5(){
		
		return a5;
	}
	public void setA5(String a5){
		
		this.a5 = a5;
	}
	
	public String getA6(){
		
		return a6;
	}
	public void setA6(String a6){
		
		this.a6 = a6;
	}
	
	
}
