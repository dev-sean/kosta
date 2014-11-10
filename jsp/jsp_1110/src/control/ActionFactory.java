package control;

import action.Action;
import action.BoardAdd;
import action.BoardForm;
import action.BoardList;
import action.IndexModel;
import action.BoardListModel;


// Servlet이 직접적으로 접근하는 클래스 *****
public class ActionFactory {
	private static ActionFactory factory;

	public static synchronized ActionFactory getFactory() {
		if(factory == null) factory = new ActionFactory();
		return factory;
	}
	// 컨트럴ㄹㅓ와 모델사이에서 중간 관리 역할을 하는 객체  - C에게서 부터 요청을 받아서 
	// 해당 모델을 수행할 주소값을 다시 C에게 전달해서  C가 주문한 값(ActionForward)을 
	// 돌려 받도록 관리하는 역할을 한다.
	// -- 다형성/ 객체간의 결합도를 낮추기위한 객체의 공장과 같은 ObjectFactory 
	// 요청을 처리하고 핸들링하는 개념도 중요함.
	public Action makeAction(String query){
		Action action = null;
		if(query.equals("index")){
			action = new IndexModel();
		}else if(query.equals("boardForm")){
			action = new BoardForm();
		}else if(query.equals("boardList")){
			action = new BoardListModel();
		}else if(query.equals("boardAdd")){
			action = new BoardAdd();
		}
		return action;
	}
	
}
