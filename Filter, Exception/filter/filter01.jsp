<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
%>
<body>
	<form method="post" action="filter01_process.jsp">
		<p>이름 : <input type="text" name="name"></p>
		<input type="submit" value="전송">
	</form>
</body>
</html>