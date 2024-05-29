<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<script type="text/javascript">
	function checkForm(){
		if(document.frm.name.value.length<6||document.frm.name.vale.length>12){
			alert("이름을 6~12자 이내로 입력해주세요.");
			documnet.frm.name.select();
		}
	}
</script>
<body>
	<form name="frm">
		<p>이름 : <input type="text" name="name"></p>
		<input type="submit" vlaue="전송" onclick="checkForm()">
	</form>
</body>
</html>