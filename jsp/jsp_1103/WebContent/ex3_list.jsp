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
			//Dao로부터 데이터를 받아오기 위한 메서드를 호출
			ArrayList<ImgDirVO> list = ImgDirDao.getDao().getList();
			for (ImgDirVO e : list) {
		%>
		<img
			src="<%=application.getContextPath()%>/upload/<%=e.getImgpath()%>">
		<%
			}
		%>
		<a href="ex3_uploadForm.jsp">업로드폼</a>
	</p>
</body>
</html>