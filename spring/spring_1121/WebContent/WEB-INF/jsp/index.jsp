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
	<!-- ������ ���� ������ �α��� ����, ���ǰ��� ������ �α׾ƿ��� ��ũ�Ѵ�. -->
	<c:choose>
	
		<c:when test="${sessionScope['uid'] == null }">
			<a href="mlogin.kosta">�α�����</a>
		</c:when>
		<c:otherwise>
			<a href="logout.kosta">�α׾ƿ�</a>
		</c:otherwise>
	</c:choose>
	<a href="mlogin.kosta">�ڷΰ���</a>
</body>
</html>