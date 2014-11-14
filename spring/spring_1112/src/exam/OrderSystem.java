package exam;

public class OrderSystem {

	private MenuInter menu;

	public MenuInter getMenu() {
		return menu;
	}

	public void setMenu(MenuInter menu) {
		this.menu = menu;
	}

	public String printMenu(OrderVO vo){
		
		return menu.order(vo);
	}
}
