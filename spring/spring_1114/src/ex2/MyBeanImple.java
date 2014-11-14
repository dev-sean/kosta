package ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanImple implements MyBean{
	@Autowired
	private String msg;
	
	@Override
	public String myGetMessage(String name) {
		String res = name+" : "+ msg;
		return res;
	}

}
