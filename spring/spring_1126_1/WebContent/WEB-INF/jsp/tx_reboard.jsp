<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변글 작성</title>
<style>
#main {
	text-align: center;
	width: 100%
}

#sub1 {
	margin: auto
}

table {
	width: 450px;
	border: 1px solid gray
}

tbody tr {
	border: 1px solid gray
}
</style>
</head>
<body>
	<div id="main">
		<div id="sub1">
			<form action="tx_reboard.kosta" method="post">
				<!-- 기존 글에 대한 글번호에 대한 정보는 알아야 하므로(=ref) hidden 시켜야 함 -->
				<input type="hidden" name="ref" value="${vo.no}" />
				<!-- 기존 글의 seq와 비교해서 값을 증가 시킬 것이므로...ㅇㅇ -->
				<input type="hidden" name="seq" value="${vo.seq}">
				<table border="1">
					<thead>
						<tr>
							<th colspan="2">답변글 작성 폼</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>작성자</td>
							<td><input type="text" name="writer" id="writer" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="pwd" id="pwd" /></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="subject" id="subject" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="tx_ 답변글 작성"/></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
