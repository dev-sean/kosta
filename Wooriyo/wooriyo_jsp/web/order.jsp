<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String gidv = request.getParameter("id");
    Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstm = null;
    ResultSet rr = null;
    ResultSet rs = null;
    int cnt = 0;
    int i = 0;
    // StringBuffer str = null;
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) cnt from orders where id=?");
        pstm = con.prepareStatement(sb.toString());
        pstm.setString(1, gidv);
        rr = pstm.executeQuery();
        if (rr.next()) {
            cnt = rr.getInt("cnt");
        }
 
        StringBuffer sql = new StringBuffer();
        sql.append("select * from orders where id=?");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, gidv);
        rs = pstmt.executeQuery();

        String output = "";
        out.print("[");
        StringBuffer str = new StringBuffer();
        while (rs.next()) {
            ++i;
            int order_no = rs.getInt("order_no");
            String id = rs.getString("id");
            String address = rs.getString("address");
            String delivery_time = rs.getString("delivery_time");
            String store_no = rs.getString("store_no");
                   
            output = "{" + "\"" + "order_no" + "\"" + ":" + "\"" + order_no + "\"" + ","
                    + "\"" + "id" + "\"" + ":" + "\"" + id + "\"" + ","
                    + "\"" + "address" + "\"" + ":" + "\"" + address + "\"" + ","
                    + "\"" + "delivery_time" + "\"" + ":" + "\"" + delivery_time + "\"" + ","
                    + "\"" + "store_no" + "\"" + ":" + "\"" + store_no + "\"" + "}";

            if (i < cnt) {
                str.append(output + ",");
            } else {
                str.append(output);
            }
        }
        out.println(str+"]");
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rr != null) {
                rr.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
%>