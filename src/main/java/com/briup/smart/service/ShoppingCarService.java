package com.briup.smart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Goods;
import com.briup.smart.bean.OrderItem;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.OrderItemMapper2;
import com.briup.smart.web.vm.FieldError;
import com.briup.smart.web.vm.OrderItemVM;

@Service
public class ShoppingCarService {
	@Autowired
	private OrderItemMapper2 orderItemMapper;
	@Autowired
	private FindGoodsService findGoodsService;

	// 添加商品到购物车 商品编号 顾客id 数量 金额
	@Transactional
	public int setOrderItem(Long goodsId, Long customerId) {
		Collection<FieldError> fs = new HashSet<>();
		// 检测商品库存
		System.out.println("检测商品库存");

		Goods goods = findGoodsService.selectGoodsById(goodsId);
		System.out.println("商品信息" + goods);
		int count = goods.getQuantity();// 库存

		if (count <= 1) {
			fs.add(new FieldError("count", "商品库存为0！"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		System.out.println("添加商品到购物车:" + goodsId);
		// 查看购物车中是否有该商品
		OrderItem item = orderItemMapper.selectOrderItem(goodsId, customerId);
		System.out.println("购物车中商品信息：" + item);
		if (item != null) {
			int num = item.getQuantity() + 1;// 数量
			if (count - num <= 1) {
				fs.add(new FieldError("count", "商品已售罄！"));
			}
			if (!fs.isEmpty()) {
				throw new DataValidFailedException(fs);
			}
			item.setQuantity(num);
			item.setAmount(item.getQuantity() * goods.getPrice());// 添加单项商品总价
			int b = orderItemMapper.updateByPrimaryKey(item);
			return b;
		} else {
			item = new OrderItem();
			item.setQuantity(1);// 数量
		}
		// 查询商品

		Double price = goods.getPrice();
		item.setAmount(price);// 添加单项商品总价
		item.setCustomerId(customerId);// 顾客id
		item.setGoodsId(goodsId);// 商品id
		int b = orderItemMapper.insertShopingCar(item);
		System.out.println("添加至购物车" + b);
		return b;
	}

	// 修改购物车数量
	@Transactional
	public int updateOrderItem(Long id, int num) {
		Collection<FieldError> fs = new HashSet<>();
		OrderItem item = orderItemMapper.selectByPrimaryKey(id);
		// 检测商品库存
		Goods goods = findGoodsService.selectGoodsById(item.getGoodsId());
		System.out.println("商品库存：" + goods);
		int count = goods.getQuantity();
		if (count <= 1) {
			fs.add(new FieldError("count", "商品库存为0！"));
		}
		if (count <= num) {
			fs.add(new FieldError("count", "商品库存量不足！"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		System.out.println("修改购物车数量:" + num);

		// 修改购物车中该商品信息
		item.setQuantity(num);
		item.setAmount(item.getQuantity() * goods.getPrice());// 添加单项商品总价
		int b = orderItemMapper.updateByPrimaryKey(item);
		System.out.println("修改购物车 " + b + " 个商品数量");
		return b;
	}

	// 减少购物车中商品的数量
	@Transactional
	public int reductOrderItem(Long id) {
		Collection<FieldError> fs = new HashSet<>();
		OrderItem item = orderItemMapper.selectByPrimaryKey(id);
		Goods goods = findGoodsService.selectGoodsById(item.getGoodsId());
		System.out.println("减少购物车中商品的数量:" + item);
		// 修改购物车中该商品
		int num = item.getQuantity() - 1;
		if (num < 1) {
			throw new RuntimeException("购物车中商品数量不能减到0");
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		item.setQuantity(num);// 保存新数量
		item.setAmount(item.getQuantity() * goods.getPrice());// 添加单项商品总价
		int b = orderItemMapper.updateByPrimaryKey(item);
		System.out.println("减少购物车中：" + b + "种商品的数量");
		return b;
	}

	// 删除购物车商品
	@Transactional
	public int deleteOrderItem(Long id) {
		// System.out.println("删除购物车商品:"+id);
		int a = orderItemMapper.deleteByPrimaryKey(id);
		// System.out.println("成功删除购物车中："+a+" 种商品");
		return a;
	}

	// 清空购物车
	@Transactional
	public int deleteAllOrderItem(Long customerId) {
		// 检测商品库存
		System.out.println("清空购物车:" + customerId);
		int a = orderItemMapper.deleteAll(customerId);
		// 查询购物车全部订单项
		List<OrderItem> list = orderItemMapper.selectAllShoppingCar(customerId);
		System.out.println("清空购物车后结果：" + list);
		System.out.println("成功删除购物车中：" + a + " 种商品");
		return a;
	}

	// 查询购物车全部订单项
	@Transactional
	public List<OrderItem> getAllOrderItem(Long customerId) {
		Collection<FieldError> fs = new HashSet<>();
		System.out.println("查询购物车全部订单项:" + customerId);

		List<OrderItem> list = orderItemMapper.selectAllShoppingCar(customerId);
		if (list == null) {
			list = new ArrayList<OrderItem>();
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		System.out.println("查询购物车全部订单项  成功:" + list);
		return list;
	}

	// 查询购物车全部订单项及商品信息
	@Transactional
	public List<OrderItemVM> getOrderItemsWithGoods(Long customerId) {
		System.out.println("查询购物车全部订单项及商品信息:" + customerId);
		List<OrderItemVM> orderItems = new ArrayList<>();
		
		List<OrderItem> list = orderItemMapper.selectAllShoppingCar(customerId);
		if (list != null) {
			OrderItemVM orderItem;
			Goods goods;
			for(int i = 0; i < list.size(); i++) {
				orderItem = convertOrderItemToOrderItemVM(list.get(i));
				goods = findGoodsService.selectGoodsById(orderItem.getGoodsId());
				orderItem.setGoodsName(goods.getName());
				orderItem.setGoodsPicture(goods.getPicture());
				orderItem.setGoodsDescription(goods.getDescription());
				orderItems.add(orderItem);
			}
		}
		System.out.println("查询购物车全部订单项及商品信息  成功:" + list);
		return orderItems;
	}

	private OrderItemVM convertOrderItemToOrderItemVM(OrderItem orderItem) {
		OrderItemVM orderItemVm = new OrderItemVM();
		orderItemVm.setAmount(orderItem.getAmount());
		orderItemVm.setCustomerId(orderItem.getCustomerId());
		orderItemVm.setGoodsId(orderItem.getGoodsId());
		orderItemVm.setId(orderItem.getId());
		orderItemVm.setOrderId(orderItem.getOrderId());
		orderItemVm.setQuantity(orderItem.getQuantity());
		return orderItemVm;
	}
}
