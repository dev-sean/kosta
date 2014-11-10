package control;
// 모델이 수행 후 처리 결과를 반환 목적으로 설계된 클래스 
public class ActionForward {
	private String url; // 모델이 수행 후 이동할 view의 경로
	private boolean method; // 모델이 수행 후 결정할 이동방식
	
	public ActionForward() {
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
