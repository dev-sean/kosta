<%-- 
    Document   : ex3_basicData
    Created on : 2014. 10. 30, ���� 11:47:42
    Author     : kosta
--%>

<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
    String name = request.getParameter("name");
    String ordNum = request.getParameter("orderNum");
    String status = "";
    if (name.equals("��浿") && ordNum.equals("A001")) {
        status = "�ֹ��Ͻ� ��ǰ�� ���� �߼� ���Դϴ�.";
    } else if (name.equals("��츮") && ordNum.equals("A002")) {
        status = "�ֹ��Ͻ� ��ǰ�� ���� ����ǰ�� �߼� �Ǿ����ϴ�.";
    } else {
        status = "�̹� �߼۵� ��ǰ�Դϴ�.";
    }

%>
<%=status%>