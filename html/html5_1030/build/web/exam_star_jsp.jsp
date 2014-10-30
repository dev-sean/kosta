<%@page import="ex1.Ex1_Girl"%>
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<%
    String code = request.getParameter("groupName");
    // 객체생성 
    Ex1_Girl girl = new Ex1_Girl();
    // 메서드 호출후 해당 code에 따른 데이터를 문자열로 반환 받음
    String[] gg = girl.getGirlGroup(code);
    System.out.println(gg.length);
%><option>선택</option>
<% for (String e : gg) {%>
<option><%=e%></option>
<%}%>

