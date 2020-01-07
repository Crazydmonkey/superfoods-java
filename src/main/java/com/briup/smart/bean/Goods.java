package com.briup.smart.bean;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="商品信息")
public class Goods {
	@ApiModelProperty(value="编号")
    private Long id;
	@ApiModelProperty(value="名称",required = true)
    private String name;
	@ApiModelProperty(value="图片",hidden = true)
    private String picture;
	@ApiModelProperty(value="价格",required = true)
    private Double price;
	@ApiModelProperty(value="数量")
    private Integer quantity;
	@ApiModelProperty(value="描述")
    private String description;
	@ApiModelProperty(value="类别编号",required = true)
    private Long categoryId;
	@ApiModelProperty(value="收藏数量",hidden = true)
	private Integer collectionNumber;
	@ApiModelProperty(value="进价",required = true)
    private Double cost;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(Integer collectionNumber) {
		this.collectionNumber = collectionNumber;
	}
	
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", picture=" + picture + ", price=" + price + ", quantity="
				+ quantity + ", description=" + description + ", categoryId=" + categoryId + ", collectionNumber="
				+ collectionNumber + ", cost=" + cost + "]";
	}

	
	
	


	

    
}