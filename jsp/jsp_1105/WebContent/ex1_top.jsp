<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="style/style.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>

	<header class="hd">
		<h1>Include ����</h1>
		<h2>include �������� top.jsp����</h2>
		<%
			if(session.getAttribute("MEMBERID")!=null){
				String username = (String) session.getAttribute("USERNAME");
		%>
			<h2 style="color:yellow; font-size:13pt"><%=username %>�� �ݰ����ϴ�. ^^</h2>
		<%		
			}
		%>
	</header>
	<nav>
		<ul>
			<li><a href="ex1_body.jsp">Ȩ</a>&nbsp; |</li>
			<%
				String menu1= "";
				String menu2 = "";
				//������ ���� �Ǵ�
				if(session.getAttribute("MEMBERID")==null){
			%>
					<li><a href="join.jsp">ȸ������</a>&nbsp; |</li>
					<li><a href="loginForm.jsp">�α���</a>&nbsp; |</li>
			<%
				}else{
			%>
					<li><a href="mypage.jsp">����������</a>&nbsp; |</li>
					<li><a href="LogOut.jsp">�α׾ƿ�</a>&nbsp; |</li>
			<%
				}
			%>
			
			<li><a href="">�Խ���</a>&nbsp; |</li>
			<li><a href="">�޴�1</a>&nbsp; |</li>
			<li><a href="">�޴�2</a>&nbsp; |</li>
			<li><a href="">�޴�3</a></li>
		</ul>
	</nav>