package ex3;

import org.aspectj.lang.ProceedingJoinPoint;
//ProceedingJoinPoint 는 Around Advice에 필수 적인 인자값이다.
//타겟 객체의 메서드 호출을 알고 있어야 전,후 처리로 감쌀 수 있다.
public class TimeAdvice {
	public void checkTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		pjp.proceed(); //타겟 객체의 메소드 호출
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000+"밀리초");
	}
}
