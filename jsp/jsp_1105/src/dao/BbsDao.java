package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import servie.FactoryService;
import vo.BbsVO;

public class BbsDao {
	private static BbsDao dao;

	public synchronized static BbsDao getDao() {
		if(dao == null){
			dao = new BbsDao();
		}
		return dao;
	}
	
	public void setBbs(BbsVO v){
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.insert("bbs.memberAdd",v);
		ss.commit();
		ss.close();
	}
	
	public List<BbsVO> getList(){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BbsVO> list = ss.selectList("bbs.memberList");
		ss.close();
		return list;
	}
	
	public BbsVO getDetail(int num){
		SqlSession ss = FactoryService.getFactory().openSession();
		BbsVO vo = ss.selectOne("bbs.getDetail", num);
		ss.update("bbs.getHit",num);
		ss.commit();
		ss.close();
		return vo;
	}
	
	public void deleteTable(int num){
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.delete("bbs.deleteTable",num);
		ss.commit();
		ss.close();
	}
	
	public void updateForm(HashMap<String, String> map){
		
	}
}
