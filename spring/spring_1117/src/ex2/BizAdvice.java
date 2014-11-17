package ex2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
//AOP�� �ٽ��� ProxyFactoryBean�� Ÿ������ �����Ѵ�.
@Aspect
public class BizAdvice {
	@Autowired
	private SimpleDateFormat f;
	
	@Autowired
	private Scanner src;
	
	@Resource(name="date")
	private Date d;
	@Before("execution(* ex2.BizService*.*(..))")
	public void beforeMethod(){
		System.out.println("����� �̸���?");
		String n = src.nextLine();
		System.out.println(n);
		System.out.println(f.format(d));
	}
}
