package com.briup.smart.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Goods;
import com.briup.smart.bean.GoodsCategory;
import com.briup.smart.bean.Option;
import com.briup.smart.bean.OrderData;
import com.briup.smart.bean.OrderDetail;
import com.briup.smart.bean.OrderInfo;
import com.briup.smart.bean.OrderItem;
import com.briup.smart.bean.UserOrder;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.CustomerMapper;
import com.briup.smart.mapper.DeliverymanMapper;
import com.briup.smart.mapper.GoodsCategoryMapper;
import com.briup.smart.mapper.GoodsMapper;
import com.briup.smart.mapper.OrderItemMapper2;
import com.briup.smart.mapper.UserOrderMapper2;
import com.briup.smart.web.vm.FieldError;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.util.concurrent.ExecutionError;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class UserOrderServiceImpl2 {

	@Autowired
	private UserOrderMapper2 userOrderMapper;
	@Autowired
	private OrderItemMapper2 orderItemMapper;
	@Autowired
	private DeliverymanMapper dmMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	// 接受订单 改变商品库存
	@Transactional
	public UserOrder acceptOrder(Long orderId) {
		System.out.println("接受订单  改变商品库存");
		UserOrder order = userOrderMapper.selectByPrimaryKey(orderId);
		// 添加默认的骑手0 默认取消原因 未取消
		order.setDeliverymanId(0L);
		order.setCancelReason("未取消");
		userOrderMapper.updateByPrimaryKey(order);
		List<OrderItem> items = orderItemMapper.selectAll(orderId);
		for (OrderItem orderItem : items) {
			// 判断商品是否为超市商品
			System.out.println("商品信息：" + orderItem.getGoodsId());
			GoodsCategory goodsCategory = goodsCategoryMapper.isInShopping(orderItem.getGoodsId());
			if (goodsCategory != null) {
				// 超市商品 修改库存
				System.out.println("超市商品 修改库存");
				Goods goods = goodsMapper.selectByPrimaryKey(orderItem.getGoodsId());
				goods.setQuantity(goods.getQuantity() - orderItem.getQuantity());
				goodsMapper.updateByPrimaryKey(goods);
			}

		}
		order.setStatus("待发货");
		int a=userOrderMapper.updateByPrimaryKey(order);
		System.out.println("修改商品库存 成功"+a);

		return order;
	}

	// 根据id查询订单
	@Transactional
	public UserOrder getOneOrder(Long orderId) {
		System.out.println("根据id查询订单");
		UserOrder order = userOrderMapper.selectByPrimaryKey(orderId);
		List<OrderItem> items = orderItemMapper.selectAll(orderId);
		order.setList(items);
		System.out.println("订单信息：" + order);
		System.out.println("根据id查询订单 成功");

		return order;
	}

	// 按状态检索
	@Transactional
	public List<UserOrder> getOrderStatus(String status) {
		System.out.println("按状态检索:" + status);
		List<UserOrder> orders = userOrderMapper.selectOrderStatus(status);
		System.out.println("订单信息1：" + orders);
		// 添加订单项
		for (UserOrder userOrder : orders) {
			Long orderId = userOrder.getId();
			List<OrderItem> orderItems = orderItemMapper.selectAll(orderId);
			System.out.println("订单项信息1：" + orderItems);
			userOrder.setList(orderItems);
		}

		System.out.println("订单信息：" + orders);
		System.out.println("按状态检索 成功");

		return orders;
	}

	// 根据条件查找订单
	public List<UserOrder> getOrder(Option option) {

		System.out.println("按条件查询订单");
		System.out.println("查询选项：" + option);
		Collection<FieldError> fs = new HashSet<>();
		List<UserOrder> list = userOrderMapper.selectOrder(option);
		System.out.println("list1:" + list);
		if (list == null) {
			fs.add(new FieldError("order", "订单为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		for (UserOrder userOrder : list) {
			// 订单时间
			Date date = userOrder.getOrderTime();
			System.out.println("旧格式：" + date);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = simpleDateFormat.format(date);
			System.out.println("新格式：" + format);

			System.out.println("userOrder:" + userOrder);
			Long orderId = userOrder.getId();
			// 取订单项
			List<OrderItem> orderItems = orderItemMapper.selectAll(orderId);
			for (OrderItem orderItem : orderItems) {
				System.out.println("orderItem:" + orderItem);
			}
			userOrder.setList(orderItems);
		}

		System.out.println("按条件查询订单  成功");
		System.out.println("===" + list);
		return list;
	}

	// 根据条件查找订单 分页
	public PageInfo<UserOrder> getOrderPage(int pageNum, int pageSize, Option option) {
		PageHelper.startPage(pageNum, pageSize);

		System.out.println("按条件查询订单");
		System.out.println("查询选项：" + option);
		Collection<FieldError> fs = new HashSet<>();
		List<UserOrder> list = userOrderMapper.selectOrder(option);
		if (list == null) {
			fs.add(new FieldError("order", "订单为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		for (UserOrder userOrder : list) {
			System.out.println("userOrder:" + userOrder);
			Long orderId = userOrder.getId();
			// 取订单项
			List<OrderItem> orderItems = orderItemMapper.selectAll(orderId);
			for (OrderItem orderItem : orderItems) {
				System.out.println("orderItem:" + orderItem);
			}
			userOrder.setList(orderItems);
		}

		System.out.println("按条件查询订单  成功");
		System.out.println("===" + list);
		PageInfo<UserOrder> order = new PageInfo<UserOrder>(list);
		return order;
	}

	// 根据条件查找订单 分页 返回订单信息 顾客信息 骑手信息
	public PageInfo<OrderInfo> getOrderPage2(int pageNum, int pageSize, Option option) {
		Collection<FieldError> fs = new HashSet<>();
		PageHelper.startPage(pageNum, pageSize);

		System.out.println("按条件查询订单");
		System.out.println("查询选项：" + option);
		List<UserOrder> list = userOrderMapper.selectOrder(option);
		if (list == null) {
			fs.add(new FieldError("order", "订单为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		//得到正确的total值
		PageInfo<UserOrder> uOrder = new PageInfo<UserOrder>(list);
		System.out.println("正确的total:"+uOrder.getTotal());
		
		for (UserOrder userOrder : list) {
			System.out.println("userOrder:" + userOrder);
			Long orderId = userOrder.getId();
			// 取订单项
			List<OrderItem> orderItems = orderItemMapper.selectAll(orderId);
			for (OrderItem orderItem : orderItems) {
				System.out.println("orderItem:" + orderItem);
			}
			userOrder.setList(orderItems);
		}

		System.out.println("按条件查询订单  成功");
		System.out.println("===订单详情" + list);
		// 添加顾客信息 骑手信息
		List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
		for (UserOrder userOrder : list) {
			OrderInfo orderInfo = new OrderInfo();
			Long aLong = userOrder.getDeliverymanId();// 配送人员id
			Long bLong = userOrder.getCustomerId();// 顾客id
			if (aLong != null) {
				orderInfo.setDeliveryman(dmMapper.selectByPrimaryKey(aLong));
				;
			}
			orderInfo.setCustomer(customerMapper.selectByPrimaryKey(bLong));
			orderInfo.setUserOrder(userOrder);
			orderInfos.add(orderInfo);
		}
		PageInfo<OrderInfo> order = new PageInfo<OrderInfo>(orderInfos);
		System.out.println("total:"+order.getTotal());
		order.setTotal(uOrder.getTotal());
		
		return order;
	}

	// 添加订单取消原因 isCanceled(顾客\商家)
	@Transactional
	public String updateOrderCancelReason(Long orderId, String isCanceled, String reason) {
		Collection<FieldError> fs = new HashSet<>();
		int a = 0;
		// 检索订单信息
		UserOrder order = userOrderMapper.selectByPrimaryKey(orderId);
		if ("顾客".equals(isCanceled)) {
			// 查看订单状态
			String status = order.getStatus();
			if ("待接单".equals(status) || "待付款".equals(status)) {
				// 直接取消订单
				order.setIsCanceled(isCanceled);// 是否取消 谁取消
				order.setCancelReason(reason);// 取消原因
				a = userOrderMapper.updateByPrimaryKey(order);
				return "成功取消订单";
			} else {
				// 已接单 判断处于未取消就 标记为顾客取消
				if ("未取消".equals(order.getIsCanceled()) || order.getIsCanceled().equals("催单")) {
					order.setIsCanceled(isCanceled);// 是否取消 谁取消
					order.setCancelReason(reason);// 取消原因
					a = userOrderMapper.updateByPrimaryKey(order);
					return "成功取消订单";
				} else {
					// 已接单 顾客请求取消订单了
					return "当前订单正在申请取消中，请勿重复操作！";
				}
			}
		} else {
			// 商家取消订单 查看订单状态
			String status = order.getStatus();
			if ("待接单".equals(status)) {
				// 商家未接单 直接取消订单
				order.setStatus("已取消");
				order.setIsCanceled(isCanceled);// 是否取消 谁取消
				order.setCancelReason(reason);// 取消原因
				a = userOrderMapper.updateByPrimaryKey(order);
				return "成功取消订单";
			} else {
				// 接单 用户要求取消
				if ("顾客".equals(order.getIsCanceled())) {
					List<OrderItem> items = orderItemMapper.selectAll(orderId);
					for (OrderItem orderItem : items) {
						// 判断商品是否为超市商品
						System.out.println("商品信息：" + orderItem.getGoodsId());
						GoodsCategory goodsCategory = goodsCategoryMapper.isInShopping(orderItem.getGoodsId());
						if (goodsCategory != null) {
							// 超市商品 修改库存
							System.out.println("超市商品 修改库存");
							Goods goods = goodsMapper.selectByPrimaryKey(orderItem.getGoodsId());
							goods.setQuantity(goods.getQuantity() + orderItem.getQuantity());
							goodsMapper.updateByPrimaryKey(goods);
						}

					}
					order.setStatus("已取消");
					a = userOrderMapper.updateByPrimaryKey(order);
					return "成功取消订单";
				} else {
					// 接单 用户未请求取消 或该订单已经删除了
					return "当前无法取消订单";
				}
			}
		}

	}

	// 修改订单状态
	@Transactional
	public void updateOrderStatus(Long orderId, String status) {
		// 检查更新是否被允许 待付款 待接单 待发货 待收货 已完成 已取消
		System.out.println("修改订单状态");
		int a = 0;
		switch (status) {
		case "待付款":
			System.out.println("待付款 到待接单");
			a = userOrderMapper.updateByStatus(orderId, "待接单");
			break;
		case "待接单":
			System.out.println("待接单 到待发货");
			a = userOrderMapper.updateByStatus(orderId, "待发货");
			break;
		case "待发货":
			System.out.println("待发货 到待收货");
			a = userOrderMapper.updateByStatus(orderId, "待收货");
			break;
		case "待收货":
			System.out.println("待收货 到已完成");
			UserOrder userOrder=userOrderMapper.selectByPrimaryKey(orderId);
			if (userOrder.getIsCanceled().equals("催单")) {
				System.out.println("订单完成，取消催单状态");
				userOrder.setIsCanceled("未取消");
			}
			userOrder.setStatus("已完成");
			a = userOrderMapper.updateByPrimaryKey(userOrder);
			break;

		case "已取消":
			System.out.println("取消订单");
			a = userOrderMapper.updateByStatus(orderId, "已取消");
			break;
		}
		System.out.println("修改订单状态 成功" + a);
	}

	// 用户催单 商家收到催单信息
	@Transactional
	public String updateOrderReminder(Long orderId, String reminder) {
		Collection<FieldError> fs = new HashSet<>();
		// 检索订单信息
		UserOrder order = userOrderMapper.selectByPrimaryKey(orderId);
		System.out.println("用户催单 商家收到催单信息：" + reminder);
		if ("顾客".equals(reminder)) {
			// 未取消 可以催单
			if (order.getIsCanceled().equals("未取消") || order.getIsCanceled().equals("催单")) {
				order.setIsCanceled("催单");
				userOrderMapper.updateByPrimaryKey(order);
				System.out.println("客户催单");
				return "成功催单，请稍等。";
			}
			if (order.getIsCanceled().equals("顾客")) {
				System.out.println("您已申请取消订单，无法催单。");
				return "您已申请取消订单，无法催单。";
			}
			System.out.println("顾客");
			return "催单失败，请刷新后重新测试！";
		}
		if ("商家".equals(reminder)) {
			order.setIsCanceled("未取消");
			System.out.println("确认催单信息");
			userOrderMapper.updateByPrimaryKey(order);
			return "确认催单信息";
		}
		return "催单失败，请刷新后重新测试！";

	}

	// 添加骑手信息
	@Transactional
	public void updateOrderDeliveryman(Long orderId, Long deliverymanId) {
		Collection<FieldError> fs = new HashSet<>();
		System.out.println("添加骑手信息");
		int a = userOrderMapper.updateByDeliveryman(orderId, deliverymanId);
		if (a == 0) {
			fs.add(new FieldError("error", "添加骑手信息失败"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		//修改订单状态  为 待收货
		UserOrder userOrder=userOrderMapper.selectByPrimaryKey(orderId);
		userOrder.setStatus("待收货");
		int b=userOrderMapper.updateByPrimaryKey(userOrder);
		System.out.println("添加骑手信息"+userOrder+"修改："+b);
		System.out.println("添加骑手信息 成功" + a);
	}

	// 用户删除订单 实际为修改订单标识符
	@Transactional
	public String updateOrderDeleted(Long orderId) {
		Collection<FieldError> fs = new HashSet<>();
		System.out.println("用户修改订单标识符");
		// 检索订单信息
		UserOrder userOrder = userOrderMapper.selectByPrimaryKey(orderId);
		// 检查订单状态
		if (!"已完成".equals(userOrder.getStatus())) {
			fs.add(new FieldError("error", "订单无法删除"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		userOrder.setDeleted(1L);// 标识是否被删除，1表示被删除
		System.out.println("订单详情:" + userOrder);
		int a = userOrderMapper.updateByPrimaryKey(userOrder);
		if (a == 0) {
			fs.add(new FieldError("error", "修改订单标识符失败"));
		}
		System.out.println("用户修改订单标识符 " + a);
		return "订单删除成功";
	}

	// 返回新增订单数量 催单数量 申请退单数量
	// 新增added 催单reminder 退款chargeback
	@Transactional
	public OrderData orderData() {
		Collection<FieldError> fs = new HashSet<>();
		OrderData orderData = new OrderData();
		System.out.println("返回新增订单数量  催单数量  申请退单数量");
		// 检索新增订单数量
		Option option = new Option();
		option.setStatus("待接单");
		PageInfo<UserOrder> pages = getOrderPage(0, 0, option);
		System.out.println("新增订单数量:" + pages.getSize());
		orderData.setAdded(pages.getSize());
		// 催单数量
		Option option2 = new Option();
		option2.setIsCanceled("催单");
		pages = getOrderPage(0, 0, option2);
		System.out.println("催单数量:" + pages.getSize());
		orderData.setReminder(pages.getSize());
		// 申请退单数量 顾客取消 且 订单状态不为已取消
		option2.setStatus("已取消");
		option2.setIsCanceled("顾客");
		List<UserOrder> user = userOrderMapper.selectChargeback(option2);
		System.out.println("申请退单数量:" + user.size());
		orderData.setChargeback(user.size());

		System.out.println("返回新增订单数量  催单数量  申请退单数量:" + orderData);
		return orderData;
	}
	
	//根据订单id查找订单项、商品信息
	@Transactional
	public List<OrderDetail> getOrderDetial(Long orderId) {
		//
		List<OrderDetail> orderDetails=new ArrayList<>();
		System.out.println("根据订单id查找订单项、商品信息:"+orderId);
		List<OrderItem> list=orderItemMapper.selectAll(orderId);
		System.out.println("订单信息："+list);
		if (list==null) {
			list=new ArrayList<>();
		}
		//检索订单项商品详情
		for (OrderItem orderItem : list) {
			Goods goods=goodsMapper.selectByPrimaryKey(orderItem.getGoodsId());
			if (goods==null) {
				throw new RuntimeCryptoException("查找订单详情失败");
			}
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setGoods(goods);
			orderDetail.setOrderItem(orderItem);
			orderDetails.add(orderDetail);
			System.out.println("订单一项详情"+orderDetail);
		}
		System.out.println("根据订单id查找订单项、商品信息成功："+orderDetails);
		return orderDetails;
		
	}
	
	

}
