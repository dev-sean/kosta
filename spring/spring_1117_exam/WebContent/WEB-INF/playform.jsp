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
		<form method="post" action="add.kosta">
		<input type="hidden" name="query" value="palyadd">
			PName : <input type="text" name="pname"><br /> Price : <input
				type="number" name="price" min="1000" step="1000"><br />
			Users : <input type="text" name="users"> <br /> <input
				type="submit" value="send">

		</form>
	</div>
</body>
</html>