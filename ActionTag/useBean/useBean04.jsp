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
	<p>아이디 : <%=person.getId() %></p>
	<p>이름 : <%=person.getName() %></p>
	
	<%
		person.setId(19980412);
		person.setName("유성문");
	%>
	<jsp:include page="useBean03.jsp"/>
</body>
</html>