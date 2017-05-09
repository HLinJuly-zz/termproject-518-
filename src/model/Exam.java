package model;
import java.io.Serializable;

public class Exam implements Serializable{
	
	private int examId;
	private String eName;
	private int q1;
	private int q2;
	private int q3;
	private int q4;
	private int q5;
	private int q6;
	
	public Exam(){
		this.examId = -1;
		this.eName = null;
		this.q1 = 0;
		this.q2 = 0;
		this.q3 = 0;
		this.q4 = 0;
		this.q5 = 0;
		this.q6 = 0;	
		
	}
	
	public Exam(int e_id, String e_name, int e_q1, int e_q2, int e_q3, int e_q4, int e_q5, int e_q6){
		this.examId = e_id;
		this.eName = e_name;
		this.q1 = e_q1;
		this.q2 = e_q2;
		this.q3 = e_q3;
		this.q4 = e_q4;
		this.q5 = e_q5;
		this.q6 = e_q6;	
		
	}
	
	
	
	public int getExamId(){
		return examId;
	}
	public void setExamId(){
		this.examId = examId;		
	}
	
	public String getEName(){
		return eName;
	}
	
	public void setEName(){
		
		this.eName = eName;
	}
	
	public int getQ1(){
		return q1;
	}
	public void setQ1(){
		this.q1 = q1;		
	}
	
	public int getQ2(){
		return q2;
	}
	public void setQ2(){
		this.q2 = q2;		
	}
	
	public int getQ3(){
		return q3;
	}
	public void setQ3(){
		this.q3 = q3;		
	}
	
	public int getQ4(){
		return q4;
	}
	public void setQ4(){
		this.q4 = q4;		
	}
	
	public int getQ5(){
		return q5;
	}
	public void setQ5(){
		this.q5 = q5;		
	}
	
	public int getQ6(){
		return q6;
	}
	public void setQ6(){
		this.q6 = q6;		
	}
	
	
	
	
}
