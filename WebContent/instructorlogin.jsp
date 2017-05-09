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
<img src = 'css/image/welcome.jpg' ><br>
<br>
<%
out.println(session.getAttribute("username")+" has logged in Successfully as "+session.getAttribute("role"));
%>
<%
out.println("<h4>The date is "+new java.util.Date()+"</h4>");
%>
<h4>user info:</h4>
<h4>UserName:<%=session.getAttribute("username") %></h4>
<h4>Role:<%=session.getAttribute("role") %></h4>
<h4>FirstName:<%=session.getAttribute("firstname") %></h4>
<h4>LastName: <%=session.getAttribute("lastname") %></h4>

<h3>functions</h3>
<a href = '/termproject/instructor/question.jsp'>add a question</a><br>
<a href = '/termproject/instructor/viewquestion.jsp'>view all questions</a><br>
<a href ='/termproject/instructor/addexam.jsp' >add an exam</a><br>
<a href = '/termproject/instructor/viewexam.jsp' >view all exams</a><br>
<a href = '??/termproject/instructor/grade.jsp'> ??view and edit the grade</a><br>
<a href = '/termproject/chooseanexam.jsp'>take an exam</a><br>


<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

</body>
</html>