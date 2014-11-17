package ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BizMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("ex2/ex2.xml");
		BizService ba = ctx.getBean("target",BizService.class);
		ba.bizMethod1();
		ba.testbizMethod2();
		ba.securityMethod();
	}
}
