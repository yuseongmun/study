<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<h3>이 파일은 include_first.jsp입니다.</h3>
	<jsp:include page = "include_second.jsp" flush="false"/>
	<p>Java Server Page</p>
</body>
</html>