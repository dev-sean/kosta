<%-- 
    Document   : examlist
    Created on : 2014. 10. 15, 오후 5:10:23
    Author     : kosta
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="conn.ConnUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>JSP Page</title>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script>
            $(document).ready(function () {


            });
        </script>
    </head>


    <body>
        <table>
            <tr>
                <td>번호</td>
                <td>제목</td>
                <td>내용</td>
                <td>나이</td>
                <td>작성자</td>
                <td>비밀번호</td>
                <td>성별</td>
                <td>조회수</td>
                <td>IP</td>
                <td>작성날짜</td>            
            </tr>
            <%
                request.setCharacterEncoding("euc-kr");
                //1. JDBC를 사용하기 위해서 Connection을 획득
                Connection con = null;
                PreparedStatement pstm = null;
                ResultSet rs = null;
                int num;
                String title;
                String cont;
                int age;
                String name;
                String pwd;
                String sex;
                int hit;
                String reip;
                String rdate;

                //2. SQL 문장 완성
                try {
                    con = ConnUtil.getConn();
                    StringBuffer sql = new StringBuffer();
                    sql.append("select * from jspboard");
                    pstm = con.prepareStatement(sql.toString());
                    rs = pstm.executeQuery();
                    while (rs.next()) {
                        num = rs.getInt("num");
                        title = rs.getString("title");
                        cont = rs.getString("cont");
                        age = rs.getInt("age");
                        name = rs.getString("name");
                        pwd = rs.getString("pwd");
                        sex = rs.getString("sex");
                        hit = rs.getInt("hit");
                        reip = rs.getString("reip");
                        rdate = rs.getString("rdate");

            %>
            <tr>
                <td><%=num%></td>
                <td><%= title%></td>
                <td><%= cont%></td>
                <td><%= age%></td>
                <td><%= name%></td>
                <td><%= pwd%></td>
                <td><%= sex%></td>
                <td><%= hit%></td>
                <td><%= reip%></td>
                <td><%= rdate%></td>            
            </tr>
            <%
                    }
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
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            %>
        </table>
    </body>
</html>
