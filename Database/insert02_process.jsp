<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "dbconn.jsp" %>
	<% 
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	PreparedStatement pstmt = null;
	
	try{
		String sql="INSERT INTO member(id,passwd,name) VALUES(?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,passwd);
		pstmt.setString(3,name);
		pstmt.executeUpdate();
		out.println("member 테이블 삽입이 성공했습니다.");		
	}catch(SQLException ex){
		out.println("member 테이블 삽입이 실패했습니다.");
		out.println("SQLException: "+ex.getMessage());		
	}finally{
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			conn.close();
	}
	%>	
</body>
</html>