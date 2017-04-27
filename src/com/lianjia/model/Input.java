package com.lianjia.model;

/**
 * 和输入的json数据相对应的model类
 * @author 任师攀
 * @since  2017.4.27
 */
public class Input {

	/* 商品编码 */
	String id;

	/* 商品购买数量 */
	double quantity;
	
	
	/**
	 * 该方法用于判断两个输入的购买记录是否属于同一种商品
	 * @author 任师攀
	 * @since 2017.4.27
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Input) {
			Input t = (Input) obj;
			if (this.id.equals(t.id)) {
				return true;
			}
		}
		return false;
	}

	public Input() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Input(String id, double quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
