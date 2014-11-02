<%-- 
    Document   : test
    Created on : 2014. 10. 31, ¿ÀÈÄ 3:23:03
    Author     : kosta
--%>

<%@page import="conn.ConnUtils"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    Connection con = ConnUtils.getConn();
    System.out.println("Log:"+con);
    %>