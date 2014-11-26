<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login.jsp</title>
</head>
<body>
	<form method="post" action="j_spring_security_check">
		아이디 : <input type="text" name="j_username"><br /> 비밀번호 : <input
			type="password" name="j_password" /> <br /> <input type="submit"
			value="Login">
	</form>
</body>
</html>