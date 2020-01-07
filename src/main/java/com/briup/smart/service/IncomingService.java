package com.briup.smart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.OrderItem;
import com.briup.smart.bean.ShowIncoming;
import com.briup.smart.mapper.OrderItemMapper;
import com.briup.smart.mapper.OrderItemMapper3;
import com.briup.smart.mapper.UserOrderMapper3;
@Service
public class IncomingService {
   @Autowired
   private UserOrderMapper3 userOrderMapper3;
//   @Autowired
//   private OrderItemMapper3 orderItemMapper3;
   @Transactional
//   获取所有的订单项
//   public List<OrderItem> selectAllOrderItem(){
//	   List<OrderItem>items=orderItemMapper3.selectAll();
//	   return items;
//   }
   //计算当天收入以及订单数
   public ShowIncoming showCurrentIncoming(){
      ShowIncoming showIncoming=userOrderMapper3.getCurrentIncoming();
	  return showIncoming;
   }

   //计算天总收入、订单数以及日期
   public List<ShowIncoming> getDailyIncoming() {
       List<ShowIncoming>list=userOrderMapper3.getDailyIncoming();
	   System.out.println("--------------------------------------");
	   System.out.println(list);
       return list;
   }
   /*计算周总收入、订单数以及日期
   public double getWeeklyIncoming() {
	   return userOrderMapper3.getWeeklyIncoming();
   }*/
   //计算月总收入、订单数以及日期
   public List<ShowIncoming> getMonthlyIncoming() {
	   List<ShowIncoming>list=userOrderMapper3.getMonthlyIncoming();
	   return list;
   }
   /*计算季度总收入、订单数以及日期
   public double getQuarterlyIncoming() {
	   return userOrderMapper3.getQuarterlyIncoming();
   }*/
   //计算年总收入、订单数以及日期
   public List<ShowIncoming> getYearlyIncoming() {
	   List<ShowIncoming>list=userOrderMapper3.getYearlyIncoming();
	   return list;
   }
   //日收入(本月)
   public List<ShowIncoming> getDailyIncomingByMonth() {
       List<ShowIncoming>list=userOrderMapper3.getDailyIncomingByMonth();
	   System.out.println(list);
       return list;
   }
   //月收入(本年)
       public List<ShowIncoming> getMonthlyIncomingByYear() {
    	   List<ShowIncoming>list=userOrderMapper3.getMonthlyIncomingByYear();
    	   return list;
       }    
}
