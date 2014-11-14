package ex3;

import org.aspectj.lang.ProceedingJoinPoint;
//ProceedingJoinPoint �� Around Advice�� �ʼ� ���� ���ڰ��̴�.
//Ÿ�� ��ü�� �޼��� ȣ���� �˰� �־�� ��,�� ó���� ���� �� �ִ�.
public class TimeAdvice {
	public void checkTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		pjp.proceed(); //Ÿ�� ��ü�� �޼ҵ� ȣ��
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000+"�и���");
	}
}
