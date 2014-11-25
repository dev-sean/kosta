<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#wrap {
	width: 500px;
	margin: auto
}

#wrap table {
	width: 100%;
	border: 1px dotted #9900ff
}

#wrap table thead {
	background-color: #b9b9ff;
}
</style>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div id="wrap">
		<table>
			<thead>
				<tr>
					<th colspan="5">Bbs1 List</th>
				</tr>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성날짜</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listv" items="${list}">
					<tr>
						<td><a href="detail.kosta?num=${listv.num }">${listv.num }</a></td>
						<td>${listv.sub }</td>
						<td>${listv.writer }</td>
						<td>${listv.hit }</td>
						<td>${listv.regdate }</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><input type="button" value="write"
						onclick="location='form.kosta'"></td>
				</tr>
			</tfoot>
		</table>
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>