<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<h1>My Tiles Home Page</h1>
			<p>나의 Home 타일즈 페이지 작성입니다.</p>
			<p>${msg }</p>
			<p>
				<img src="http://spring.io/img/springone-logo.png">
			</p>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

