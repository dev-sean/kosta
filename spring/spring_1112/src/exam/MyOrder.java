package exam;

public class MyOrder implements MenuInter{

	@Override
	public String order(OrderVO vo) {
		StringBuffer s = new StringBuffer();
		s.append(vo.getName()).append(" �� �����մϴ�.<br/>");
		s.append("<li>�ֹ��Ͻ� ��ǰ�� ").append(vo.getOrdName()).append(" �Դϴ�.");
		s.append("<li>�ֹ��Ͻ� ��ǰ�� ������ ").append(vo.getQuant()).append("�� �Դϴ�.");
		s.append("<li>�ֹ��Ͻ� ��ǰ �� ������ ").append(Integer.parseInt(vo.getQuant())*Integer.parseInt(vo.getPrice())).append("�� �Դϴ�.");
		return s.toString();
	}

}
