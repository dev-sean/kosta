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
			<h1> Include ���� </h1>
			<h2> include �������� top.jsp����
			<% if(session.getAttribute("MEMBERID")!=null) {
				String uname =(String) session.getAttribute("USERNAME");
			 %>
			 &nbsp;&nbsp;&nbsp;<%=uname %>�� �ݰ����ϴ�. ^^
			<% } %>
			 </h2>
		</header>
		<nav>
			   <ul>
					<li><a href="ex1_body.jsp">Ȩ</a>&nbsp; |</li>
					<%
					if(session.getAttribute("MEMBERID")==null){
					%>
					<li><a href="join.jsp">ȸ������</a>&nbsp; |</li>
					<li><a href="loginForm.jsp">�α���</a>&nbsp; |</li>
					<%
					}else{
					%>
					<li><a href="mypage.jsp">����������</a>&nbsp; |</li>
					<li><a href="loginOut.jsp">�α׾ƿ�</a>&nbsp; |</li>
					<% } %>
					<li><a href="bbslist.jsp">�Խ���</a>&nbsp; |</li>
					<li><a href="board.kosta?query=boardList&page=1">Model2�Խ���</a>&nbsp; |</li>
					<li><a href="">�޴�1</a>&nbsp; |</li>
					<li><a href="">�޴�1</a></li>
				</ul>
			</nav>
			
			
			
			
			
			
			