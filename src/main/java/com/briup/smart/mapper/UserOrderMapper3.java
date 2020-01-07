package com.briup.smart.mapper;

import com.briup.smart.bean.ShowIncoming;
import com.briup.smart.bean.UserOrder;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper3 {
    int deleteByPrimaryKey(Long id);

    int insert(UserOrder record);

    UserOrder selectByPrimaryKey(Long id);

    List<UserOrder> selectAll();

    int updateByPrimaryKey(UserOrder record);
    
    //计算单个订单的收入
   //  getOneIncoming();
    /*计算总收入
     * 1.计算日收入
     * 2.计算周收入
     * 3.计算月收入
     * 4.计算季度收入
     * 5.计算年收入
     * */
    ShowIncoming getCurrentIncoming();
    
	List<ShowIncoming> getDailyIncoming();
	
	//List<ShowIncoming> getWeeklyIncoming();	
	
	List<ShowIncoming> getMonthlyIncoming();
	
	//List<ShowIncoming> getQuarterlyIncoming();
	
	List<ShowIncoming> getYearlyIncoming();
	/*
	 * 展示月内的每日收入
	 * 展示年内的每月收入
	 */
	
	List<ShowIncoming> getDailyIncomingByMonth();
	
	List<ShowIncoming> getMonthlyIncomingByYear();
}