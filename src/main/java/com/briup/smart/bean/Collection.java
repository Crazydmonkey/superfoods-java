package com.briup.smart.bean;

import java.math.BigDecimal;

public class Collection {
    private Long id;

    private Long goodsId;

    private Long customerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Collection [id=" + id + ", goodsId=" + goodsId + ", customerId=" + customerId + "]";
	}

    
}