package com.xg.xmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xg.xmall.dao.TbItemMapper;
import com.xg.xmall.pojo.TbItem;
import com.xg.xmall.pojo.TbItemExample;
import com.xg.xmall.pojo.TbItemExample.Criteria;
import com.xg.xmall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(long itemId) {
		// TbItem item=itemMapper.selectByPrimaryKey(itemId);
		// return item;
		TbItemExample example = new TbItemExample();
		// 查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}
}
