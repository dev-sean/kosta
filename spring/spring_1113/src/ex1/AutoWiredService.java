package ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWiredService {
	//������̼� : ���� ������ �ּ�, ������ 3.0�������� ����
	//���� ������ ����ȭ �� �� �ִ�.
	//�ڵ����� ���� ���� �ִ� ������̼��̴�.
	//�̸����� ���� ã�� ���� ���� Ÿ������ ã���ش�.
	//Ÿ���� ���� ��� ���� �˻��ϱ� ������ �ӵ��� ������ �� �ִ�.
	//��) �̸��̵� Ÿ���̵� �����ؾ� �ǰ� Ÿ���� ��� Qualifier������̼����� �����ؾ� �Ѵ�.
	@Autowired //������ ����, AOP�����̴�
	//@Autowired(required=false) null���� �ֱ� ���ؼ� ���
	@Qualifier("hold")
	private String name;
	//setter�� ������� �ʰ� �ڵ����� name�� ã�Ƽ� ���� �־��ش�.
	public String printName(){
		StringBuffer s = new StringBuffer();
		return s.append("����� �̸���").append(name).append("�Դϴ�.").toString();
	}
}
