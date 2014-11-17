package ex3;

import java.util.List;

public interface Service {
	public void add(PlayMeVO vo);
	public List<PlayMeVO> getList();
	public PlayMeVO getView(int num);
}
