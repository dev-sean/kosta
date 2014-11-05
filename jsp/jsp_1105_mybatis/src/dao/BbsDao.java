package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.FactoryService;
import vo.BbsVO;

public class BbsDao {
	private static BbsDao dao;

	/**
	 * @return the dao
	 */
	public static synchronized BbsDao getDao() {
		if (dao == null)
			dao = new BbsDao();
		return dao;
	}

	// insert 작업을 정의 한 메서드
	public void bbsAdd(BbsVO v) {
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("bbs.bbs_in", v);
		ss.commit();
		ss.close();
	}
	// selectList - select된 내용을 VO에 담아서 List로 반환해 주는 메서드
	public List<BbsVO> getList() {
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BbsVO> list = ss.selectList("bbs.bbs_list");
		ss.close();
		return list;
	}

}
