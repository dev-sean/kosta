<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글 write</title>
</head>
<body>
	<!-- row = 6 설정 -->
	<form action="write.kosta" method="post" id="f">
		<table border="1" align="center" width="450">
			<thead>
				<tr>
					<th colspan="2">게시판 작성 폼</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" id="subject" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" id="writer" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd" id="pwd" /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" id="content" rows="5" cols="15">
                            </textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" onclick="sendForm()"
						value="글작성"> &nbsp; <input type="button"
						onclick="goList('list.kosta','')" value="리스트"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<script type="text/javascript">
		// form유효성 검사 이후 폼의 데이터를 전송하는 스크립트
		function sendForm() {
			$('#f').submit();
		}
		function goList(url, param) {
			if (!param)
				url = url;
			else
				url = url + "?" + param;
			location = url;
		}
	</script>
</body>
</html>
