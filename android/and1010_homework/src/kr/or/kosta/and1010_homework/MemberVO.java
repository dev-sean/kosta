package kr.or.kosta.and1010_homework;

import java.io.Serializable;


public class MemberVO implements Serializable{
	//Serializable을 사용함으로써 MemberVO 객체가 직렬화가 가능한 객체로 만들어준다.
	private String id, name, age, location, tel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
