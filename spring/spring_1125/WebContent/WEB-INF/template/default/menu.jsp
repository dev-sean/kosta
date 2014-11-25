<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="menu">
Menu
<ul>
	<li>
		<spring:url value="/home.kosta" var="homeUrl" htmlEscape="true"></spring:url>
		<a href="${homeUrl}">Home</a>
	</li>
	<li>
		<spring:url value="/list.kosta" var="listUrl" htmlEscape="true"></spring:url>
		<a href="${listUrl}">List</a>
	</li>
	<li>
		<a href="#">Menu1</a>
	</li>
	<li>
		<a href="#">Menu2</a>
	</li>
	<li>
		<a href="#">Menu3</a>
	</li>
</ul>
</div>