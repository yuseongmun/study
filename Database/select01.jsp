<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
	<table width="300" border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
		</tr>
		<%
		ResultSet rs = null;
		Statement stmt = null;
		
		try{
			String sql="SELECT * FROM member";
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String id = rs.getString("id");
				String pw = rs.getString("passwd");
				String name = rs.getString("name");
			
		
			%>
			<tr>
				<td><%=id %></td>
				<td><%=pw %></td>
				<td><%=name %></td>
			</tr>
			<%
				}
		}catch(SQLException ex){
			out.println("member 테이블 호출이 실패했습니다.<br>");
			out.println("SQLException: "+ex.getMessage());
		}finally{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}
			%>
	</table>
</body>
</html>