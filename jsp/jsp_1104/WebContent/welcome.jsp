<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="ex1_top.jsp"%>
<article>
	<p>���� IT���� ���� �����޴� java Technology�� ���ʺ��� ��ޱ������ �н��մϴ� ��������
		�����ӿ�ũ(java opensource framework)�� �̿��� Enterprise Solution ���� �� ������
		�ȵ���̵� �� ���̺긮����� �̿��� ����� ���ø����̼� ������ �н��ϰ� �ǹ� ������Ʈ�� ���� �������� �ʿ�� �ϴ� �ڹ�
		�����Ͼ� �缺�� ��ǥ�� �մϴ�.</p>
	<section>
		<header style="margin: auto; width: 100%;">
			<h2>Welcome</h2>
		</header>
		<p>
		<%=request.getParameter("welcomeID") %>
			������ ȯ���մϴ�.<br/>
			���ʰ��Խ� ���ϸ����� Ȯ�� �ϱ� ���ؼ��� 3�ʾȿ� �α����ϼ���<br/>
			<a href="loginForm.jsp">�α���</a>
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
<%@include file="ex1_bottom.jsp"%>