<%-- 
    Document   : ex3_ajaxImgData
    Created on : 2014. 9. 19, 오후 5:08:09
    Author     : kosta
--%>

<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
    String gname = request.getParameter("gname");
    gname = gname.trim();
    System.out.println("GName : " + gname);
    //"유라","헤리","소진","미라"
    String imgName = "";
    if (gname.equals("유라")) {
        imgName = "images/sin1.jpg";
    } else if (gname.equals("헤리")) {
        imgName = "images/sin2.jpg";
    } else if (gname.equals("소진")) {
        imgName = "images/sin3.jpg";
    } else if (gname.equals("미라")) {
        imgName = "images/sin4.jpg";
        //"보람","지연","효민","은정"","큐리,"소연"
    } else if (gname.equals("보람")) {
        imgName = "images/sin1.jpg";
    } else if (gname.equals("지연")) {
        imgName = "images/sin2.jpg";
    } else if (gname.equals("효민")) {
        imgName = "images/sin3.jpg";
    } else if (gname.equals("큐리")) {
        imgName = "images/sin4.jpg";
    } else if (gname.equals("소연")) {
        imgName = "images/sin5.jpg";
    }
%><%=imgName%>
