<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the CASTLA</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>
<h1>Welcome to the CASTLA</h1>


		<%
		    //String info="";	
			if (session.getAttribute("info") == null || session.getAttribute("info") == "") {
				out.println("Welcome");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + session.getAttribute("info") + "</font>"
						+ "</h4>");
			}
			session.removeAttribute("info");
		%>

<ul>
<li><a href="login.jsp">Login</a></li>
<li><a href="signup.jsp">Sign up</a></li>
</ul>
</body>
</html>