<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*, model.*"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the CASTLA</title>

    <base href="<%=basePath%>">
<link rel="stylesheet" type ="text/css" href="css/style.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<body>
<img src = 'css/image/welcome.jpg' ><br>
<br>



<h3>Welcome instructor now you can view all questions</h3>
<tr><th>id</th><th>question</th><th>type</th></tr>

<!-- show all questions -->
<%
ArrayList<Question> al = (ArrayList<Question>)request.getAttribute("al");
for(Question q:al){
%>	

<tr><td><%=q.getQId() %></td><td><%=q.getRole() %></td><td><%=q.getQuestion() %></td></tr>
<%
}
%>
<% 
//get the page count
   int pageCount=(Integer)request.getAttribute("pageConunt");
   for(int i=1;i<=pageCount;i++){
   %>
   <a href="/instrustor/ViewQServlet?pageNow=<%=i%>"><<%=i%>></a>
   <%
   }
    %>

</body>
</html>