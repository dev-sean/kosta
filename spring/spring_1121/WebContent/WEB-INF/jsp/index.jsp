<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	Status : ${msg }<br/>
	Session Id : ${sessionScope.uid }
	<!-- 세션의 값이 없으면 로그인 폼을, 세션값이 있으면 로그아웃을 링크한다. -->
	<c:choose>
	
		<c:when test="${sessionScope['uid'] == null }">
			<a href="mlogin.kosta">로그인폼</a>
		</c:when>
		<c:otherwise>
			<a href="logout.kosta">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<a href="mlogin.kosta">뒤로가기</a>
</body>
</html>