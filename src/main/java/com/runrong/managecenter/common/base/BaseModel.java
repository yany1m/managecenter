package com.runrong.managecenter.common.base;

/**
 * 分页
 * @author yanyimin
 *
 */
public class BaseModel {
	//分页大小
	protected int pageSize;
	//页码
	protected int pageNum;
	//开始
	protected int start;
	
	public int getStart() {
		return start;
	}
	public void setStart(int pageSize,int pageNum) {
		this.start = pageSize*(pageNum-1);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
