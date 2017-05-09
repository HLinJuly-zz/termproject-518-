<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type ="text/css" href="/termproject/css/style.css">
<title>Next Question</title>
</head>
<body>
	<div class="s1">

<%
		//User user = new User();
			if (session.getAttribute("feedback") == null || session.getAttribute("feedback") == "") {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "go to the next question" + "</font>"
						+ "</h4>");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + session.getAttribute("feedback") + "</font>"
						+ "</h4>");
			}
			//System.out.println(user.getRole());
						if (session.getAttribute("hint") == null || session.getAttribute("hint") == "") {
				out.println("next question");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "the hint" +session.getAttribute("hint") + "</font>"
						+ "</h4>");
			}
						
		session.removeAttribute("hint");	
		session.removeAttribute("feedback");
		%>


<form action="/termproject/TakeExamServlet" method = "post">




<input type="submit" value="next" />

</form>



</div>

</body>
</html>