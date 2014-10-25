<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    Connection con = null;
    PreparedStatement idpstm = null;
    ResultSet rs = null;
    int res = 0;
    try {
        con = ConnUtil.getConn();
        StringBuffer idtest = new StringBuffer();
        idtest.append("select count(*) cnt from users where id=? and password=?");
        idpstm = con.prepareStatement(idtest.toString());
        idpstm.setString(1, id);
        idpstm.setString(2, password);
        rs = idpstm.executeQuery();
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

    if (res == 1) {
        out.print("true");

    } else {
        out.print("false");
    }

%>
