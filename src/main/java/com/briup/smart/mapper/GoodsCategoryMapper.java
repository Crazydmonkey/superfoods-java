package com.briup.smart.mapper;

import com.briup.smart.bean.GoodsCategory;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsCategoryMapper {
	int deleteByPrimaryKey(Long id);

    int insert(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long id);
    //根据类别名称检索
    GoodsCategory selectByName(String name);

    List<GoodsCategory> selectAll();

    int updateByPrimaryKey(GoodsCategory record);
    
    List<GoodsCategory> selectGoodsCategoryByRegionShopping(String region);//在超市模块中查找类别
                       
    List<GoodsCategory> selectGoodsCategoryByRegionFood(String region);//在餐饮模块中查找类别
    
    GoodsCategory isInShopping(Long id);   //商品是否在超市模块中
}