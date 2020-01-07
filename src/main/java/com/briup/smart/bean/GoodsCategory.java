package com.briup.smart.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="商品类别信息")
public class GoodsCategory {
	@ApiModelProperty(value="商品类别编号")
	 private Long id;
	@ApiModelProperty(value="商品类别名称")
	 private String name;
	@ApiModelProperty(value="商品所属分区",allowableValues="food,shopping")
	 private String region;//区分商品所属(超市|餐饮)

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "GoodsCategory [id=" + id + ", name=" + name + ", region=" + region + "]";
	}

	
    
}