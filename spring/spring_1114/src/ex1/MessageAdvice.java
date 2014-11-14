package ex1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//AOPAlliance���� �������� interceptor�� ���
//Around Advice
public class MessageAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("������������");// ���� ���� ���� ����
		Object rev = arg0.proceed(); // target Method, arround �޼����� ���� �ʿ��ϴ�.

		if (rev != null) {
			System.out.println(rev);
		}
		System.out.println("��������������");// ���� ���� ���� ����
		return rev;
	}

}
