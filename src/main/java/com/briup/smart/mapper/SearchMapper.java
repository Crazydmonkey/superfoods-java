package com.briup.smart.mapper;

import com.briup.smart.bean.Search;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchMapper {
    int deleteByCustomerId(Long customerId);

    int insert(String keyword,Long customerId);

    List<Search> selectByCustomerId(Long customerId);

    List<Search> selectAll();

    int updateByPrimaryKey(Search record);
    
    int deleteMinId(Long id);
    
    int selectNumberOfId(Long customerId);
}