<%-- 
    Document   : idtest
    Created on : 2014. 10. 23, ¿ÀÈÄ 3:19:24
    Author     : Soo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
    String id = request.getParameter("id");
    Connection con = null;

    PreparedStatement idpstm = null;
    ResultSet rs = null;
    int res = 0;
    try {
        con = ConnUtil.getConn();
        StringBuffer idtest = new StringBuffer();
        idtest.append("select count(*)id from users where id=?");

        idpstm = con.prepareStatement(idtest.toString());
        idpstm.setString(1, id);
        rs = idpstm.executeQuery();
        if (rs.next()) {
            res = rs.getInt("id");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
            if (idpstm != null) {
                idpstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (res > 0) {
        out.print("false");

    } else {
        out.print("true");
    }

%>