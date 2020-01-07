package com.briup.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Collection;
import com.briup.smart.mapper.CollectionMapper;
import com.briup.smart.mapper.GoodsMapper;

@Service
public class CollectionService {
	@Autowired
	private CollectionMapper collectionMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	// 添加到收藏夹
	@Transactional
	public void addCollection(Long customerId, Long goodsId) {
		if (!this.beCollected(customerId, goodsId)) {
			collectionMapper.insert(customerId, goodsId);
			goodsMapper.increaseCollectionNumber(goodsId);
		}
	}

	// 从收藏夹删除
	@Transactional
	public void deleteCollection(Long customerId, Long goodsId) {
		if(this.beCollected(customerId, goodsId)) {
			collectionMapper.deleteByPrimaryKey(customerId, goodsId);
			goodsMapper.reduceCollectionNumber(goodsId);
		}
	}

	// 查看用户收藏夹
	public List<Collection> getAllCollection(Long customerId) {
		List<Collection> list = collectionMapper.selectByCustomerId(customerId);
		return list;
	}

	// 是否已收藏
	public boolean beCollected(Long customerId, Long goodsId) {
		Collection collection = collectionMapper.selectByCustomerIdAndGoodsId(customerId, goodsId);
		if (collection == null) {
			return false;
		} else {
			return true;
		}
	}
}
