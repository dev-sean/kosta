package ex3;

import org.springframework.beans.factory.annotation.Autowired;

public class Required {
	private String name, msg;

	public void print() {
		System.out.println("Name : " + name);
		System.out.println("Msg : " + msg);
	}

	@Autowired
	public Required(String name, String msg) {

		this.name = name;
		this.msg = msg;
	}

	// @Required : �ʼ� Property�� �˻����ִ� ������̼�, setter�� �̿��ؼ� ���� �������� �ȵ�� ������ Ȯ���Ѵ�.
	// @org.springframework.beans.factory.annotation.Required
	public void setName(String name) {
		this.name = name;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
