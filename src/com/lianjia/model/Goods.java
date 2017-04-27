package com.lianjia.model;
/**
 * 商品信息类
 * 
 * @author 任师攀
 */
public class Goods {

	/* 商品编号 */
	String id;

	/* 商品名 */
	String name;

	/* 商品数量单位 */
	String unit;

	/* 商品数量 */
	double quantity;

	/* 商品单价 */
	double price;

	/* 总花费 */
	double cost;

	/* 节省费用 */
	double cost_saving;

	/* 节省数量 */
	int quantity_saving;

	/**
	 * 利用商品编码和购买数量初始化商品购买信息，这里假设 可口可乐（代码ITEM000001） 、羽毛球 （代码ITEM000002）买二赠一，
	 * 苹果（代码ITEM000003）95折 ，香蕉（代码ITEM000004）不打折
	 * 
	 * @author 任师攀
	 * @since 2017.4.27
	 * @param id
	 *            商品编码
	 * @param quantity
	 *            商品购买数量
	 */

	public Goods(String id, double quantity) {
		super();
		this.id = id;
		this.quantity = quantity;

		// 可口可乐
		if (id.equals("ITEM000001")) {
			this.name = "可口可乐";
			this.unit = "瓶";
			this.price = 3;
			this.quantity_saving = (int) (this.quantity / 3);
			this.cost_saving = this.quantity_saving * this.price;
			this.cost = (this.quantity - this.quantity_saving) * this.price;
		}

		// 羽毛球
		if (id.equals("ITEM000002")) {
			this.name = "羽毛球";
			this.unit = "个";
			this.price = 1;
			this.quantity_saving = (int) (this.quantity / 3);
			this.cost_saving = this.quantity_saving * this.price;
			this.cost = (this.quantity - this.quantity_saving) * this.price;
		}

		// 苹果
		if (id.equals("ITEM000003")) {
			this.name = "苹果";
			this.unit = "斤";
			this.price = 5.5;
			this.quantity_saving = 0;
			this.cost = this.quantity * this.price * 0.95;
			this.cost_saving = this.quantity * this.price * 0.05;
		}

		// 香蕉
		if (id.equals("ITEM000004")) {
			this.name = "香蕉";
			this.unit = "斤";
			this.price = 4;
			this.quantity_saving = 0;
			this.cost = this.quantity * this.price;
			this.cost_saving = 0;
		}

	}

	/**
	 * 将商品购买信息转换成字符串
	 * @author 任师攀
	 * @since 2017.4.27
	 */
	public String toString() {
		// TODO Auto-generated method stub
		String str = "名称：" + this.name + "，" + "数量：" + this.quantity
				+ this.unit + "，" + "单价：" + this.price + "(元)，" + "小计："
				+ this.cost + "(元)";
		return str;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(String id, String name, String unit, double quantity,
			double price, double cost, double cost_saving, int quantity_saving) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
		this.cost_saving = cost_saving;
		this.quantity_saving = quantity_saving;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCost_saving() {
		return cost_saving;
	}

	public void setCost_saving(double cost_saving) {
		this.cost_saving = cost_saving;
	}

	public double getQuantity_saving() {
		return quantity_saving;
	}

	public void setQuantity_saving(int quantity_saving) {
		this.quantity_saving = quantity_saving;
	}

}
