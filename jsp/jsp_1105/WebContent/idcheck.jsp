
<%@page import="dao.JoinDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String userId = request.getParameter("id");
//cnt가 1이면 success가 날아옴
	String result = JoinDao.getDao().idCheck(userId);
	
	if(result.equals("success")){
		out.println("fail");
	}else{
		out.println("success");
	}

%>