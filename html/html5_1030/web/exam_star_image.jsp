<%-- 
    Document   : ex3_ajaxImgData
    Created on : 2014. 9. 19, ���� 5:08:09
    Author     : kosta
--%>

<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
    String gname = request.getParameter("gname");
    gname = gname.trim();
    System.out.println("GName : " + gname);
    //"����","�츮","����","�̶�"
    String imgName = "";
    if (gname.equals("����")) {
        imgName = "images/sin1.jpg";
    } else if (gname.equals("�츮")) {
        imgName = "images/sin2.jpg";
    } else if (gname.equals("����")) {
        imgName = "images/sin3.jpg";
    } else if (gname.equals("�̶�")) {
        imgName = "images/sin4.jpg";
        //"����","����","ȿ��","����"","ť��,"�ҿ�"
    } else if (gname.equals("����")) {
        imgName = "images/sin1.jpg";
    } else if (gname.equals("����")) {
        imgName = "images/sin2.jpg";
    } else if (gname.equals("ȿ��")) {
        imgName = "images/sin3.jpg";
    } else if (gname.equals("ť��")) {
        imgName = "images/sin4.jpg";
    } else if (gname.equals("�ҿ�")) {
        imgName = "images/sin5.jpg";
    }
%><%=imgName%>
