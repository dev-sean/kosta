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
	<div>
		<form method="post" action="voteUp.kosta">
			<input type="hidden" name="num" value="${v.num }"> 제목 : <input
				type="text" name="sub" value="${v.sub }"><br />
			<ul>
				<c:forEach begin="1" end="${v.code }" step="1" varStatus="e">
					<li><input type="radio" name="votechk" value="${e.count }">
						<c:choose>
							<c:when test="${e.count==1 }">${v.vsub1 }</c:when>
							<c:when test="${e.count==2 }">${v.vsub2 }</c:when>
							<c:when test="${e.count==3 }">${v.vsub3 }</c:when>
							<c:when test="${e.count==4 }">${v.vsub4 }</c:when>
							<c:when test="${e.count==5 }">${v.vsub5 }</c:when>
						</c:choose></li>
				</c:forEach>
			</ul>
			<input type="submit" value="등록">
		</form>
	</div>
</body>
</html>