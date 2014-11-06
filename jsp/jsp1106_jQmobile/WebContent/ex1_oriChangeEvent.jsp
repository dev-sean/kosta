<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>

</style>
<script>
	$(document).ready(function(){
		$(window).bind('orientationchange', function(){
			//상황에 따른 핸들링
			//Ajax를 사용해서 사용자의 화면 값을 서버로 보내고 그에 맞도록
			//시스템을 변경해서 값을 콜백해줄수 있다.
			if(window.orientation === 0){
				$('body').css('background','pink').html('hi!!');
				
			}else{
				$('body').css('background','blue').html('good!!');
			}
		});

	});
</script>
</head>
<body>

</body>
</html>