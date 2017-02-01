package com.lbms.domain;

import java.util.List;

public class Page {
	private int currentPage;
	private int pageSize; // 每页显示的记录数

	// 查询数据
	private int recordCount; // 总记录数
	private List recordList; // 本页的数据

	// 计算出来
	private int pageCount; // 总页数目
	private int beginPageIndex; // 页面列表的开始索引
	private int endPageIndex; // 页面列表的结束索引

	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param recordCount
	 * @param recordList
	 */
	public Page(int currentPage, int pageSize, int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;

		// 计算pageCount
		pageCount = (recordCount + pageSize - 1) / pageSize;

		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}

		else {

			beginPageIndex = currentPage - 4; // 7 - 4 = 3
			endPageIndex = currentPage + 5; // 7 + 5 = 12

			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			} else if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 10 + 1;
			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}
