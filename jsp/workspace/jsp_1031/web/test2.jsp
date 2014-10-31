<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<% 
    String col = request.getParameter("color");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>JSP Page</title>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <style>
            div{
                background: <%=col %>;
            }
        </style>
        <script> 
            $(document).ready(function(){
       
       
             });
        </script>
    </head>
    <body>
        <div>안녕</div>
    </body>
</html>
