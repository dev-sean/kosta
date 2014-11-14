package ex2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeanAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] id, Object target)
			throws Throwable {
		System.out.println("Log : ----------------------");
		System.out.println("메서드의 이름 : "+method.getName());
		System.out.println("Target의 주소 : "+target.getClass().getName());
		String idv = (String) id[0];
		System.out.println("ID : "+idv);
		System.out.println("End : ----------------------");
	}

}
