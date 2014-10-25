<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    
    String address = request.getParameter("new_address");
 
    Connection con = null;
    PreparedStatement pstm = null;    
    try {
        con = ConnUtil.getConn();  
        StringBuffer sql = new StringBuffer();
        sql.append("insert into orders values(users_seq.nextVal,?,?,?,?)");
        pstm = con.prepareStatement(sql.toString());
        pstm.setString(1, "ko1");
        pstm.setString(2, address);
        pstm.setString(3, "delivery_time");
        pstm.setString(4, "store_no");
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

