<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cos.jar�� ����� ���� ���ε�</title>
<style>
#wrap {
	width: 300px;
	border: 1px solid red;
	margin: auto;
}
</style>
</head>
<body>
	<div id="wrap">
		<!-- enctype="multipart/form-data" ���ε� ���� �Ӽ��̸�, �ݵ�� post�� ���� 
		�Ϲ����� request�δ� ���̻� jsp������ �Ķ���ͷ� ó�� �� �� ���� ������
		apache io or cos.jar �����޾Ƽ� ó�� -->
		<h1>���� ���ε� ����</h1>
		<form method="post" action="ex3_upload.jsp" id="f"
			enctype="multipart/form-data">
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<p>
				�ۼ��� : <input type="text" name="writer">
			</p>
			<p>
				���� : <input type="file" name="s_file">
			</p>
			<p>
				<input type="submit" value="send">
			</p>
		</form>
	</div>
</body>
</html>