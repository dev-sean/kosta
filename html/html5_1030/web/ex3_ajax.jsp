<%-- 
    Document   : ex3_ajax
    Created on : 2014. 10. 30, 오전 11:53:50
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
            $(document).ready(function(){
                $("#btn1").click(function(){
                    var n = $('#name').val();
                    var on = $('#orderNum').val();
                    //$ajax() : 메서드를 사용한 Ajax통신
                    //url : 비동기식으로 보낼 서버측 주소
                    //data : 보낼 파라미터
                    //success : 성공했을 때 callback
                    //error : 실패!
                    $.ajax({
                        url:"ex3_basicData.jsp",
                        data:{name:n, orderNum:on},
                        success: function(data, status){
                            console.log("Status:"+status);
                            $('#res').html(data);
                        
                        },
                        error:function(e){
                            console.log(e);
                        }
                    });
                });       
             });
        </script>
    </head>
       
      
    <body>
        <h1>주문확인</h1>
        <input type="text" name="name" id="name"><br/>
        <input type="text" name="orderNum" id="orderNum"><br/>
        <input type="button" value="click" id="btn1"><br/>
        <div id="res">Status:</div>
    </body>
</html>
