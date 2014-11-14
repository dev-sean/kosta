<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="ex2.MapType"%>
<%@page
	import="org.springframework.context.support.GenericXmlApplicationContext"%>
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
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"ex2/context.xml");
		MapType map = ctx.getBean("myMap", MapType.class);
		Map<String, Integer> entry = map.getMaps();

		for (Map.Entry<String, Integer> e : entry.entrySet()) {
	%>
	<%=e.getKey()%>
	/
	<%=e.getValue()%>
	<%
		}
	%>
</body>
</html>