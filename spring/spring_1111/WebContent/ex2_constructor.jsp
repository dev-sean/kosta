<%@page import="ex1.Service"%>
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
		//spring3.0부터 제공하는 제너릭으로 최적화된 스프링 컨테이너
		ApplicationContext ctx = new GenericXmlApplicationContext("ex1/ex2_const.xml");
		Service svc = ctx.getBean("svc2",Service.class);
		
	%>
	<%=svc.moniter() %><br/>
	
</body>
</html>