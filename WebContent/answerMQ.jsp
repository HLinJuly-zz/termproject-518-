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


<%
		//User user = new User();
			if (session.getAttribute("feedback") == null || session.getAttribute("feedback") == "") {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "go to the next question" + "</font>"
						+ "</h4>");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + session.getAttribute("feedback") + "</font>"
						+ "</h4>");
			}
			
			if (session.getAttribute("hint") == null || session.getAttribute("hint") == "") {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "answer the question" + "</font>"
						+ "</h4>");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "the hint" +session.getAttribute("hint") + "</font>"
						+ "</h4>");
			}
			
			
			
			//System.out.println(user.getRole());
		session.removeAttribute("feedback");
		session.removeAttribute("hint");
		%>

<h4>The question is </h4>


<%
//show the question
out.println(session.getAttribute("question")) ;
%>
	<form action = "/termproject/GetAnswerServlet" method = "get">
	
	<h4>Choose an option</h4>
	<h3>A:<input type = "radio" name = "answerMQ"  value = "a"/></h3>
	<%
//show the option1
out.println(session.getAttribute("option1")) ;
%>
		
		<h3>B:<input type = "radio" name = "answerMQ"  value = "b"/></h3>
	<%
//show the option2
out.println(session.getAttribute("option2")) ;
%>	<h3>C:<input type = "radio" name = "answerMQ"  value = "c"/></h3>
	<%
//show the option3
out.println(session.getAttribute("option3")) ;
%>	<h3>D:<input type = "radio" name = "answerMQ"  value = "d"/></h3>
	<%
//show the option4
out.println(session.getAttribute("option4")) ;
%>
	
	<input type = "submit"  value = "OK" />

	</form>
	
	</div>

</body>
</html>