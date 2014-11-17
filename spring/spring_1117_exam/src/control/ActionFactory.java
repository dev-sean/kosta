package control;

import action.Action;
import action.AddModel;
import action.DetailModel;
import action.IndexModel;
import action.ListModel;

public class ActionFactory {
	private static ActionFactory factory;

	public static synchronized ActionFactory getFactory() {
		if (factory == null)
			factory = new ActionFactory();
		return factory;
	}

	public Action makeAction(String query) {
		Action action = null;

		if (query.equals("playform")) {
			action = new IndexModel();
		} else if (query.equals("playList")) {
			action = new ListModel();
		} else if (query.equals("playadd")) {
			action = new AddModel();
			action = new ListModel();
		} else if(query.equals("playDetail")){
			action = new DetailModel();
		}
		return action;
	}
}
