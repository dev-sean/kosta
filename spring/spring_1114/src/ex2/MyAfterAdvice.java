package ex2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;


public class MyAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("AfterAdvice가 나왔습니다.");
		
	}

}
