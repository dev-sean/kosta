<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	#chkRes{
		width:160px;
		border : 1px dotted gray;
		height : 20px;
		display:none;
	}
	.content{
		width:400px;
		margin:auto;
	}
</style>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn').click(function(){
			var idv = $('#id').val();
			var sendData = "id="+idv;
			//ajaxSetup : ajax�۾��� �⺻���� ����, �������� ������ ������ �� �ִ�. 
			$.ajaxSetup({
				type:"post",
				url:"idcheck.kosta",
				dataType:"text", //�޾Ƴ��� ������ Ÿ��
				success:function(msg){
					$('#chkRes').css("display","block").html(msg);
				}				
			});
			$.ajax({
				data : sendData
			});
			return false;
		});
	});
</script>
</head>
<body>
	<div class="content">
		<form method="post" action="join.kosta">
			<table>
				<tr><td colspane="2">���̵��ߺ�üũ����</td></tr>
				<tr>
					<td>���̵�</td>
					<td>
						<input type="text" name="id" id="id">&nbsp;
						<input type="button" id="btn" value="�ߺ�üũ">
					</td>
				</tr>
				<tr>
					<td colspane="2"><div id="chkRes"></div></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>