<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String passwd=request.getParameter("passwd");
	%>
	<p>입력된 id값 : <%=id %>
	<p>입력된 pw값 : <%=passwd %>
</body>
</html>