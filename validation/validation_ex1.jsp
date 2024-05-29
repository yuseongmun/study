<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function checkForm(){
		alert("이름은"+document.frm.name.value+"입니다.")
	}
</script>
<body>
	<form name = "frm">
		<p>이름 : <input type="text" name="name"></p>
			<input type="submit" value="전송" onclick="checkForm()">
	</form>
</body>
</html>