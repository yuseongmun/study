<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form action ="${contextPath}/fileupload03_process.do" method = "post" enctype="multipart/form-data">
	<p>파일 : <input type ="file" name="filename"></p>
	<p><input type ="submit" name="파일올리기"></p>	
	</form>
</body>
</html>