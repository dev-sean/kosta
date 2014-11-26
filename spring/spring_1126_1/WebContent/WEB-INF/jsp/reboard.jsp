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
			<form action="reboard.kosta" method="post">
				<!-- 다음 페이지로 이동할때 답변글에 대한 처리를
                    해주기 위해서 답변글에 대한 정보를 갱신한 후 
                        폼의 히든 값으로 전송을 한다.-->
				<input type="text" name="ref" value="${vo.ref}" /> 
				<input type="text" name="seq" value="${vo.seq+1}" /> 
				<input type="text" name="lvl" value="${vo.lvl+1}" />

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
							<td colspan="2"><input type="submit" value="답변글 작성" /></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
