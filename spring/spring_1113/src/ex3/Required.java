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

	// @Required : 필수 Property를 검사해주는 어노테이션, setter를 이용해서 값이 들어오는지 안들어 오는지 확인한다.
	// @org.springframework.beans.factory.annotation.Required
	public void setName(String name) {
		this.name = name;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
