<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The exam is over</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
</head>
<body>
<div>
<img src = 'css/image/welcome.jpg' ><br>
<br>
<h3>Congratulation</h3>
<%
if(session.getAttribute("username")==null||session.getAttribute("info_addexam")==""){
	
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+"human"+"</font>"+"</h4>");
}
else{
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+session.getAttribute("username")+"</font>"+"</h4>");
	
}
%>

<h3>You have finished the exam.</h3>

</div>

<jsp:include page="/logout.jsp"></jsp:include>
<jsp:include page="/nav.jsp"></jsp:include>	
</body>
</html>