<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="bvo" class="vo.BbsVO"></jsp:useBean>
<jsp:setProperty property="*" name="bvo"/>
<%
	BbsDao.getDao().setBbs(bvo);
	response.sendRedirect("bbsForm.jsp");
%>