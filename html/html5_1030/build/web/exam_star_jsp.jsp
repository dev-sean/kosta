<%@page import="ex1.Ex1_Girl"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String code = request.getParameter("groupName");
    // ��ü���� 
    Ex1_Girl girl = new Ex1_Girl();
    // �޼��� ȣ���� �ش� code�� ���� �����͸� ���ڿ��� ��ȯ ����
    String[] gg = girl.getGirlGroup(code);
    System.out.println(gg.length);
%><option>����</option>
<% for (String e : gg) {%>
<option><%=e%></option>
<%}%>

