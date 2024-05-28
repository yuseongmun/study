<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%> <!--표현언어 사용, 기본값은 true -->
    
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 라이브러리 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 라이브러리 사용 -->

<!--한글 사용 : UTF-8 -->
<%
	request.setCharacterEncoding("UTF-8"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드 요청하기</title>
</head>
<body>
<form method="post" action="result.jsp"> <!-- result.jsp 실행할 때 post 방식으로 전달 -->
<input type=hidden name="param1" value="cat.JPG"/><br> <!--필드명 : param1, 필드값 cat.JPG-->
<input type=hidden name="param2" value="cat1.PNG"/><br> <!--필드명 : param2, 필드값 cat1.PNG-->
<input type="submit" value="이미지 다운로드">	<!-- "submit" : request로 전달할 수 있게됨 -->
</form>
</body>
</html>