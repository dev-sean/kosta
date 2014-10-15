<%-- 
    Document   : boardin
    Created on : 2014. 10. 15, ���� 2:18:34
    Author     : kosta
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.Connection"%>
<%
    request.setCharacterEncoding("euc-kr");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String age = request.getParameter("age");
    String user = request.getParameter("user");
    String pwd = request.getParameter("pwd");
    String sex = request.getParameter("sex");
    String result;
    if (Integer.parseInt(age) < 19) {
        result = "�̼�����";
    } else {
        result = "�̼����ڰ� �ƴմϴ�.";
    }

    //1. JDBC�� ����ϱ� ���ؼ� Connection�� ȹ��
    Connection con = null;
    PreparedStatement pstm = null;
    //2. SQL ���� �ϼ�
    try {
        con = ConnUtil.getConn();
        StringBuffer sql = new StringBuffer();
        sql.append("insert into jspboard ");
        sql.append(" values(jspboard_seq.nextVal,?,?,?,?,?,?,0,?,sysdate)");
        pstm = con.prepareStatement(sql.toString());
        pstm.setString(1, title);
        pstm.setString(2, content);
        pstm.setInt(3, Integer.parseInt(age));
        pstm.setString(4, user);
        pstm.setString(5, pwd);
        pstm.setString(6, sex);
        //Ŭ���̾�Ʈ�� ����������
        pstm.setString(7, request.getRemoteAddr());
        pstm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>JSP Page</title>
    </head>

    <body>
        <%
            String color = null;

            if (sex.equals(
                    "M")) {
                color = "blue";
            } else if (sex.equals(
                    "F")) {
                color = "pink";
            }
        %>
        <!--<div style="background-color:<%=color%>">-->
        <div>
            <h1> <%="����:" + title%></h1>
            <h1>  <%="����:" + content%></h1>
            <h1>  <%="����:" + age%></h1>
            <h1>   <%="�ۼ���:" + user%></h1>
            <h1>   <%="��й�ȣ:" + pwd%></h1>
            <h1>  <%="����:" + sex%></h1>
            <h1>   <%="���:" + result%></h1>
            <a href="exam1.html">�ٽþ���</a>
            <a href="examlist.jsp">��Ϻ���</a>

        </div>
    </body>
</html>
