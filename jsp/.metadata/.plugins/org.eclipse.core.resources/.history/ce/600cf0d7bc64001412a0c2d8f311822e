<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="vo" class="vo.BbsVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo" />
<%-- Sub : <%=vo.getSub()%><br/> --%>
<%-- Pwd : <%=vo.getPwd()%><br/> --%>
<%-- Reip : <%=vo.getReip()%><br/> --%>
<%-- Writer : <%=vo.getWriter()%><br/> --%>
<%-- Cont : <%=vo.getCont()%><br/> --%>
<%
	BbsDao.getDao().bbsAdd(vo);
	response.sendRedirect("bbslist.jsp");
%>

