package dao;

import java.util.List;

import vo.TBboardVO;

public interface TvoService {
	public void add(TBboardVO tvo);
	public List<TBboardVO> getList();
}
