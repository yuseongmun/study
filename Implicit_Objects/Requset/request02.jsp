<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects</title>
</head>
<body>
	<%
		Enumeration en=request.getHeaderNames();
	while(en.hasMoreElements()){
		String headerName=(String)en.nextElement();
		String headerValue=request.getHeader(headerName);
	
	%>
	
	<%=headerName%> : <%=headerValue %><br>
	<%
	}
	%> 
</body>
</html>