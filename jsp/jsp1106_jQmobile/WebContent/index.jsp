<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- 
	viewport : ����� ȭ��� ���õ� ������ �����ϱ� ���� ��Ÿ�±� 
	content : ȭ�鼳�� �Ӽ�
		width="ȭ���� �ʺ�", device-width:��ġ�� �ʺ�
		height="ȭ���� ����"
	initial-scale : �ʱ� ȭ���� Ȯ�����
	user-scalable : ����� ���� Ȯ�� no - ����ڴ� Ȯ�� ����
-->
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>

</style>
<script>
	$(document).ready(function(){
		$('#btn').click(function(){
			//navigator ��ü�� userAgent �Ӽ��� ����ؼ�
			//Ŭ���̾�Ʈ(��������)�� ������ �������
			var userAgent = navigator.userAgent;
			console.log("Client Device : "+userAgent);
			alert(userAgent);
		});
	});
</script>
</head>
<body>
	<input type="button" id="btn" value="click">
</body>
</html>