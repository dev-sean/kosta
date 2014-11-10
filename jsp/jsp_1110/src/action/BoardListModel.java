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
		// ������ ������ ���� ��ü�� ����
		PageVO pageInfo = new PageVO();
		// ���������� ������ ���� ��
		int rowsPerPage = 5;
		// ���������� ������ ������ ��� ��
		int pagesPerBlock = 5;
		// ������ ��
		int currentPage = Integer.parseInt(req.getParameter("page"));
		int currentBlock = 0;
		// ������ ���� ���� ������ ����� ����
		if (currentPage % pagesPerBlock == 0) {
			currentBlock = currentPage / pagesPerBlock;
		} else {
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		// ���� ������ ���� ���� startRow (SQL������ between�� �� �� ��)
		// 1������ �ϴ�� 1����, 2������ �϶��� 6����
		int startRow = (currentPage - 1) * rowsPerPage + 1;
		// 1*5 = 5 ����, 2*5 = 10 ����
		int endRow = currentPage * rowsPerPage;
		// ��ü ������ �� ���
		int totalRows = BoardDao.getDao().getTotalCount();
		int totalPages = 0;
		// ��ü ������ ��
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��ϰ� ���ϱ�
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
		//forward�� ������ ���ؼ� request�� ���
		req.setAttribute("pageInfo", pageInfo);
		
		//������ ����� ������ ó���� ������ ������ ���� MAP�� ����!
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", startRow);
		map.put("end", endRow);
		List<BoardVO> list = BoardDao.getDao().getList(map);
		req.setAttribute("list", list);

		return new ActionForward("boardList.jsp", false);
	}

}
