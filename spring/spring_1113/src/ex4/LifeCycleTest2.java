package ex4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleTest2 {
	private String msg;
	
	public LifeCycleTest2() {
		System.out.println("������ ȣ��");
	}
	
	public void setMsg(String msg){
		this.msg=msg;//�̰� �ؾ� ��Ʈ���� ������ ������ ���� ?  ī��ٶ�
		System.out.println("DI ȣ��: msg : "+msg);
	}
	@PostConstruct //�ʱ�ȭ�� �������
	public void init(){
		System.out.println("initȣ��");
	}
	public String getMsg() {
		return msg;
	}

	@PreDestroy //��Ʈ����
	public void destroy(){
		System.out.println("destroyȣ��");
	}

}
