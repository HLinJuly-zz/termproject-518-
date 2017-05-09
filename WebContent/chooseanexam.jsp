<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose an exam</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>

<div class = "s1">
<h1>Please choose the exam</h1><br>
		<%
		//if the exam is not exist
			if (session.getAttribute("info_chooseexam") == null || session.getAttribute("info_chooseexam") == "") {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + "the number of exam" + "</font>"
						+ "</h4>");
			} else {
				out.println("<h4 align=\"center\">" + "<font color=\"red\">" + session.getAttribute("info_chooseexam") + "</font>"
						+ "</h4>");
			}
			//System.out.println(user.getRole());
		session.removeAttribute("info_chooseexam");
		%>
		
		<form action="/termproject/ChooseExamServlet" method = "get">
<h3>please input the id of the exam</h3><br>
<input type = "number" name ="cEId" min = "1"><br>


			<h3>
				<input type="submit" value="submit" />
				
				
			</h3>
			<jsp:include page="nav.jsp"></jsp:include>
		</form>
	</div>


</body>
</html>