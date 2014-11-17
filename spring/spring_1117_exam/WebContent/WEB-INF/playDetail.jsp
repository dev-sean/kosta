<%@page
	import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
		<table>
			<tr>
				<c:forEach var="listv" items="${list}">
					<td>${listv.pname }</td>
					<td>${listv.price }</td>
					<td>${listv.users }</td>
					<td>${listv.rdate }</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>