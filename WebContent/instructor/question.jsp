<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please choose the type of question</title>
<link rel="stylesheet" type ="text/css" href="/termproject/css/style.css">
</head>
<body>
	<div class="s1">
	<h1>Please choose the type of question</h1>
<ul>
<li><a href ="/termproject/instructor/addMQ.jsp" >Multiple choice question</a></li>
<li><a href ="/termproject/instructor/addNQ.jsp" >Numerical value question</a></li>
</ul>

<jsp:include page="/logout.jsp"></jsp:include>
<jsp:include page="/nav.jsp"></jsp:include>
</div>
</body>
</html>