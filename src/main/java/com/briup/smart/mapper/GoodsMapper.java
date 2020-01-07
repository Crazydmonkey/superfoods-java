package com.briup.smart.mapper;

import com.briup.smart.bean.Goods;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id) throws DataAccessException;

    int insert(Goods record);

    Goods selectByPrimaryKey(Long id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
    
    Goods selectByName(String name);
    
    Goods selectByNameExactly(String name);
    
    List<Goods> selectByNameShopping(@Param(value="name") String name);//超市模糊查找
    
    List<Goods> selectByNameFood(@Param(value="name") String name);//餐饮模糊查找
    
    List<Goods> selectGoodsByRegionShopping(String region);//超市商品查找
    
    List<Goods> selectGoodsByRegionFood(String region);//餐饮商品查找
    
    List<Goods>  selectGoodsByCategoryId(Long id);
    
    List<Goods> selectGoodsByRegion(String region);
    
	int increaseCollectionNumber(Long goodsId);

	int reduceCollectionNumber(Long goodsId);

}