<%-- 
    Document   : boardin
    Created on : 2014. 10. 15, 오후 2:18:34
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
        result = "미성년자";
    } else {
        result = "미성년자가 아닙니다.";
    }

    //1. JDBC를 사용하기 위해서 Connection을 획득
    Connection con = null;
    PreparedStatement pstm = null;
    //2. SQL 문장 완성
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
        //클라이언트의 아이피정보
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
            <h1> <%="제목:" + title%></h1>
            <h1>  <%="내용:" + content%></h1>
            <h1>  <%="나이:" + age%></h1>
            <h1>   <%="작성자:" + user%></h1>
            <h1>   <%="비밀번호:" + pwd%></h1>
            <h1>  <%="성별:" + sex%></h1>
            <h1>   <%="결과:" + result%></h1>
            <a href="exam1.html">다시쓰기</a>
            <a href="examlist.jsp">목록보기</a>

        </div>
    </body>
</html>
