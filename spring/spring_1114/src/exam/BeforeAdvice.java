package exam;

import org.springframework.beans.factory.annotation.Autowired;

public class BeforeAdvice{
	@Autowired
	private LoginTest ref;
	
	public void checkLogin(){
		if(!ref.isRes()){
			System.out.println("��й�ȣ ����");
			System.exit(0);
		}else{
			System.out.println("�����Ϸ�");
		}
	}
}
