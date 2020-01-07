package com.briup.smart.mapper;

import com.briup.smart.bean.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectionMapper {
	int deleteByPrimaryKey(Long customerId, Long goodsId);

	int insert(Long customerId, Long goodsId);

	Collection selectByPrimaryKey(Long id);

	List<Collection> selectByCustomerId(Long customerId);

	int updateByPrimaryKey(Collection record);

	Collection selectByCustomerIdAndGoodsId(Long customerId, Long goodsId);

}