<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Begin the exam</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>
<div class = "s1">

<form action="/termproject/TakeExamServlet" method = "get">


<h1>Begin the exam</h1><br>
<h3>Welcome to the exam</h3>
		<%
		//if the exam is not exist
			if (session.getAttribute("username") == null || session.getAttribute("username") == "") {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "please log in first" + "</font>"
						+ "</h4>");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + session.getAttribute("username") + "</font>"
						+ "</h4>");
			}
			//System.out.println(user.getRole());
		//session.removeAttribute("info_chooseexam");
		%>
<h3>The exam is</h3>
<% 
out.println(session.getAttribute("eId"));

//out.println(session.getAttribute("eName"));
%>


<input type = "submit"  value = "OK" />

</form>

<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

</div>

</body>
</html>