package com.briup.smart.mapper;

import com.briup.smart.bean.Deliveryman;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliverymanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Deliveryman record);

    Deliveryman selectByPrimaryKey(Long id);

    List<Deliveryman> selectAll();

    int updateByPrimaryKey(Deliveryman record);
    
    List<Deliveryman> selectDeliveryman(Deliveryman dm);
    
}