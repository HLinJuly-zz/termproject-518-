<%@ page language="java" contentType="text/html; charset=UTF-8"  import="model.User"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>
	<div class="s1">
		<h1>Login</h1>
		<br />
		<%
		//User user = new User();
			if (session.getAttribute("info") == null || session.getAttribute("info") == "") {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "Enter username and password" + "</font>"
						+ "</h4>");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + session.getAttribute("info") + "</font>"
						+ "</h4>");
			}
			//System.out.println(user.getRole());
		session.removeAttribute("info");
		%>
		<form action="/termproject/LoginServlet" method="get">
			<h3>
			<ul></ul>
				<li>username:<input type="text" name="username" /></li>
				<li>password:<input type="password" name="password" /></li>
			</h3></ul>
		

			<h4>
				Choose your role: 
				<ul>
				
				<li><input type="radio" name="role" value="student" />student</li>
				<li><input type="radio" name="role" value="instructor" />instructor</li>
				<li><input type="radio" name="role" value="ta" checked />TA</li>
			</h4></ul>

			<h3>
				<input type="submit" value="login" />
				
				
			</h3>
			<jsp:include page="nav.jsp"></jsp:include>
		</form>
	</div>
</body>
</html>
