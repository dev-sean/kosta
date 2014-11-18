package transaction;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


//AroundAdvice�� ������ ���� : ����ó���� �̻��� ����� rollback�� ����ó���� ��� commit�� �ϱ����ؼ� ����
public class TransactionAdvice implements MethodInterceptor {

	// Ʈ�������� �ٽ��� commit, rollback�� ������ �ִ� �Ŵ��� ��ü
	private PlatformTransactionManager trManager;

	public void setTrManager(PlatformTransactionManager trManager) {
		this.trManager = trManager;
		System.out.println("Ʈ����� ���� �Ϸ�!!");
	}

	// ���ͼ��Ͱ������� ��û�� ���� ������ �޴µ�, ProxyFactoryBean�� ���ؼ�
	// MethodInvocation, �� �޼��� ȣ�� ����(Ÿ�� ��ü�� �޼��� ����)�� �޾Ƽ� ���Թ޴´�.
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// Transaction�� ���� �������� ������ ��ü�� ���� - Ʈ������� �䱸 �Ǵ� ���°��̱� ������
		DefaultTransactionDefinition td = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = trManager.getTransaction(td);
		//commit or rollback
		try {
			Object ret = mi.proceed();
			trManager.commit(status);
			System.out.println("Commit : "+mi.getMethod().getName());
			System.out.println("Status : "+status);
			return ret;
		} catch (Exception e) {
			trManager.rollback(status);
			System.out.println("Rollback :");
			System.out.println("Status :"+status);
			throw e;
		}
	}

}
