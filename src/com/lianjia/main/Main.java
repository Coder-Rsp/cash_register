package com.lianjia.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.alibaba.fastjson.JSONException;
import com.lianjia.controller.BillService;
import com.lianjia.model.Input;
import com.lianjia.model.InputArrayList;

/**
 * 主类，测试数据的输入入口
 * 
 * @author 任师攀
 * @since 2017.4.27
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("本店商品优惠信息如下：");
		System.out.println("可口可乐（代码ITEM000001） 、羽毛球 （代码ITEM000002）买二赠一");
		System.out.println("苹果（代码ITEM000003）95折 ，香蕉（代码ITEM000004）不打折");

		/* 使用flag控制程序的功能选择 */
		int flag = 1;

		try {
			while (flag == 1) {
				System.out.println("功能选择：1、输入购买数据   2、退出");
				Scanner sc = new Scanner(System.in);
				flag = sc.nextInt();
				if (flag == 1) {

					System.out.println("请输入购买数据：");

					/* 获取输入字符串 */
					String input = sc.next();

					/* 数据预处理阶段（合并同一货物的购买数据记录 之后转存到newList中） */
					List<Input> newList = new InputArrayList();
					newList = BillService.Preprocessing(input);

					/* 打印账单阶段 */
					BillService.PrintBill(newList);

				}
			}
		} catch (InputMismatchException e) {
			System.out.println("输入异常！请输入数字1或2选择功能！将退出系统 ==》");
		}catch(JSONException e) {
			System.out.println("输入异常！请输入正确的json格式数据！将退出系统 ==》");
		}catch(Exception e) {
            e.printStackTrace();  
		}
		System.out.println("成功退出系统！");
	}
}
