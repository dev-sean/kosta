package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

// ���� �����Ͻ� ������ �����ؾ� �ϰ�, �ݵ�� ��Ʈ������ ���� ��û�� ���� �� ���� �Ǿ�� �ϱ�
// ������ ��Ʈ�������� �޴��� ������  �������̽��� �����ؾ��Ѵ�.
public class IndexModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		System.out.println("IndexModel�� ����Ǿ���");
		System.out.println("������ ���̽� ���� �۾��� ���⼭ ��!");
		return new ActionForward("index.jsp", false);
	}
}




