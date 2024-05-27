<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 

<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<form action="${contextPath}/test.do" method="post" enctype="multipart/form-data">
		<p>이 름  : <input type="text" name="name">
		<p>제 목 : <input type="text" name="subject">
		<p>파 일 : <input type="file" name="filename">
		<p><input type="submit" value="파일 올리기">		
	</form>
</body>
</html>