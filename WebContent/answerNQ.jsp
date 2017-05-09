<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answer the question</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>

	<div class = "s1">
	
	<h3>This is the </h3><br>
	
	<%
	//show the nomber of the question
	out.println(session.getAttribute("i")+" question.");
			
	%>

<h4>The question is </h4>


<%//show the question
out.println(session.getAttribute("question")) ;
%>
	<form action = "/termproject/GetAnswerServlet" method = "get">
	
	<h3>Answer:
	<input type = "text" name = "answerQ" />
	
	</h3>
	
	
		<h3>
		<input type="submit" value="submit" />
				
				
		</h3>
		<jsp:include page="nav.jsp"></jsp:include>
	</form>
	
	</div>


</body>
</html>