package ex1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//AOPAlliance에서 제공받은 interceptor를 사용
//Around Advice
public class MessageAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("ㅁㅁㅁㅁㅁㅁ");// 선행 공통 관심 사항
		Object rev = arg0.proceed(); // target Method, arround 메서드일 때만 필요하다.

		if (rev != null) {
			System.out.println(rev);
		}
		System.out.println("ㄱㄱㄱㄱㄱㄱㄱ");// 후행 공통 관심 사항
		return rev;
	}

}
