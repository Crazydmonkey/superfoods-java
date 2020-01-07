package com.briup.smart.bean;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCar {
	//map集合保存购物车信息  保存 商品id  商品类对象
	public Map<Long,OrderItem> items=new HashMap<>();
	
	//添加商品
	public void addOrder(Goods goods,int nums) {
		//查询商品id
		Long goodsId=goods.getId();
		OrderItem orderItem=items.get(goodsId);//检查是否在集合（购物车）中
	
		//orderItem!=null   购物车中存在该商品
		if (orderItem!=null) {
			orderItem.setQuantity(orderItem.getQuantity()+nums);//加上新增数量
			return;
		}
		//购物车中不存在该商品 创建对象
		orderItem=new OrderItem();
		//产生订单项
		orderItem.setGoodsId(goodsId);//商品id
		orderItem.setQuantity(nums);//数量
	}
	
	
	//修改购买数量
	public void updateItem(Long goodsId,int nums) {
		OrderItem orderItem=items.get(goodsId);//根据id，得到集合中保存的该项商品
		if (orderItem!=null) {
			orderItem.setQuantity(nums);
		}
	}
	
	
	//删除商品
	public void removeItem(Long goodsId) {
		items.remove(goodsId);
	}
	
	
	//删除全部商品
	

}
