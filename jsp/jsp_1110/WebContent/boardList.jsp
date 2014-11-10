<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="ex1_top.jsp"%>
<article>
	<p>현재 IT에서 가장 각광받는 java Technology의 기초부터 고급기술까지 학습합니다 전자정부
		프레임워크(java opensource framework)를 이용한 Enterprise Solution 설계 및 구현과
		안드로이드 및 하이브리드앱을 이용한 모바일 애플리케이션 구현을 학습하고 실무 프로젝트를 통해 현업에서 필요로 하는 자바
		엔지니어 양성을 목표로 합니다.</p>
	<section>
		<header style="margin: auto; width: 100%;">
			<h2>BoardList Page</h2>
		</header>
		<p>
		<form method="post" action="loginok.jsp">
			<table
				style="margin: auto; width: 550px; border: 1px solid black; border-collapse: collapse;">
				<tr style="background-color: #a0a0a0">
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>그룹번호</td>
					<td>조회수</td>
					<td>등록일</td>
				</tr>

				<c:forEach var="listv" items="${list}">
					<tr style="border: 1px solid black;">
						<td>${listv.no }</td>
						<td>${listv.title }</td>
						<td>${listv.writer }</td>
						<td>${listv.groupno }</td>
						<td>${listv.hit }</td>
						<td>${listv.regdate }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6"
						style="text-align: center; border: 1px solid black; border-collapse: collapse;">
						<c:choose>
							<c:when test="${pageInfo.currentBlock eq 1}">
               				 &lt;&lt;
                           </c:when>
							<c:otherwise>
								<a
									href="stboard.kosta?query=boardList&page=${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock }">&lt;&lt;</a>
							</c:otherwise>
						</c:choose> <c:choose>
							<c:when test="${pageInfo.currentBlock ne pageInfo.totalBlocks}">
								<c:forEach begin="1" end="${pageInfo.pagesPerBlock}"
									varStatus="num">
                        [<a
										href="stboard.kosta?query=boardList&page=${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">${(pageInfo.currentBlock
										- 1) * pageInfo.pagesPerBlock + num.count }</a>]
                    </c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach
									begin="${(pageInfo.currentBlock-1)*pageInfo.pagesPerBlock + 1}"
									end="${pageInfo.totalPages}" varStatus="num">
                        [<a
										href="stboard.kosta?query=boardList&page=${(pageInfo.currentBlock - 1) * pageInfo.pagesPerBlock + num.count }">${(pageInfo.currentBlock
										- 1) * pageInfo.pagesPerBlock + num.count }</a>]
                    </c:forEach>
							</c:otherwise>
						</c:choose> <c:choose>
							<c:when test="${pageInfo.currentBlock eq pageInfo.totalBlocks}">
                &gt;&gt;
                </c:when>
							<c:otherwise>
								<a
									href="stboard.kosta?query=boardList&page=${pageInfo.currentBlock * pageInfo.pagesPerBlock + 1 }">&gt;&gt;</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: right;"><input
						type="button" value="글작성" style="width: 100px; height: 30px;"
						onclick="location='board.kosta?query=boardForm'"></td>
				</tr>
			</table>
		</form>
		</p>
	</section>
</article>
<aside>
	<header>
		<h1>Siderbar Heading</h1>
	</header>
	<p>문서의 주 내용이 아닌 관련성이 낮은 내용들은 aside로 표시할 수 있다. 본문과 직접적으로 상관이 없는 관련
		사이트 링크나 안내글, nav 요소의 그룹 등이 aside 요소로 기술 될 수 있다. 보통 블로그에서 좌우측 사이드바를
		의미하는 것으로서 사이드바의 특성으로 볼때 필수적이지 않아서 표시를 해도 되고 안 해도 되는 내용들 또는 광고물같은 내용들이
		자리할 수 있다.</p>

</aside>
<%@ include file="ex1_bottom.jsp"%>
