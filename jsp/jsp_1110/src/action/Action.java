package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;
//�𵨵��� �ݵ�� �����ؾ� �� ���
//��Ʈ������ ���� �޴��� - ������ ���� �������̽��� ����ؼ� �߻�޼��带 ȣ���� ��
// request, response�� ���ڰ����� �־ �����Ѵ�.
public interface Action {
	public ActionForward execute(HttpServletRequest req, 
			HttpServletResponse resp) throws IOException;
}
