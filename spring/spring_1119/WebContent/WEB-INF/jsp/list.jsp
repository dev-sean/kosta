<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<table>
			<c:forEach var="listv" items="${list}">
				<tr>
					<td>${listv.sub }</td>
					<td>${listv.writer }</td>
					<td>${listv.content }</td>
					<td>${listv.pwd }</td>
					<td><img src="${pageContext.request.contextPath}/img/${listv.mfile }"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>