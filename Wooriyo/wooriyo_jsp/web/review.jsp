<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>

<%
    request.setCharacterEncoding("EUC-KR");
    //String reId = request.getParameter("userid");
    String reContent = request.getParameter("content");
    
    String reStarpoint = request.getParameter("starpoint");
    //String reImage = request.getParameter("image");
    //String reStore = request.getParameter("store_no");
    System.out.println(reContent);
    Connection con = null;
    PreparedStatement pstm = null;
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
  

        //id, content, starpoint, image, time, store
        sb.append("insert into board values(board_seq.nextVal, ?, ?, ?, ?, sysdate, ?)");
        pstm = con.prepareStatement(sb.toString());
        pstm.setString(1, "ko1");
        pstm.setString(2, reContent);
        pstm.setString(3, reStarpoint);
        pstm.setString(4, "http://image.gmarket.co.kr/mobileecoupon_image/2014/02/11/20140211093431485695_0_0.jpg");
        pstm.setString(5, "5");
        
        pstm.executeUpdate();
        
        out.print("success");
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }      
%>