<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div id="wrap">
		<form method="post" action="bbs1In.kosta">
			<input type="hidden" name="reip" value="${request.RemoteAddr}">
			<table>
				<thead>
					<tr>
						<th colspan="2">Bbs1 입력폼</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="fd">제 목</td>
						<td><input name="sub" id="sub"></td>
					</tr>
					<tr>
						<td class="fd">작 성 자</td>
						<td><input name="writer" id="writer"></td>
					</tr>
					<tr>
						<td class="fd">비 밀 번 호</td>
						<td><input name="pwd" id="pwd" type="password" maxlength="10">
						</td>
					</tr>
					<tr>
						<td class="fd">내 용</td>
						<td><textarea rows="20" cols="20" name="cont" id="cont"></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2"><input type="submit" value="send">
							&nbsp; <input type="button" value="list"
							onclick="location='list.kosta'"></th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

