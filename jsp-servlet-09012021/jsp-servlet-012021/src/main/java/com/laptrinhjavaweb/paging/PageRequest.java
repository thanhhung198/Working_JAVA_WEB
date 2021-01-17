package com.laptrinhjavaweb.paging;

public class PageRequest implements Pageable{

	private Integer page;
	private Integer limit;
	
	public PageRequest(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;
	}
	
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.limit;
	}
	
	@Override
	public Integer getOffset() {
		return (this.page - 1 ) * this.limit;
	}

}