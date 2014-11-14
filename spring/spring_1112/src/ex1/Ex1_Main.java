package ex1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("ex1/context.xml");
		Ex1_Singleton si = ctx.getBean("add", Ex1_Singleton.class);
		Ex1_Singleton si2 = ctx.getBean("add", Ex1_Singleton.class);
		String s1 = si.getAddress();
		String s2 = si2.getAddress();
		if(si==si2){
			System.out.println("같네?");
		}else{
			System.out.println("다르네?");
		}
	}
}


