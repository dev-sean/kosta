<%-- 
    Document   : idcheck
    Created on : 2014. 10. 31, 오후 5:07:50
    Author     : kosta
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="conn.ConnUtils"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String idv = request.getParameter("id");
    Connection con = ConnUtils.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    StringBuffer sb = new StringBuffer();
    
    sb.append("select count(*) cnt from mymember where id=?");
    pstm = con.prepareStatement(sb.toString());
    pstm.setString(1, idv);
    rs = pstm.executeQuery();
    int cnt = 0;
    if(rs.next()){
        cnt = rs.getInt("cnt");
    }
    String msg="";
    if(cnt != 0){
        msg = "중복 아이디입니다.";
    }else{
        msg = "사용가능한 아이디입니다.";
    }
    
%><%=msg%>