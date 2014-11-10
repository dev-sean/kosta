package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardVO;
import vo.PageVO;
import control.ActionForward;
import dao.BoardDao;

public class BoardListModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// 페이지 설정을 위한 객체를 생성
		PageVO pageInfo = new PageVO();
		// 한페이지에 보여줄 라인 수
		int rowsPerPage = 5;
		// 한페이지에 보여줄 페이지 블록 수
		int pagesPerBlock = 5;
		// 페이지 값
		int currentPage = Integer.parseInt(req.getParameter("page"));
		int currentBlock = 0;
		// 페이지 값에 따라서 페이지 블록을 연산
		if (currentPage % pagesPerBlock == 0) {
			currentBlock = currentPage / pagesPerBlock;
		} else {
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		// 현재 페이지 값에 따른 startRow (SQL문에서 between절 에 들어갈 것)
		// 1페이지 일대는 1부터, 2페이지 일때는 6부터
		int startRow = (currentPage - 1) * rowsPerPage + 1;
		// 1*5 = 5 까지, 2*5 = 10 까지
		int endRow = currentPage * rowsPerPage;
		// 전체 데이터 값 얻기
		int totalRows = BoardDao.getDao().getTotalCount();
		int totalPages = 0;
		// 전체 페이지 값
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// 전체 블록값 구하기
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);
		//forward로 보내기 위해서 request에 등록
		req.setAttribute("pageInfo", pageInfo);
		
		//페이지 연산된 값으로 처음과 마지막 데이터 값을 MAP에 저장!
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", startRow);
		map.put("end", endRow);
		List<BoardVO> list = BoardDao.getDao().getList(map);
		req.setAttribute("list", list);

		return new ActionForward("boardList.jsp", false);
	}

}
