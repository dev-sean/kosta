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
				<h2>Login Page</h2>
			</header>
			<p>
			<form method="post" action="loginok.jsp">
				<table style="margin: auto; width: 300px">
					<tr>
						<td>ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>PWD</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Login"></td>
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
	<%@include file="ex1_bottom.jsp"%>