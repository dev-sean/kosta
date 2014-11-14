package ex3;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	//JointPoint - Around를 제외한 나머지 Advice타입, 생략 가능!
	public void afterReturnMethod(JoinPoint jp, Object ret){
		String name = jp.getSignature().getName();
		
		System.out.println("반환값 : "+ret+"/name :"+name);
	}
}
