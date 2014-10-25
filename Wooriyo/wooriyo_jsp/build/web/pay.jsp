<%@page import="java.sql.SQLException"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String editCardNumber = request.getParameter("editCardNumber");
    String editValidMonth = request.getParameter("editValidMonth");
    String editValidYear = request.getParameter("editValidYear");
    String editPassword = request.getParameter("editPassword");
    String editJumin = request.getParameter("editJumin");

    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    int num = 0;
    String cardnumber = null;
    String validmonth = null;
    String validyear = null;
    int cardpassword = 0;
    String jumin = "";
    try {
        con = ConnUtil.getConn();
        StringBuffer sb = new StringBuffer();
        sb.append("select * from card");
        pstm = con.prepareStatement(sb.toString());

        rs = pstm.executeQuery();

        StringBuffer str = new StringBuffer();
        while (rs.next()) {
            num = rs.getInt("card_no");
            cardnumber = rs.getString("card_number");
            validmonth = rs.getString("valid_month");
            validyear = rs.getString("valid_year");
            cardpassword = rs.getInt("password");
            jumin = rs.getString("jumin");
        }

        if (cardnumber.equals(editCardNumber)) {
            out.println("cardnumbertrue");
        } else {
            out.println("cardnumberfalse");
        }
        if (validmonth.equals(editValidMonth)) {
            out.println("monthtrue");
        } else {
            out.println("monthfalse");
        }
        if (validyear.equals(editValidYear)) {
            out.println("yeartrue");
        } else {
            out.println("yearfalse");
        }
        //editPassword.startsWith(String.valueOf(editPassword));
        if ((cardpassword / 100) == Integer.parseInt(editPassword)) {
            out.println("passtrue");
        } else {
            out.println("passfalse");
        }
        if (jumin.equals(editJumin)) {
            out.println("jumintrue");
        } else {
            out.println("juminfalse");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
%>