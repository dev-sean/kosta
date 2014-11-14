<%@page import="java.util.Set"%>
<%@page import="javafx.scene.web.WebHistory.Entry"%>
<%@page import="java.util.Map"%>

<%@page import="java.util.Properties"%>
<%@page import="ex4.PropertiesType"%>
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
	ApplicationContext ctx = new GenericXmlApplicationContext("ex4/prop.xml");
	PropertiesType pt = ctx.getBean("myProp", PropertiesType.class);
	Properties prop = pt.getProp();
	
	String str1 = prop.getProperty("admin_email");
	String str2 = prop.getProperty("jobSite");	
%>
관리자 Email : <%=str1 %> <br/>
<a href=<%=str2 %>>WebSite</a>
</body>
</html>