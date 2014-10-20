<%-- 
    Document   : ex1_hello
    Created on : 2014. 10. 15, 오후 12:02:20
    Author     : kosta
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%!
//여기는 Ex1_HelloServlet.class의 영역이다.
    public String todate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

%>

        <%--
                <% //service 메서드안의 local 영역
                    String name = "SEHYEON";
                    String today = todate();
                %>
                <h1>Name : <%=name%></h1>
                <h1>Time : <%=today%></h1>
        --%>
        <%
            String msg = "HaHaHa";
            String today = todate();
        %>
        <%=msg%>
        <%=today%>
