package ex2;

public class Resource {
	@javax.annotation.Resource(name="test1") //������ ������ �ƴ�
	private String msg;
	public String printMsg(){
		return "��"+msg;
	}
}
