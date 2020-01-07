package com.briup.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.smart.bean.Business;

@Mapper
public interface BusinessMapper {
	int deleteByPrimaryKey(Long id);

    int insert(Business record);

    Business selectByPrimaryKey(Long id);

    List<Business> selectAll();

    int updateByPrimaryKey(Business record);
    
    Business selectByAccount(String account);

}
