<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글 view</title>
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
	<!-- row=5 col=2-->
	<div id="main">
		<div id="sub1">
			<table border="1">
				<thead>
					<tr>
						<th colspan="2">게시판 상세보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>번호</td>
						<td>${vo.no}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><s:property value="vo.writer" /></td>
					</tr>
					<tr>
						<td>제목</td>
						<td>${vo.subject}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td><s:property value="vo.content" /></td>
					</tr>


					<!-- 답변 사용 -->
					<tr>
						<td align="center">

							<form action="reboardf.kosta" method="post">
								<input type="hidden" name="ref" value="${vo.ref}" /> <input
									type="hidden" name="seq" value="${vo.seq}"> <input
									type="hidden" name="lvl" value="${vo.lvl}"> <input
									type="submit" value="답변">

							</form>
						</td>
					</tr>

					<!-- 답변 사용 -->
					<tr>
						<td align="center">
							<form action="tx_reboardf.kosta" method="post">
								<!-- 넘어와야 되는 것... 번호.. 번호에 딸린 seq의 수 -->
								<input type="hidden" name="no" value="${vo.no}" /> <input
									type="hidden" name="seq" value="${vo.seq}"> <input
									type="submit" value="tx답변">

							</form>
						</td>
					</tr>


					<tr>
						<td colspan="2">
							<form method="post" action="commIn.do">
								<input type="hidden" name="no" value="${vo.no}" />
								<table border="1">
									<tr>
										<td>내용 <input type="text" name="comm" />
										</td>
										<td>작성 <input type="text" name="writer" />
										</td>
										<td>비밀번호 <input type="password" name="pwd" />
										</td>
										<td><input type="submit" value="글작성" /></td>
									</tr>
								</table>
							</form>
						</td>

					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td>내용</td>
									<td>작성자</td>
									<td>날짜</td>
								</tr>
								<s:iterator value="list" status="stat">
									<!-- 반복문 돌릴 영역 -->
									<tr>
										<td><s:property value="comm" /></td>
										<td><s:property value="writer" /></td>
										<td><s:property value="regdate" /></td>
									</tr>
								</s:iterator>
								<!-- 반복문 돌릴영역 -->
							</table>

						</td>

					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
