<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="ex1_top.jsp" %>
 <article>		 	
 <p>���� IT���� ���� �����޴� java Technology�� ���ʺ��� ��ޱ������ �н��մϴ�
�������� �����ӿ�ũ(java opensource framework)�� �̿��� Enterprise Solution ���� �� ������ 
�ȵ���̵� �� ���̺긮����� �̿��� ����� ���ø����̼� ������ �н��ϰ� �ǹ� ������Ʈ�� ���� �������� �ʿ�� �ϴ� 
�ڹ� �����Ͼ� �缺�� ��ǥ�� �մϴ�.	
		 	</p>
		 	<section>
		 	<header style="margin: auto; width: 100%;"><h2>BoardForm Page</h2></header>
		 	<p >
		 		<form method="post" action="board.kosta">
		 		<input type="hidden" name="query" value="boardAdd">
		 		<table style="margin: auto; width: 400px">
		 			<tr>
		 				<td>����</td>
		 				<td><input type="text" name="title">
		 				</td>
		 			</tr> 
		 			<tr>
		 				<td>�ۼ���</td>
		 				<td><input type="text" name="writer" id="writer"></td>
		 			</tr>
		 			<tr>
		 				<td>groupno</td>
		 				<td><input type="number" name="groupno"></td>
		 			</tr>
		 			<tr>
		 				<td>����</td>
		 				<td>
		 				<textarea rows="10" cols="52" name="content"></textarea>
		 				</td>
		 			</tr>
		 			<tr><td colspan="2" style="text-align: right;">
		 				<input type="submit" value="���ۼ�"
		 					style="width: 100px; height: 30px;"
		 				>&nbsp;
		 				<input type="button" value="����Ʈ"
		 					style="width: 100px; height: 30px;"
		 					onclick="location='board.kosta?query=boardList&page=1'"
		 				>
		 			</td></tr>
		 		</table>
		 		</form>
		 	</p>
		 	</section>
		 </article>	
		  <aside>
        <header>
            <h1>Siderbar Heading</h1>
        </header>
        <p>������ �� ������ �ƴ� ���ü��� ���� ������� aside�� ǥ���� �� �ִ�.
		������ ���������� ����� ���� ���� ����Ʈ ��ũ�� �ȳ���, nav ����� �׷� ���� aside ��ҷ� ��� �� �� �ִ�.
		���� ��α׿��� �¿��� ���̵�ٸ� �ǹ��ϴ� �����μ� ���̵���� Ư������ ���� �ʼ������� �ʾƼ� ǥ�ø� �ص� �ǰ� �� �ص� �Ǵ� ����� �Ǵ� �������� ������� �ڸ��� �� �ִ�.</p>

    </aside>
    <%@ include file="ex1_bottom.jsp" %>
		 