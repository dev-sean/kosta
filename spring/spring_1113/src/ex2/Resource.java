package ex2;

public class Resource {
	@javax.annotation.Resource(name="test1") //스프링 전용이 아님
	private String msg;
	public String printMsg(){
		return "ㅁ"+msg;
	}
}
