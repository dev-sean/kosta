<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div style="width:500px; margin:auto"></div>
	<table>
		<tr>
			<td colspan="5" class="cls">리스트</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>설문갯수</td>
			<td>작성일</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.num }</td>
				<td><a href="voteDetail.kosta?num=${list.num}">${list.sub }</a></td>
				<td>${list.code }</td>
				<td>${list.vdate }</td>
				<td><a href="javascript:del(${list.num })">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>