package control;

import action.Action;
import action.BoardAdd;
import action.BoardForm;
import action.BoardList;
import action.IndexModel;
import action.BoardListModel;


// Servlet�� ���������� �����ϴ� Ŭ���� *****
public class ActionFactory {
	private static ActionFactory factory;

	public static synchronized ActionFactory getFactory() {
		if(factory == null) factory = new ActionFactory();
		return factory;
	}
	// ��Ʈ�����ÿ� �𵨻��̿��� �߰� ���� ������ �ϴ� ��ü  - C���Լ� ���� ��û�� �޾Ƽ� 
	// �ش� ���� ������ �ּҰ��� �ٽ� C���� �����ؼ�  C�� �ֹ��� ��(ActionForward)�� 
	// ���� �޵��� �����ϴ� ������ �Ѵ�.
	// -- ������/ ��ü���� ���յ��� ���߱����� ��ü�� ����� ���� ObjectFactory 
	// ��û�� ó���ϰ� �ڵ鸵�ϴ� ���䵵 �߿���.
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
