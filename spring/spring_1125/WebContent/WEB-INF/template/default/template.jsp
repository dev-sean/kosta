<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	overflow: hidden;
}

.page {
	min-height: 100%;
	position: relative;
}

.header {
	padding: 10px;
	width: 100%;
	text-align: center;
	background-color: orange;
}

.content {
	padding: 10px;
	padding-bottom: 20px;
	overflow: hidden;
}

.menu {
	padding: 50px 10px 0px 10px;
	width: 200px;
	float: left;
}

.menu ul li {
	background-color: green;
	color: white;
	margin-top: 5px;
}

.menu ul li a:VISITED {
	text-decoration: none;
	color: #FFF;
	font-weight: bold;
}

.menu ul li a:LINK {
	text-decoration: none;
	color: #FFF;
	font-weight: bold;
}

.body {
	margin: 50px 10px 0px 250px
}

.footer {
	clear: both;
	position: absolute;
	bottom: 0;
	left: 0;
	text-align: center;
	width: 100%;
	height: 20px
}
</style>
</head>
<body>
	<div id="page">
		<tiles:insertAttribute name="header" />
		<div id="content">
			<tiles:insertAttribute name="menu" />
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>