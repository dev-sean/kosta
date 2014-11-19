<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#wrap {
	width: 300px;
	margin: auto;
}
</style>
</head>
<body>
	<div id="wrap">
		<form method="post" action="save.kosta">
			sub : <input type="text" id="sub" name="sub"><br /> 
			Writer :<input type="text" name="writer" id="writer"><br /> 
			Content :<textarea rows="10" cols="15" name="content" id="content"></textarea>
			<br /> 
			Password : <input type="password" name="pwd" maxlength="10"><br />
			<input type="submit" value="send">
		</form>
	</div>
</body>
</html>