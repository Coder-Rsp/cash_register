package com.lianjia.model;

import java.util.ArrayList;

/**
 * 类中的方法用于合并同一货物的购买数据记录
 * @author 任师攀
 * @since  2017.4.27
 */
public class InputArrayList extends ArrayList<Input> {
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean add(Input e) {
		for (int i = 0; i < super.size(); i++) {
			Input d = super.get(i);
			if (e.equals(d)) {
				d.setQuantity(d.getQuantity() + e.getQuantity());
				return true;
			}
		}
		return super.add(e);
	}
}
