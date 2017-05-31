package com.zeone.loadometer;

public class LoadoMeterinfo {

	/**
	 * 
	 * 
	 * @param s
	 * @return 字符串转化 返回double 类型数据
	 * @Description:
	 */
	public static double Stringtodouble(String s) {
		double d = 0;
		try {
			d = Double.valueOf(s).doubleValue();

		} catch (Exception e) {

			return 0;
			// TODO: handle exception
		}

		return d;

	}

	/**
	 * 
	 * 
	 * @param s
	 * @return 字符串转化 返回int 类型数据
	 * @Description:
	 */
	public static int StringtoInt(String s) {
		int d = 0;
		try {
			d = Integer.valueOf(s).intValue();

		} catch (Exception e) {

			return 0;
			// TODO: handle exception
		}

		return d;

	}

	/**
	 * 
	 * @return 返回车重最大值（吨）
	 * @Description:
	 */
	public static double VEHICLEWEIGHTmax() {
		return 150;

	}

	/**
	 * 
	 * @return 返回车重最小值（吨）
	 * @Description:
	 */
	public static double VEHICLEWEIGHTmin() {
		return 0;

	}

	/**
	 * 
	 * 
	 * @return返回轴数最大值
	 * @Description:
	 */

	public static int AXLENUMmax() {
		return 6;

	}

	/**
	 * 
	 * @return 返回车重最小值（吨）
	 * @Description:
	 */
	/**
	 * 
	 * 
	 * @return返回轴数最小值
	 * @Description:
	 */
	public static int AXLENUMmin() {
		return 2;

	}

	/**
	 * 
	 * 
	 * @return 返回最大轴距
	 * @Description:
	 */

	public static double AXLEDISTANCETmax() {
		return 10;

	}

	/**
	 * 
	 * 
	 * @return 返回最小轴距
	 * @Description:
	 */
	public static double AXLEDISTANCETmin() {
		return 1;

	}

	/**
	 * 
	 * 
	 * @return 返回最大速度
	 * @Description:
	 */
	public static double SPEEDmax() {
		return 150;

	}

	/**
	 * 
	 * 
	 * @return 返回最小速度
	 * @Description:
	 */

	public static double SPEEDmix() {
		return 0;

	}

	/**
	 * 
	 * 
	 * @return 返回最大加速度
	 * @Description:
	 */
	public static double ACCELERATIONmax() {
		return 10.0;

	}

	/**
	 * 
	 * 
	 * @return 返回最小加速度
	 * @Description:
	 */

	public static double ACCELERATIONmix() {
		return -5;

	}
}
