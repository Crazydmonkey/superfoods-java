package com.briup.smart.bean;

import java.math.BigDecimal;

public class Search {
    private Long id;

    private String keyword;

    private Long customerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Search [id=" + id + ", keyword=" + keyword + ", customerId=" + customerId + "]";
	}

    
}