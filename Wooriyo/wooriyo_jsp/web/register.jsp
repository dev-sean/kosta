<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String email = request.getParameter("email");
    Connection con = null;
    PreparedStatement pstm = null;
    try {
        con = ConnUtil.getConn();
        StringBuffer sql = new StringBuffer();
        sql.append("insert into users values(users_seq.nextVal,?,?,?)");
        pstm = con.prepareStatement(sql.toString());
        pstm.setString(1, id);
        pstm.setString(2, pw);
        pstm.setString(3, email);
        pstm.executeUpdate();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

