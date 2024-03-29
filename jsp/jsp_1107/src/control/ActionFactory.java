package control;

import action.Action;
import action.IndexModel;
import action.ValueModel;

//Servlet이 직접적으로 접근하는 클래스 ******
//(쓰레드가 접근한다.)

public class ActionFactory {
	private static ActionFactory factory;
	
	public static synchronized ActionFactory getFactory() {
		if(factory == null) factory = new ActionFactory();
		return factory;
	}
	//컨트롤러와 모델사이에서 중간 관리 역할을 하는 객체 - 컨트롤러에게서부터 요청을 받아서
	//해당 모델을 수행한 주소값을 다시 컨트롤러에게 전달해서 컨트롤러가 주문한 값(ActionForward)를
	//돌려 받도록 관리하는 역할을 한다.
	//--다형성 / 객체간의 결합도를 낮추기 위한 객체의 공장과 같은 ObjectFactory가 있구요
	//요청을 처리하고 핸들링하는 개념도 중요
	public Action makeAction(String query){
		Action action = null;
		if(query.equals("index")){
			action = new IndexModel();
		}else if(query.equals("v1")){
			action = new ValueModel();
		}else if(query.equals("date")){
			action =new ValueModel();
		}
		return action;
	}
	
}
