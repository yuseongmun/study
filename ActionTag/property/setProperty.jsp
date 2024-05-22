<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id:명명 / class : 객체 경로 / name : / property : 필드 / value : 필드값 -->
	<jsp:useBean id="person" class="webtest1.Person" scope="request"/>
	<jsp:setProperty name="person" property="id" value="20230824"/>
	<jsp:setProperty name="person" property="name" value="홍길동"/>	
	<p>아이디 : <% out.println(person.getId()); %></p>
	<p>이름 : <% out.println(person.getName()); %></p>
</body>
</html>