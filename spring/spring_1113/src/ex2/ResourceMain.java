package ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ex1.AutoWiredService;

public class ResourceMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("ex2/ex2.xml");
		Resource res= ctx.getBean("auto", Resource.class);
		System.out.println(res.printMsg());
	}
}
