<%-- 
    Document   : myform
    Created on : 2014. 10. 15, ���� 2:00:04
    Author     : kosta
--%>

<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    //myform.html���� ���� ���� ��ư�� ������ action���� ������ ���� ��������
    //name="id" ������ �Ķ���� �̸����� ���� �ٶ� ������ �Ǿ�´�.
    //���⼭�� �Ķ���͸� �޴� �۾�
    //�װ��� �����ϴ� �۾�(��� ����,���� ���� �����Ͻ� ����)
    //1. �Ķ���� �ޱ�
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String select = request.getParameter("etc");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>JSP Page</title>

    </head>

    <body>
        <h1><%=id%></h1>
        <h1><%=pwd%></h1>
        <h1><%=name%></h1>
        <h1><%=select%></h1>
    </body>
</html>
