<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#wrap {
	width: 550px;
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
		<table>
			<thead>
				<tr>
					<th colspan="2">Bbs1 View</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="fd">제 목</td>
					<td>${vo.sub}</td>
				</tr>
				<tr>
					<td class="fd">작 성 자</td>
					<td>${vo.writer}</td>
				</tr>
				<tr>
					<td class="fd">작성 날짜</td>
					<td>${vo.regdate}</td>
				</tr>
				<tr>
					<td class="fd">내 용</td>
					<td>${vo.cont}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2"><input type="button" value="write"
						onclick="location='form.kosta'"> &nbsp; <input
						type="button" value="list" onclick="location='list.kosta'">
					</th>
				</tr>
			</tfoot>
		</table>
		<form method="post" action="bbs1Comm.kosta">
			<input type="hidden" name="kcode" value="${vo.num}"> 
			<input type="hidden" name="reip" value="${request.RemoteAddr}">
			<table>
				<tr>
					<td>
						<!-- ☆ ★  --> <select name="cnt">
							<option value="5">★★★★★</option>
							<option value="4">★★★★☆</option>
							<option value="3" selected="selected">★★★☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="1">★☆☆☆☆</option>
					</select>
					</td>
					<td><input name="writer" size="15"></td>
					<td><textarea rows="3" cols="30" name="comm"></textarea></td>
					<td><input type="submit" value="작성"></td>
				</tr>
			</table>
		</form>
		<table>
			<c:forEach var="coList" items="${cList}">
				<tr>
					<c:choose>
						<c:when test="${coList.cnt=='1' }">
							<td>★☆☆☆☆</td>
						</c:when>
					 	<c:when test="${coList.cnt=='2' }">
							<td>★★☆☆☆</td>
						</c:when>
					 	<c:when test="${coList.cnt=='3' }">
							<td>★★★☆☆</td>
						</c:when>
					 	<c:when test="${coList.cnt=='4' }">
							<td>★★★★☆</td>
						</c:when>
					 	<c:when test="${coList.cnt=='5' }">
							<td>★★★★★</td>
						</c:when>
					 
					</c:choose>
					<td>${coList.comm}</td>
					<td>${coList.writer}</td>
					<td>${coList.regdate}/${coList.reip}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
