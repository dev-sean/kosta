<%-- 
    Document   : ex1_hello
    Created on : 2014. 10. 15, ���� 12:02:20
    Author     : kosta
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%!
//����� Ex1_HelloServlet.class�� �����̴�.
    public String todate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

%>

        <%--
                <% //service �޼������ local ����
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
