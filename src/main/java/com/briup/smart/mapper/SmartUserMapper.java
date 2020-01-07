package com.briup.smart.mapper;

import com.briup.smart.bean.SmartUser;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmartUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmartUser record);

    SmartUser selectByPrimaryKey(Long id);

    List<SmartUser> selectAll();

    int updateByPrimaryKey(SmartUser record);
}