<%@ page language="java" contentType="text/html; charset=UTF-8" import = "model.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answer the question</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>

	<dic class = "s1">
	
	<h3>This is the </h3><br>
	
	<%
	//show the nomber of the question
	out.println(session.getAttribute("qNO")+" question.");
			
	%>

<h4>The question is </h4>


<%//show the question
out.println(session.getAttribute("question")) ;
%>
	<form action = "/termproject/TakeExamServlet" method = "get">
	
	
	
	
		<h3>
		<input type="submit" value="login" />
				
				
		</h3>
		<jsp:include page="nav.jsp"></jsp:include>
	</form>
	
	</dic>


</body>
</html>