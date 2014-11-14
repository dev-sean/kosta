package ex4;

public class ServiceImple implements Service{
	private String msg;
	
	
	
	public ServiceImple() {
		System.out.println("생성자 호출");
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		System.out.println("DI 호출: msg");
		this.msg = msg;
	}

	@Override
	public void init() {
		System.out.println("init호출");
		
	}

	@Override
	public void destroy() {
		System.out.println("dstroy호출");
		
	}

}
