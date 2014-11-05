<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	session.removeAttribute("MEMBERID");
	session.removeAttribute("USERNAME");
	//session.invalidate(); 葛电 技记阑 昏力
	response.sendRedirect("ex1_body.jsp");
%>