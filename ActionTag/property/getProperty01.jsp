<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<jsp:useBean id="person" class="webtest1.Person" scope="request"/>
	<p>아이디 : <jsp:getProperty name="person" property="id"/></p>
	<p>이름 : <jsp:getProperty name="person" property="name"/></p>	
</body>
</html>