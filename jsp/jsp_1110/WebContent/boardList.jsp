<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="ex1_top.jsp"%>
<article>
	<p>���� IT���� ���� �����޴� java Technology�� ���ʺ��� ��ޱ������ �н��մϴ� ��������
		�����ӿ�ũ(java opensource framework)�� �̿��� Enterprise Solution ���� �� ������
		�ȵ���̵� �� ���̺긮����� �̿��� ����� ���ø����̼� ������ �н��ϰ� �ǹ� ������Ʈ�� ���� �������� �ʿ�� �ϴ� �ڹ�
		�����Ͼ� �缺�� ��ǥ�� �մϴ�.</p>
	<section>
		<header style="margin: auto; width: 100%;">
			<h2>BoardList Page</h2>
		</header>
		<p>
		<form method="post" action="loginok.jsp">
			<table
				style="margin: auto; width: 550px; border: 1px solid black; border-collapse: collapse;">
				<tr style="background-color: #a0a0a0">
					<td>��ȣ</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>�׷��ȣ</td>
					<td>��ȸ��</td>
					<td>�����</td>
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
						type="button" value="���ۼ�" style="width: 100px; height: 30px;"
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
	<p>������ �� ������ �ƴ� ���ü��� ���� ������� aside�� ǥ���� �� �ִ�. ������ ���������� ����� ���� ����
		����Ʈ ��ũ�� �ȳ���, nav ����� �׷� ���� aside ��ҷ� ��� �� �� �ִ�. ���� ��α׿��� �¿��� ���̵�ٸ�
		�ǹ��ϴ� �����μ� ���̵���� Ư������ ���� �ʼ������� �ʾƼ� ǥ�ø� �ص� �ǰ� �� �ص� �Ǵ� ����� �Ǵ� �������� �������
		�ڸ��� �� �ִ�.</p>

</aside>
<%@ include file="ex1_bottom.jsp"%>
