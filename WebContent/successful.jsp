<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type ="text/css" href="css/style.css">
<title>Welcome to the CASTLA</title>
</head>
<body>



<%
out.println(session.getAttribute("username")+" Successfully sign up as "+session.getAttribute("role"));
%>
<%
out.println("<h4>The date is "+new java.util.Date()+"</h4>");
%>
<br/>

<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
</body>
</html>