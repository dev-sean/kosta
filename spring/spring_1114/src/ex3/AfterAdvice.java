package ex3;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	//JointPoint - Around�� ������ ������ AdviceŸ��, ���� ����!
	public void afterReturnMethod(JoinPoint jp, Object ret){
		String name = jp.getSignature().getName();
		
		System.out.println("��ȯ�� : "+ret+"/name :"+name);
	}
}
