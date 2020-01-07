package com.briup.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Search;
import com.briup.smart.mapper.SearchMapper;

@Service
public class SearchService {
	@Autowired
	private SearchMapper searchMapper;

	@Transactional
	// 新增记录
	public int addSearch(String keyword, Long customerId) {
		// 取得存储数量
		int number = searchMapper.selectNumberOfId(customerId);
		System.out.println("一共有" + number + "条数据");
		// 判断是否超过十条记录
		if (number >= 10) {
			// 删除最早记录
			searchMapper.deleteMinId(customerId);
		}

		int add = searchMapper.insert(keyword, customerId);
		return add;
	}

	// 删除全部记录
	public int deleteSearch(Long customerId) {
		int delete = searchMapper.deleteByCustomerId(customerId);
		return delete;
	}

	// 查看历史记录
	public List<Search> getAllSearch(Long customerId) {
		List<Search> list = searchMapper.selectByCustomerId(customerId);
		return list;
	}
}
