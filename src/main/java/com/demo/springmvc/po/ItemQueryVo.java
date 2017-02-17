package com.demo.springmvc.po;

import java.util.List;

/**
 * 商品的包装类
 * Created by 7 on 2017/2/10.
 */
public class ItemQueryVo {
	private ItemCustom itemsCustom;
	private List<ItemCustom> itemsList;

	public ItemCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemCustom> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "ItemQueryVo{" +
				"itemsCustom=" + itemsCustom +
				", itemsList=" + itemsList +
				'}';
	}
}
