package com.haihangyun.hcpaas.op.core.base.result;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 基础查询条件类
 * 
 * @author wengkai
 * @date 2017-3-2 上午11:38:14
 */
public class BasePageEntity implements Cloneable {
	private int pageIndex = 1;
	private int pageSize = 20;
	private int pageCount = 1;
	private long recordCount = 0;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex != null ? pageIndex : 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public Pageable getPageable(){
		return new PageRequest(this.getPageIndex() - 1 , this.getPageSize());
	}

}
