<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="ex1_top.jsp"%>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('#btn1').click(function() {

			$.ajax({
				url : "idcheck.jsp",
				data : {
					'id' : $('#id').val()
				},
				success : function(data) {
					var iValue = data.indexOf("success");
					if (iValue != -1){
						alert("��밡���� ���̵��Դϴ�.");
					} else {
						alert("�ߺ��� ���̵��Դϴ�.");
					}
				},
				error : function(e) {
					console.log(e);
				}
			});
		});
	});
</script>
<article>
	<p>���� IT���� ���� �����޴� java Technology�� ���ʺ��� ��ޱ������ �н��մϴ� ��������
		�����ӿ�ũ(java opensource framework)�� �̿��� Enterprise Solution ���� �� ������
		�ȵ���̵� �� ���̺긮����� �̿��� ����� ���ø����̼� ������ �н��ϰ� �ǹ� ������Ʈ�� ���� �������� �ʿ�� �ϴ� �ڹ�
		�����Ͼ� �缺�� ��ǥ�� �մϴ�.</p>
	<section>
		<header style="margin: auto; width: 100%;">
			<h2>Join Page</h2>
		</header>
		<p>
		<form method="post" action="join_ok.jsp">
			<table style="margin: auto; width: 400px">
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" id="id"> <!-- Ajax & jQuery�� �����ϱ� -->
						<input type="button" id="btn1" value="�ߺ�Ȯ��"></td>
				</tr>
				<tr>
					<td>PWD</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>info</td>
					<td><textarea rows="10" cols="22" name="info"></textarea>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="�Ϸ�"></td>
				</tr>
			</table>
		</form>
		</p>
	</section>
</article>
<aside>
	<header>
		<h1>Siderbar Heading</h1>
	</header>
	<p>������ �� ������ �ƴ� ���ü��� ���� ������� aside�� ǥ���� �� �ִ�. ������ ���������� ����� ���� ����
		����Ʈ ��ũ�� �ȳ���, nav ����� �׷� ���� aside ��ҷ� ��� �� �� �ִ�. ���� ��α׿��� �¿��� ���̵�ٸ�
		�ǹ��ϴ� �����μ� ���̵���� Ư������ ���� �ʼ������� �ʾƼ� ǥ�ø� �ص� �ǰ� �� �ص� �Ǵ� ����� �Ǵ� �������� �������
		�ڸ��� �� �ִ�.</p>

</aside>
<%@include file="ex1_bottom.jsp"%>