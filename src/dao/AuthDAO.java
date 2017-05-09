package dao;
import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class AuthDAO {
	

	public static int checkUserPass(String userName, String password, String role){
		//if match return userId else return -1
		
		//System.out.println("dao");
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
			ResultSet rs = smt.executeQuery("select * from user");
			while(rs.next()){
				String d_name = rs.getString("username");
				String d_password = rs.getString("password");
				String d_role = rs.getString("role");
				int d_id = rs.getInt("userId");
				if(userName.equals(d_name)&&password.equals(d_password)&&role.equals(d_role)){
					return d_id;
				}
				//system.out.println(d_name + " " + d_password + " " +d_role);
				//system.out.println("test");
			}
			
		}catch (SQLException e){
			System.out.println("cannot find in the database");
		}
		return -1;
	}
public static User getUserById(int userId){
	//return a user object(with all attributes set) of user with Id==userId
	String d_name=null;
	String d_password=null;
	String d_role=null;
	int d_id=0;
	String d_firstName=null;
	String d_lastName=null;
	int d_id2=0;
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
		ResultSet rs= smt.executeQuery("select * from user");
		//test
		//System.out.println(rs.next());
		while(rs.next()){
			d_name=rs.getString("username");
			d_password=rs.getString("password");
			d_role=rs.getString("role");
			d_id=rs.getInt("userId");
			if(d_id==userId){
				try{
					Statement smt2=connect.createStatement();
					ResultSet rs2=smt2.executeQuery("select * from user_profile");
					while (rs2.next()){
						d_firstName = rs2.getString("firstName");
						d_lastName = rs2.getString("lastName");
						d_id2=rs2.getInt("userId");
						if(d_id2==userId){
							break;
					}
				}
			}catch(SQLException e){
				System.out.println("cannot search");
			}
			break;
		}
		
	}
} catch (SQLException e) {
	System.out.println("cannot search");
}



User user=new User(d_id,d_name,d_password ,d_role, d_firstName,d_lastName);
return user;
}

public static boolean enterNewUser(String userName, String password ,String role, String firstName, String lastName){
//Enters new user in DB. This includes entries in both User and UserProfile table of Database
//if entry successful return true else return false
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
try {

	int id=1;
	Statement smt = connect.createStatement();
	ResultSet rs = smt.executeQuery("select * from user");
	while (rs.next()){
		id++;
	}
	//System.out.println("this is test 1");
	sql="insert into user(username,password,role,userId) values('"+userName+"','"+password+"','"+role+"','"+id+"')";
	
	result = smt.executeUpdate(sql);
	//System.out.println("this is test 2");
	sql="insert into user_profile (userId,firstName,lastName) values('"+id+"','"+firstName+"','"+lastName+"')";
	result = smt.executeUpdate(sql);
	//System.out.println("this is test 3");
	if(result!=1){
    	return false;
    }
	
} catch (SQLException e) {
	System.out.println("failed to insert");
}

return true;
}

public static boolean checkUserNameAvailable(String userName){
//if available return true else return false
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
	ResultSet rs = smt.executeQuery("select * from user");
	while (rs.next()) {
		String d_name = rs.getString("name");
		if(userName.equals(d_name)) return false;
	}
} catch (SQLException e) {
	System.out.println("can not search");
}

return true;
}	
	
}
