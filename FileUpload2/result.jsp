<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%> <!--표현언어 사용, 기본값은 true -->
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 라이브러리 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 라이브러리 사용 -->
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1}"/> <!-- param1의 value="cat.JPG", file1로 명명 -->
<c:set var="file2" value="${param.param2}"/> <!-- param2의 value="cat1.PNG" file2로 명명 -->
<title>이미지 파일 출력하기</title>
</head>
<body>
<table align="center" border="1">
<tr>
	<td>파라미터 1 :<c:out value="${file1}"/><br></td> <!-- file1의 value="cat.JPG" -->
	<td>파라미터 2 :<c:out value="${file2}"/><br></td> <!-- file2의 value="cat1.PNG" -->
</tr>
<tr>
	<td><c:if test="${not empty file1}"> <!-- file1은 empty가 아니므로 이미지 파일 표시 -->
		<img src="${contextPath}/download.do?fileName=${file1}" width=300 height=300/><br>
		</c:if>
		파일 내려받기 :
		<a href="${contextPath}/download.do?fileName=${file1}"> 파일 내려받기</a><br> <!-- 하이퍼링크로 download.do 서블릿 실행 -->		
		<br>
	</td>
	<td>
		<c:if test="${not empty file2 }">
		<img src="${contextPath}/download.do?fileName=${file2}" width=300 height=300/><br> <!-- file2은 empty가 아니므로 이미지 파일 표시 -->
		</c:if>
		파일 내려받기 :
		<a href="${contextPath}/download.do?fileName=${file2}"> 파일 내려받기</a><br> <!-- 하이퍼링크로 download.do 서블릿 실행 -->	
	</td>
</tr>
</table>
</body>
</html>