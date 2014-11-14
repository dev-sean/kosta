package ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ex2.Resource;

public class RequiredMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("ex3/ex3.xml");
		Required res= ctx.getBean("req", Required.class);
		res.print();
	}
}
