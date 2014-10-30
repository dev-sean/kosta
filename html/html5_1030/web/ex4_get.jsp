<%-- 
    Document   : ex4_get
    Created on : 2014. 10. 30, 오후 2:38:18
    Author     : kosta
--%>

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

                $('#btn').click(function () {

                    $.get('ex4_Data.jsp', {name: $('#name').val()},
                    function (data) {
                        $('#message').html(data);
                    }
                    );
                });

            });
        </script>
    </head>


    <body>
        <h1>Get방식으로 전송 : get()</h1>
        이름 : <input type="text" name="name" id="name">
        <input type="button" id="btn" value="Click">
        <div id="message"></div>
    </body>
</html>
