package com.briup.smart.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Deliveryman;
import com.briup.smart.bean.Goods;
import com.briup.smart.bean.GoodsCategory;
import com.briup.smart.mapper.GoodsCategoryMapper;
import com.briup.smart.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FindGoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsCategoryMapper GoodsCategoryMapper;

//	 查看商品类型的详细信息
//	public GoodsCategory selectCategoryById(Long id){
//		GoodsCategory goodsCategory=GoodsCategoryMapper.selectByPrimaryKey(id);
//		return goodsCategory;
//	}
	/*
	 * // 商品是否在超市模块 
	 * public GoodsCategory isInShopping(Long id){ 
	 * 	GoodsCategory gc=GoodsCategoryMapper.isInShopping(id);
	 *  return gc;
	 * }
	 */
	
	// 根据商品所属分区(超市|餐饮)查找商品类型列表
	public List<GoodsCategory> selectGoodsCategoryByRegion(String region) {
		
		List<GoodsCategory> list = null;
		if (region.equals("shopping")) {
			//System.out.println("-------------------------------------");
			list = GoodsCategoryMapper.selectGoodsCategoryByRegionShopping(region);
		}
		if (region.equals("food")) {
			list = GoodsCategoryMapper.selectGoodsCategoryByRegionFood(region);
		}
		//System.out.println(list);
		//System.out.println(region);
		return list;
	}
	
	// 分页 根据商品所属分区(超市|餐饮)查找商品类型列表
	public PageInfo<GoodsCategory> selectGoodsCategoryByRegioin(int pageNum, int pageSize, String region) {
		PageHelper.startPage(pageNum, pageSize, true);
		List<GoodsCategory> list = null;
		if (region.equals("shopping")) {
			// System.out.println("-------------------------------------");
			list = GoodsCategoryMapper.selectGoodsCategoryByRegionShopping(region);
		}
		if (region.equals("food")) {
			list = GoodsCategoryMapper.selectGoodsCategoryByRegionFood(region);
		}
		if (list == null || list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}

//	 根据商品所属分区(超市|餐饮)查找商品列表
//	public List<Goods> selectGoodsByRegion(String region) {
//		List<Goods> list = null;
//		if (region.equals("shopping")) {
//			list = goodsMapper.selectGoodsByRegionShopping(region);
//		}
//		if (region.equals("food")) {
//			list = goodsMapper.selectGoodsByRegionFood(region);
//		}
//		return list;
//	}
	

	// 根据商品类型id查找商品列表
	public List<Goods> selectGoodsByCategoryId(Long id) {
		List<Goods> list = goodsMapper.selectGoodsByCategoryId(id);
		return list;
	}

	// 分页根据商品类型id查找商品列表
	public PageInfo<Goods> selectGoodsByCategoryId(int pageNum, int pageSize, Long id) {
		PageHelper.startPage(pageNum, pageSize, true);
		List<Goods> list = goodsMapper.selectGoodsByCategoryId(id);
		if (list == null || list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}

	// 根据商品id查找商品
	public Goods selectGoodsById(Long id) {
		return goodsMapper.selectByPrimaryKey(id);
	}
	
	// 搜索框:根据商品名称查找商品(超市)
	public List<Goods> selectGoodsByNameShopping(String name) {
		List<Goods> list = goodsMapper.selectByNameShopping(name);
		return list;
	}

	// 分页 搜索框:根据商品名称查找商品(超市)
	public PageInfo<Goods> selectGoodsByNameShopping(int pageNum, int pageSize, String name) {
		// selectByName方法中采用where 参数 like '' 来进行模糊匹配
		PageHelper.startPage(pageNum, pageSize, true);
		List<Goods> list = goodsMapper.selectByNameShopping(name);
		if (list == null || list.isEmpty()) {
			list = new ArrayList<>();
		}
		System.out.println("-----------------------------------");
		return new PageInfo<>(list);
	}

	// 搜索框:根据商品名称查找商品(餐饮)
	public List<Goods> selectGoodsByNameFood(String name) {
		List<Goods> list = goodsMapper.selectByNameFood(name);
		return list;
	}

	// 分页 搜索框:根据商品名称查找商品(餐饮)
	public PageInfo<Goods> selectGoodsByNameFood(int pageNum, int pageSize, String name) {
		// selectByName方法中采用where 参数 like '' 来进行模糊匹配
		PageHelper.startPage(pageNum, pageSize, true);
		List<Goods> list = goodsMapper.selectByNameFood(name);
		if (list == null || list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}
	
	public  PageInfo<Goods> selectGoodsByRegion(int pageNum, int pageSize,String region){
		PageHelper.startPage(pageNum, pageSize, true);
		List<Goods> goods = goodsMapper.selectGoodsByRegion(region);
		return new PageInfo<>(goods);
	}

}
