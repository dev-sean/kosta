package exam;

public class MyOrder implements MenuInter{

	@Override
	public String order(OrderVO vo) {
		StringBuffer s = new StringBuffer();
		s.append(vo.getName()).append(" 님 감사합니다.<br/>");
		s.append("<li>주문하신 제품은 ").append(vo.getOrdName()).append(" 입니다.");
		s.append("<li>주문하신 제품의 갯수는 ").append(vo.getQuant()).append("개 입니다.");
		s.append("<li>주문하신 제품 총 가격은 ").append(Integer.parseInt(vo.getQuant())*Integer.parseInt(vo.getPrice())).append("원 입니다.");
		return s.toString();
	}

}
