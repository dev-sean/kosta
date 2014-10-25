<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("EUC-KR");
    String gidv = request.getParameter("store_category");
    System.out.println(gidv);
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
        sb.append("select count(*) cnt from store where store_category=?");
        pstm = con.prepareStatement(sb.toString());
        pstm.setString(1, gidv);
        rr = pstm.executeQuery();
        if (rr.next()) {
            cnt = rr.getInt("cnt");
        }
 
        StringBuffer sql = new StringBuffer();
        sql.append("select * from store where store_category=?");
        pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, gidv);
        rs = pstmt.executeQuery();

        String output = "";
        out.print("[");
        StringBuffer str = new StringBuffer();
        while (rs.next()) {
            ++i;
            int store_no = rs.getInt("store_no");
            String store_name = rs.getString("store_name");
            String store_image = rs.getString("store_image");
            float store_avgpoint = rs.getFloat("store_avgpoint");
            String store_address = rs.getString("store_address");
            String store_time = rs.getString("store_time");
            String store_delivery_location = rs.getString("store_delivery_location");
            String store_tel = rs.getString("store_tel");
            String store_category = rs.getString("store_category");
            int store_avg_delivery_time = rs.getInt("store_avg_delivery_time");          
            output = "{" + "\"" + "store_no" + "\"" + ":" + "\"" + store_no + "\"" + ","
                    + "\"" + "store_name" + "\"" + ":" + "\"" + store_name + "\"" + ","
                    + "\"" + "store_image" + "\"" + ":" + "\"" + store_image + "\"" + ","
                    + "\"" + "store_avgpoint" + "\"" + ":" + "\"" + store_avgpoint + "\"" + ","
                    + "\"" + "store_address" + "\"" + ":" + "\"" + store_address + "\"" + ","
                    + "\"" + "store_time" + "\"" + ":" + "\"" + store_time + "\"" + ","
                    + "\"" + "store_delivery_location" + "\"" + ":" + "\"" + store_delivery_location + "\"" + ","
                    + "\"" + "store_tel" + "\"" + ":" + "\"" + store_tel + "\"" + ","
                    + "\"" + "store_category" + "\"" + ":" + "\"" + store_category + "\"" + ","
                    + "\"" + "store_avg_delivery_time" + "\"" + ":" + "\"" + store_avg_delivery_time + "\"" + "}";

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