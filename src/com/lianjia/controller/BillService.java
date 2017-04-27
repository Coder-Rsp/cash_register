package com.lianjia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.alibaba.fastjson.JSON;
import com.lianjia.model.Goods;
import com.lianjia.model.Input;
import com.lianjia.model.InputArrayList;
/**
 * 业务逻辑类，包含了数据预处理和账单打印方法
 * @author 任师攀
 * @since  2017.4.27
 */
public class BillService {

	/**
	 * 方法用于对输入数据进行预处理（合并同一货物的购买数据记录 之后转存到另一个list中）
	 * 这里的输入数据只包括商品代码和购买数量，预处理是把相同商品代码的购买数量相加
	 * @param input  输入的购买数据字符串作为参数
	 * @author 任师攀
	 * @since 2017.4.27
	 */
	public static List<Input> Preprocessing(String input) {

		/* 读取输入的购买数据（字符串格式），将其存储在inputlist中 */
		List<Input> inputlist = JSON.parseArray(input, Input.class);

		/* 新的list用于存储预处理后的数据 */
		List<Input> newList = new InputArrayList();

		/* add操作的过程中查询重复商品并合并购买记录 */
		for (Input item : inputlist) {
			newList.add(item);
		}

		return newList;
		
	}

	
	/**
	 * 方法用于打印账单
	 * @param input  预处理后的购买数据作为参数
	 * @author 任师攀
	 * @since 2017.4.27
	 */
	public static void PrintBill(List<Input> newList) {
		
		/*goodsList用于存储购买的货物信息*/
		List<Goods> goodsList = new ArrayList<Goods>();
		
		/* gift_discount 用于存储符合"买二赠一"条件的货物购买记录索引  */
		Vector gift_discount = new Vector<Integer>();
		
		/*总花费*/
		double total_cost = 0;
		
		/*总节省费用*/
		double total_saving = 0;

		
		/*开始打印账单*/
		System.out.println("***<没钱赚商店>购物清单***");

		/*购物清单部分 ，先由商品代码和购买数量生成更详细的商品购买信息，包括商品编号、商品名、商品数量单位、商品数量、商品单价等，然后打印清单*/
		for (int i = 0; i < newList.size(); i++) {
			/*生成详细的商品购买信息*/
			Input item = newList.get(i);
			Goods goods = new Goods(item.getId(), item.getQuantity());
			total_cost += goods.getCost();
			total_saving += goods.getCost_saving();

			/* 记录符合"买二赠一"条件的商品索引  */
			if (goods.getQuantity_saving() != 0) {
				gift_discount.add(i);
			}

			goodsList.add(goods);
			
			/* 打印购物清单  */
			System.out.println(goods.toString());
		}

		/* 打印"买二赠一"商品信息  */
		System.out.println("----------------------");
		System.out.println("买二赠一商品：");

		for (int i = 0; i < gift_discount.size(); i++) {
			Goods item = goodsList.get((int) gift_discount.get(i));
			System.out.println("名称：" + item.getName() + "，数量："
					+ item.getQuantity_saving() + item.getUnit());
		}

		System.out.println("----------------------");
		System.out.println("总计：" + total_cost + "(元)");
		System.out.println("节省：" + total_saving + "(元)");
		System.out.println("**********************");

	}

}
