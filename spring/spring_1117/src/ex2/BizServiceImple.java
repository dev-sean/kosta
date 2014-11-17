package ex2;

public class BizServiceImple implements BizService{

	
	@Override
	public void bizMethod1() {
		System.out.println("비지니스 로직 수행1");
	}

	@Override
	public void testbizMethod2() {
		System.out.println("비지니스 로직 수행2");
	}

	@Override
	public void securityMethod() {
		System.out.println("");
	}

}
