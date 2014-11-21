<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#wrap {
	width: 500px;
	margin: auto
}

#wrap table {
	width: 100%;
	border: 1px dotted #9900ff
}

#wrap table thead {
	background-color: #b9b9ff;
}
</style>
</head>
<body>
	<div id="wrap">
		<table>
			<thead>
				<tr>
					<th colspan="5">Bbs1 List</th>
				</tr>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성날짜</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listv" items="${list}">
					<tr>
						<td><a href="bbs1detail.kosta?num=${listv.num }">${listv.num }</a></td>
						<td>${listv.sub }</td>
						<td>${listv.writer }</td>
						<td>${listv.hit }</td>
						<td>${listv.regdate }</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><input type="button" value="write"
						onclick="location='bbs1Form.kosta'"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>