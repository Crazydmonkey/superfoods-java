package com.briup.smart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.Goods;
import com.briup.smart.bean.GoodsCategory;
import com.briup.smart.common.utils.Upload;
import com.briup.smart.common.utils.exception.BusinessException;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.GoodsCategoryMapper;
import com.briup.smart.mapper.GoodsMapper;
import com.briup.smart.web.vm.FieldError;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	public int deleteGoodsById(Long id) throws DataAccessException {
		return goodsMapper.deleteByPrimaryKey(id);
	}

	public void deletesGoodsById(List<Long> ids) throws DataAccessException {
		for (Long id : ids) {
			goodsMapper.deleteByPrimaryKey(id);
		}
	}

	// TODO 未完成新增或 修改
	@Transactional
	public void addOrUpdateGoods(Goods goods, MultipartFile file) {
		System.out.println("goods:" + goods);
		System.out.println("file:" + file);

		Collection<FieldError> fs = new HashSet<>();
		if ("".equals(goods.getName()) || goods.getName() == null) {
			fs.add(new FieldError("name", "商品名不能为空"));
		}
		if ("".equals(goods.getPrice().toString()) || goods.getPrice() == null) {
			fs.add(new FieldError("price", "价格不能为空"));
		}
		if ("".equals(goods.getCost().toString()) || goods.getCost() == null) {
			fs.add(new FieldError("cost", "进价不能为空"));
		}
		if (goods.getPrice() <= 0) {
			fs.add(new FieldError("price", "价格必须大于0"));
		}
		if (goods.getQuantity() <= 0) {
			fs.add(new FieldError("quantity", "数量必须大于0"));
		}
		if (goods.getCost() <= 0) {
			fs.add(new FieldError("cost", "进价必须大于0"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}

		if (goods.getId() != null) {
			Goods goodsFromDB = goodsMapper.selectByPrimaryKey(goods.getId());
			String pictureName = goodsFromDB.getPicture();

			Upload upload = new Upload();
			String result = upload.deletePicture(pictureName);
			if ("成功删除图片".equals(result)) {
				pictureName = upload.uploadPicture(file);
				goods.setPicture(pictureName);
				goodsMapper.updateByPrimaryKey(goods);
			} else {
				throw new RuntimeException("原始图片不存在");
			}
		} else {
			Goods goodsFromDB = goodsMapper.selectByNameExactly(goods.getName());
			if (goodsFromDB != null) {
				throw new BusinessException("商品名已存在");
			}
			
			goods.setCollectionNumber(0);

			Upload upload = new Upload();
			String name = upload.uploadPicture(file);
			goods.setPicture(name);
			
			String description = goods.getDescription();
			if( description == null || "".equals(description)) {
				goods.setDescription("此商品暂无描述");
			}
			goodsMapper.insert(goods);
		}

	}
	
	
	//增加或修改商品分类
	@Transactional
	public String addGoodsCategory(GoodsCategory goodsCategory) {
		System.out.println("新增的商品分类："+goodsCategory);
		//判断是否已经存在
		if (goodsCategory.getId()!=null) {
			System.out.println("商品分类存在");
			//检测name 是否与其他重复
			GoodsCategory gc=goodsCategoryMapper.selectByPrimaryKey(goodsCategory.getId());
			if (goodsCategory.getName().equals(gc.getName())) {
				System.out.println("商品类别名称没有改变");
				return "修改商品分类信息成功";
			}
				//检测是否已存在
			GoodsCategory gc2=goodsCategoryMapper.selectByName(goodsCategory.getName());
			if (gc2!=null) {
				throw new BusinessException("商品分类已存在！");
			}
			goodsCategoryMapper.updateByPrimaryKey(goodsCategory);
			System.out.println("修改成功");
			return "修改商品分类信息成功";
		}
		//新增 检测是否已存在
		GoodsCategory goodsCategory2=goodsCategoryMapper.selectByName(goodsCategory.getName());
		if (goodsCategory2!=null) {
			throw new BusinessException("商品分类已存在！");
		}
		//新增商品分类
		int a=goodsCategoryMapper.insert(goodsCategory);
		System.out.println("新增商品分类成功："+a);
		return "新增的商品分类成功";
	}
	
	
	//删除商品分类
	@Transactional
	public String deleteGoodsCategory(Long id) {
		System.out.println("删除商品分类："+id);
		//判断是否已经存在
		GoodsCategory goodsCategory=goodsCategoryMapper.selectByPrimaryKey(id);
		if (goodsCategory==null) {
			System.out.println("删除时，商品分类不存在");
			throw new BusinessException("删除失败，请刷新后重试！");
		}
		System.out.println("商品分类信息："+goodsCategory);
		//删除商品分类
		int a=goodsCategoryMapper.deleteByPrimaryKey(id);
		System.out.println("删除商品分类成功："+a);
		return "删除的商品分类成功";
	}
	
	//获取全部商品分类（分页）
	@Transactional
	public PageInfo<GoodsCategory> getGoodsCategory(int pageNum, int pageSize, String category) {
		System.out.println("获取全部商品分类（分页）："+category);
		PageHelper.startPage(pageNum,pageSize);
		List<GoodsCategory> goodsCategories=new ArrayList<GoodsCategory>();
		if (category.equals("all")) {
			//检索全部商品类别信息
			goodsCategories=goodsCategoryMapper.selectAll();
		}else if (category.equals("food")) {
			goodsCategories=goodsCategoryMapper.selectGoodsCategoryByRegionFood("food");
		}else {
			goodsCategories=goodsCategoryMapper.selectGoodsCategoryByRegionShopping("shopping");
		}
		System.out.println("检索商品类别成功："+goodsCategories);
		PageInfo<GoodsCategory> pageInfo=new PageInfo<GoodsCategory>(goodsCategories);
		return pageInfo;
	}
	
	
	

}
