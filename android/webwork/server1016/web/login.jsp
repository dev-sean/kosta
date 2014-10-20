<%-- 
    Document   : login
    Created on : 2014. 10. 16, 오후 1:35:18
    Author     : kosta
--%>

<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    //파라미터 처리 (id, pwd)
    String idv = request.getParameter("id");
    String pwdv = request.getParameter("pwd");
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    int res = 0;
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) cnt from andmem where id=? and pwd=?");
        pstm = con.prepareStatement(sb.toString());
        pstm.setString(1, idv);
        pstm.setString(2, pwdv);
        rs = pstm.executeQuery();
        
        if (rs.next()) {
            res = rs.getInt("cnt");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    String msg = "";
    if (res > 0) {
        msg = "Success!";
    } else {
        msg = "Fail!";
    }

%>
<%=idv%> : <%=msg%>
