package ex1;

public class Ex1_MessageApp {
	private String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}//setter�� Property�̴�.
	//�������� �ܺ�������, �ܺ� ���Ա�, ��ü���� �����ִ� �������Ѵ�.
	//������ �����̳ʴ� �̱��� �������͸��� �ִ�. - ��� ��ü�� �̱��� �������͸��� ����Ѵ�.
	// �׷��� �̱������� �������ش�.
	
	public String printMsg(){
		StringBuffer sb = new StringBuffer();
		sb.append("����� �Է��� �޽�����").append(msg).append(" �Դϴ�.");
		return sb.toString();
	}
	
	//�� ��ü�� �������� ���ؼ� �������谡 ������ �� �ֵ��� �缳���ؼ� DI�� ���ؼ� �����޾ƾ� �Ѵ�.
}
