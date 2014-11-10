<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- 2014. 11. 3. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"  href="css/style.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	
		<header class="hd">
			<h1> Include 연습 </h1>
			<h2> include 지시자의 top.jsp영역
			<% if(session.getAttribute("MEMBERID")!=null) {
				String uname =(String) session.getAttribute("USERNAME");
			 %>
			 &nbsp;&nbsp;&nbsp;<%=uname %>님 반갑습니다. ^^
			<% } %>
			 </h2>
		</header>
		<nav>
			   <ul>
					<li><a href="ex1_body.jsp">홈</a>&nbsp; |</li>
					<%
					if(session.getAttribute("MEMBERID")==null){
					%>
					<li><a href="join.jsp">회원가입</a>&nbsp; |</li>
					<li><a href="loginForm.jsp">로그인</a>&nbsp; |</li>
					<%
					}else{
					%>
					<li><a href="mypage.jsp">마이페이지</a>&nbsp; |</li>
					<li><a href="loginOut.jsp">로그아웃</a>&nbsp; |</li>
					<% } %>
					<li><a href="bbslist.jsp">게시판</a>&nbsp; |</li>
					<li><a href="board.kosta?query=boardList&page=1">Model2게시판</a>&nbsp; |</li>
					<li><a href="">메뉴1</a>&nbsp; |</li>
					<li><a href="">메뉴1</a></li>
				</ul>
			</nav>
			
			
			
			
			
			
			