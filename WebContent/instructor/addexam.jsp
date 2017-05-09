<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type ="text/css" href="/termproject/css/style.css">
<title>Welcome to the CASTLA</title>
</head>
<body>
	<div class="s1">
<h3>Welcome instructor</h3>

<h4>Please add an exam</h4>
<div>
<%
if(session.getAttribute("info_addexam")==null||session.getAttribute("info_addexam")==""){
	
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+"Enter list"+"</font>"+"</h4>");
}
else{
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+session.getAttribute("info_addexam")+"</font>"+"</h4>");
	
}
%>

<form action = "/termproject/AddExam" method ="post" >

<ul>
			<li><h3>
				The name of the exam<br><input type="text" name="eName" />
			</h3></li>
			
			</ul>
			<h4>Please input the No. of the question</h4>
			<ul>
			<li><h3>
				Question 1<br><input type="number" name="q1" min = "1"/>
			</h3></li>
					<li><h3>
				Question 2<br><input type="number" name="q2" min = "1" />
			</h3></li>		
			<li><h3>
				Question 3<br><input type="number" name="q3" min = "1"/>
			</h3></li>		
			<li><h3>
				Question 4<br><input type="number" name="q4" min = "1"/>
			</h3></li>		
			<li><h3>
				Question 5<br><input type="number" name="q5" min = "1"/>
			</h3></li>		
			<li><h3>
				Question 6<br><input type="number" name="q6" min = "1"/>
			</h3></li>

</ul>
			<input type="submit" value="submit" />
	</form>
	</div>
<jsp:include page="/logout.jsp"></jsp:include>
<jsp:include page="/nav.jsp"></jsp:include>	

</body>
</html>