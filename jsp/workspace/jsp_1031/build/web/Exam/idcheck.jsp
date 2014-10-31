<%-- 
    Document   : idcheck
    Created on : 2014. 10. 31, ¿ÀÈÄ 5:07:50
    Author     : kosta
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="conn.ConnUtils"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    Connection con = ConnUtils.getConn();
    PreparedStatement pstm = null;
    StringBuffer sb = new StringBuffer();
    
    
%>