
<%@page import="dao.JoinDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//mJoin테이블을 조회해서 데이터를 비교 검색 구현
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("ID", id);
	map.put("PWD", pwd);
	String flag = JoinDao.getDao().login(map);
	String userName = JoinDao.getDao().getUserName(id);
	if(flag.equals("success")){
		//데이터베이스의 회원테이블에서 조회가 성공!
		//세션에게 사용자의 정보를 심는다.
		session.setAttribute("MEMBERID", id);
		session.setAttribute("USERNAME", userName);
	}else{
		response.sendRedirect("error.jsp");
	}
	response.sendRedirect("ex1_body.jsp");
%>