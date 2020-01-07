package com.briup.smart.mapper;

import com.briup.smart.bean.UserOrder;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOrder record);

    UserOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserOrder record);
}