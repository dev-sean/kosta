<%@page import="dao.ImgDirDao"%>
<%@page import="vo.ImgDirVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>
</style>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<p>
		<%
			//Dao�κ��� �����͸� �޾ƿ��� ���� �޼��带 ȣ��
			ArrayList<ImgDirVO> list = ImgDirDao.getDao().getList();
			for (ImgDirVO e : list) {
		%>
		<img
			src="<%=application.getContextPath()%>/upload/<%=e.getImgpath()%>">
		<%
			}
		%>
		<a href="ex3_uploadForm.jsp">���ε���</a>
	</p>
</body>
</html>