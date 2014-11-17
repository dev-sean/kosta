package control;

public class ActionForward {
	private String url; 
	private boolean method;
	
	public ActionForward(){
		
	}
	public ActionForward(String url, boolean method) {
		super();
		this.url = url;
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isMethod() {
		return method;
	}
	public void setMethod(boolean method) {
		this.method = method;
	}
	
}
