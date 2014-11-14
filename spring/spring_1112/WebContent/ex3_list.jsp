<%@page import="ex3.MemberVO"%>
<%@page import="ex3.ListString"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ApplicationContext ctx = new GenericXmlApplicationContext("ex3/list.xml");
	ListString ls = ctx.getBean("list_v", ListString.class);
	List<String> list = ls.getName();
	List<Integer> list2 = ls.getNum();
	List<MemberVO> list3 = ls.getMlist();
	
	for(String e: list){
		out.println(e+"<br/>");
	}
	
	for(Integer e : list2){
		out.println(e+"<br/>");
	}
	
	for(MemberVO e : list3){
		out.println(e.getId()+"<br/>");
		out.println(e.getName()+"<br/>");
		out.println(e.getPwd()+"<br/>");
	}
%>
</body>
</html>
