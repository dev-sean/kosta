package ex1;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;



public class MessageMain {
	public static void main(String[] args) {
		//AOP ProxyFactoryBean을 생성
		ProxyFactoryBean pfbean = new ProxyFactoryBean();
		//Target
		MessageImple target = new MessageImple();
		pfbean.setTarget(target);
		
		//메서드의 이름을 찾아서 제공한다.
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedName("pri*");
		
		 
		//Advice
		MessageAdvice advice = new MessageAdvice();
		//pfbean.addAdvice(advice);
		
		pfbean.addAdvisor(new DefaultPointcutAdvisor(pointcut, advice));
		
		//Advice적용
		Message prMessage = (Message) pfbean.getObject();
		prMessage.print();
		System.out.println("=================");
		String msg = prMessage.message();
		System.out.println("=================");
		target.print();
	}
}
