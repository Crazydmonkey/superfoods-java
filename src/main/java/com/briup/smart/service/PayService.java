package com.briup.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.domain.AlipayTradePayModel;
import com.briup.smart.bean.UserOrder;
import com.briup.smart.mapper.UserOrderMapper;

@Service
public class PayService {
	
	@Autowired
	private UserOrderMapper userOrderMapper;
	
	public AlipayTradePayModel createPayModel(Long orderId) {
		UserOrder userOrder = userOrderMapper.selectByPrimaryKey(orderId);
		
//		String outTradeNo = "000018";
//		String totalAmount = "10.00";
		String outTradeNo = userOrder.getId().toString();
		String totalAmount = userOrder.getAmount().toString();
		AlipayTradePayModel model = new AlipayTradePayModel();
		// 设定订单号 必须要写,且订单号不能重复
		model.setOutTradeNo(outTradeNo);
		// 设置订单金额
		model.setTotalAmount(totalAmount);
		// 订单名字
		model.setSubject("超市-餐饮订单");
		// 订单描述
		model.setBody(System.currentTimeMillis() + "");
		// 产品码:只支持FAST_INSTANT_TRADE_PAY
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		return model;
	}
}
