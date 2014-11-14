package ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyBeanMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("ex2/mybean.xml");
		MyBean mbi = ctx.getBean("pfBean", MyBean.class);
		
		System.out.println(mbi.myGetMessage("±è±æµ¿"));
	}
}
