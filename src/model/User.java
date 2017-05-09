package model;

import java.io.Serializable;

public class User implements Serializable{
	private int userid;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private boolean loggedin;
	
	public User(){
		this.userid=-1;
		this.username=null;
		this.password=null;
		this.firstName=null;
		this.lastName=null;
		this.role=null;//edited
		this.loggedin=false;
	}

	public User(int d_id, String d_userName, String d_password, String d_role, String d_firstName, String d_lastName){
		
		this.userid=d_id;
		this.username=d_userName;
		this.password=d_password;
		this.firstName=d_firstName;
		this.lastName=d_lastName;
		this.role=d_role;
		this.loggedin=true;
		
	}
	public void setId(int id){
		this.userid=id;
	}
	public void setUsername(String userName){
		this.username=userName;
	}
	public void setPassword(String passWord){
		this.password=passWord;
	}
	public void setFirstname(String firstname){
		this.firstName=firstname;
	}
	public void setLastname(String lastname){
		this.lastName=lastname;
	}
	public void setRole(String Role){
		this.role=Role;
	}
	public void setLoggedin(boolean log){
		this.loggedin=log;
		
	}
	public int getId(){
		return userid;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getRole(){
		return role;
	}
	public boolean getLoggedin(){
		return loggedin;
	}

}
