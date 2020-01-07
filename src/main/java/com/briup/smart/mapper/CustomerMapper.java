package com.briup.smart.mapper;

import com.briup.smart.bean.Customer;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Customer record);

	Customer selectByPrimaryKey(Long id);

	List<Customer> selectAll();

	int updateByPrimaryKey(Customer record);

	Customer selectByAccount(String account);
}