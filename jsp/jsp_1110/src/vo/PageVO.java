package vo;

import java.io.Serializable;

public class PageVO implements Serializable{

	private int currentPage;	//현재 페이지번호
	private int currentBlock;	//현재 블록번호
	private int rowsPerPage;	//한 페이지당 보여줄 목록 수
	private int pagesPerBlock;	//한 블록당 보여줄 페이지 수
	private int totalRows;		//전체 목록 수
	private int totalPages;		//전체 페이지 수
	private int totalBlocks;	//전체 블록 수
	private int startRow;		//시작 목록 번호
	private int endRow;			//마지막 목록번호
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentBlock() {
		return currentBlock;
	}
	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

    public int getPagesPerBlock() {
        return pagesPerBlock;
    }

    public void setPagesPerBlock(int pagesPerBlock) {
        this.pagesPerBlock = pagesPerBlock;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalBlocks() {
		return totalBlocks;
	}
	public void setTotalBlocks(int totalBlocks) {
		this.totalBlocks = totalBlocks;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
	
}
