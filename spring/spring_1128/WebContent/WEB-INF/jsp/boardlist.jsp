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
	<div id="wrap">
		<table>
			<tr>
				<td>번호</td>
				<td>타이틀</td>
				<td>작성자</td>
				<td>그룹</td>
				<td>날짜</td>
			</tr>
			<c:forEach var="e" items="${list }">
				<tr>
					<td>${e.no }</td>
					<td>${e.title }</td>
					<td>${e.writer }</td>
					<td>${e.groupno }</td>
					<td>${e.regdate }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
				<form method="post" action="search.kosta">
					<select name="sel" id="sel">
						<option>title</option>
						<option>writer</option>
					</select>
					<input type="text" name="title">
					<input type="text" name="writer">
					<input type="number" name="groupno">
					<input type="submit" value="send">
				</form>
			</tr>
		</table>
	</div>
</body>
</html>