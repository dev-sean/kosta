package ex4;

public class ServiceImple implements Service{
	private String msg;
	
	
	
	public ServiceImple() {
		System.out.println("������ ȣ��");
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		System.out.println("DI ȣ��: msg");
		this.msg = msg;
	}

	@Override
	public void init() {
		System.out.println("initȣ��");
		
	}

	@Override
	public void destroy() {
		System.out.println("dstroyȣ��");
		
	}

}
