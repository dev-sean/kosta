<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BbsDao.getDao().deleteTable(num);
	response.sendRedirect("bbslist.jsp");
%>