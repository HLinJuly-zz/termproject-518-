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
<h3>Welcome instructor</h3>
<h4>Please add a Multiple choice question</h4>
<div>

<%
if(session.getAttribute("info_addq")==null||session.getAttribute("info_addq")==""){
	
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+"Enter list"+"</font>"+"</h4>");
}
else{
	out.println("<h4 align=\"center\">"+"<font color=\"red\">"+session.getAttribute("info_addq")+"</font>"+"</h4>");
	
}
session.removeAttribute("info_addq");
%>

<form action = "/termproject/AddQuestionServlet" method ="post" >

<ul>
			<li><h3>
				question<br><input type="text" name="question" />
			</h3></li>
			<li><h3>
				Right Answer<br><input type="text" name="rightA" />
			</h3></li>
			<li><h3>
				Wrong Answer 1<br><input type="text" name="wrongA1" />
			</h3></li>
			<li><h3>
			    Wrong Answer 2<br><input type="text" name="wrongA2" />
			</h3></li>
						<li><h3>
			    Wrong Answer 3<br><input type="text" name="wrongA3" />
			</h3></li>
						<li><h3>
			    Hint 1<br><input type="text" name="hint1" />
			</h3></li>
						<li><h3>
			    Hint 2<br><input type="text" name="hint2" />
			</h3></li>
						<li><h3>
			    Hint 3<br><input type="text" name="hint3" />
			</h3></li>
</ul>

<input type="radio" name="role" value="multiple" checked />Multiple choice question</li>
<br>


<input type = "submit" value = "submit">
<br>

</form>
<jsp:include page="/logout.jsp"></jsp:include>
<jsp:include page="/nav.jsp"></jsp:include>
</div>

</body>
</html>