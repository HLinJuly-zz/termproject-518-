<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>
	<div class="s1">
	<h1>Signup</h1>
<br/>
<%
if(session.getAttribute("info_signup")==null||session.getAttribute("info_signup")==""){
	
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+"Enter list"+"</font>"+"</h4>");
}
else{
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+session.getAttribute("info_signup")+"</font>"+"</h4>");
	
}
%>
<form action="/termproject/SignupServlet" method="get">
			<ul>
			<li><h3>
				username:<input type="text" name="username" />
			</h3></li>
			<li><h3>
				password:<input type="password" name="password" />
			</h3></li>
			<li><h3>
				FirstName:<input type="text" name="firstname" />
			</h3></li>
			<li><h3>
				LastName:<input type="text" name="lastname" />
			</h3></li>
			</ul>
			<h4>
			
Choose the role: 

<li>
<input type="radio" name="role" value="student" />student</li>
<li>
<input type="radio" name="role" value="instructor" />instructor</li>
<li>
<input type="radio" name="role" value="TA" />TA</li>
</h4>



<h3>
			<input type="submit" value="submit" />
			<input type="reset" value="reset" />
			</h3>

</form>
</div>

<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

</body>
</html> 