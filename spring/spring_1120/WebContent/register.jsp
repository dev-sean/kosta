<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
<style type="text/css">
#wrap {
	width: 450px;
	margin: auto
}

#wrap table {
	width: 100%;
	border: 1px dotted #9900ff
}

#wrap table .fd {
	width: 100px;
	background-color: #b9b9ff;
	font-weight: bold;
	text-align: center
}

#sub {
	width: 250px;
}
</style>
</head>
<body>
	<div id="wrap">
		<form method="post" action="regIn.kosta">
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<table>
				<thead>
					<tr>
						<th colspan="2">ȸ������ �Է���</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="fd">�� ��</td>
						<td><input name="name" id="name"></td>
					</tr>
					<tr>
						<td class="fd">ID</td>
						<td><input name="id" id="id"></td>
					</tr>
					<tr>
						<td class="fd">�� �� �� ȣ</td>
						<td><input name="pwd" id="pwd" type="password" maxlength="10">
						</td>
					</tr>
					<tr>
						<td class="fd">E-mail</td>
						<td><input type="email" name="email" id="email">
						</td>
					</tr>
					<tr>
						<td class="fd">��ȭ��ȣ</td>
						<td><input type="tel" name="tel" id="tel"></td>
					</tr>
					<tr>
						<td class="fd">����</td>
						<td><input type="file" name="mfile" id="mfile"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2"><input type="submit" value="send">
							&nbsp; <input type="button" value="list"
							onclick="location='regList.kosta'"></th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>

