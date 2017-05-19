package com.zeone.Maths;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import com.zeone.bean.bridgedatatestdpath;
import com.zeone.bean.lingdianyangben;

public class Maths {
	/**
	 * 
	 * @param a
	 *            数组
	 * @return 最小值
	 */
	
	
	static 
	{
		System.out.println("静态语句被调用执行");
		
	}
	  public Maths()
	{
		
		System.out.println("构造函数被调用");
	}
	public static String getmin(ArrayList<String> a)

	{
		Double[] db = new Double[a.size()];

		for (int j = 0; j < a.size(); j++) {
			db[j] = getint(a.get(j));

		}
		Arrays.sort(db);
		db[0].toString();

		return db[0].toString();

	}

	public static Double getminDouble(ArrayList<Double> a)

	{
		Double[] db = new Double[a.size()];

		for (int j = 0; j < a.size(); j++) {
			db[j] = a.get(j);

		}
		Arrays.sort(db);
		db[0].toString();

		return db[0];

	}

	public static Double getint(String value)

	{
		Double db = Double.parseDouble(value);

		return db;

	}

	/**
	 * 
	 * @param a
	 *            数字组
	 * @return 最大值
	 */
	public static String germax(ArrayList<String> a)

	{
		Double[] db = new Double[a.size()];

		for (int j = 0; j < a.size(); j++) {
			db[j] = getint(a.get(j));

		}
		Arrays.sort(db);
		db[0].toString();

		return db[db.length - 1].toString();

	}

	public static Double germaxdouble(ArrayList<Double> a)

	{
		Double[] db = new Double[a.size()];

		for (int j = 0; j < a.size(); j++) {
			db[j] = a.get(j);

		}
		Arrays.sort(db);
		db[0].toString();

		return db[db.length - 1];

	}

	
	public static lingdianyangben getmaxlingdianyangben(ArrayList<lingdianyangben> testvaulelist)
	{
		
		Comparator<lingdianyangben> comparator = new Comparator<lingdianyangben>(){
		     public int compare(lingdianyangben s1, lingdianyangben s2) {
		    	 return Double.compare(s2.getZhanbi(),s1.getZhanbi());
		     }
		    };
		
		Collections.sort(testvaulelist, comparator) ; 

		System.out.println("排序后的值"); 
		for(int i=0;i<testvaulelist.size();i++){ 
			
			lingdianyangben emp = testvaulelist.get(i) ; 
			
			System.out.println(emp.getZhanbi());

		} 
		return testvaulelist.get(0);
		
		
	}
	
	
	
	
	
	
	
	/**
	 * 这个比较器没有完成 下次可以找大师傅调试一下
	 * 
	 * @param bridgedatatestdpath
	 */
	public static void getpaixubridgedatatestdpath(ArrayList<bridgedatatestdpath> bridgedatatestdpath)
	{
		
		Comparator<bridgedatatestdpath> comparator = new Comparator<bridgedatatestdpath>(){
		     public int compare(bridgedatatestdpath s1, bridgedatatestdpath s2) {
		    	 
		    	 boolean flag = false;
		 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		 		try {
		 			Date d1 = simpleDateFormat.parse(s1.getNowdate());
		 			Date d2 = simpleDateFormat.parse(s2.getNowdate());
		 			if (d1.getTime() > d2.getTime()) {
		 				flag = true;
		 			}
		 		} catch (ParseException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
		 		if (flag) {
		 			return 1;
		 		} else {
		 			return -1;
		 		}
		     }
		    };
		
		Collections.sort(bridgedatatestdpath, comparator) ; 
	
		
		
	}
	
	
	
	
	/**
	 * 	判断日期大小排序
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int compare2(String s1, String s2) {
		boolean flag = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd",
				Locale.CHINA);
		try {
			Date d1 = simpleDateFormat.parse(s1);
			Date d2 = simpleDateFormat.parse(s2);
			if (d1.getTime() > d2.getTime()) {
				flag = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			return 1;
		} else {
			return -1;
		}
	}

	
	public static double getfenzuqujian(Double max, Double min)

	{
		double a = max - min;
		if (a > 30000) {
			return 30000.00;
		}
		if (a > 3000) {
			return 3000.00;
		}
		if (a > 500) {
			return 50.0;

		}
		if (a > 100) {
			return 10.0;

		} else if (a > 50) {
			return 5.0;

		} else if (a > 30) {
			return 3.0;

		}

		else if (a > 20) {
			return 2.0;

		} else if (a > 10) {
			return 1.0;

		}

		else if (a > 5) {
			return 0.5;

		} else if (a > 3) {
			return 0.3;

		} else if (a > 2) {
			return 0.2;

		} else if (a > 1) {
			return 0.1;

		}

		return a / 10;

	}

	public static ArrayList<double[]> getfenzulist(Double max, Double min,
			Double size) {
		ArrayList<double[]> aa = new ArrayList<double[]>();
		
		while (max>min) {
			aa.add(new double[]{min, min+size});
			min+=size;
		}
		
		aa.add(new double[]{min-size, max});
		

		return aa;

	}

	public static String getsize(ArrayList<String> a)

	{
		int c = a.size();
		String s = Integer.toString(c);
		return s;

	}

	public static String getavg(ArrayList<String> a)

	{
		Double[] db = new Double[a.size()];
		Double num = (double) 0.0;

		for (int j = 0; j < a.size(); j++) {
			db[j] = getint(a.get(j));
			num = db[j] + num;
		}
		num = (num / (db.length));
		return num.toString();

	}

	public static Double getbaifenbi(int size, int sizenum) {

		NumberFormat numberFormat = NumberFormat.getInstance();

		// 设置精确到小数点后2位

		numberFormat.setMaximumFractionDigits(2);

		String result = numberFormat.format((float) size / (float) sizenum
				* 100);

		return Double.valueOf(result);

	}

	public static String getavgdouble(ArrayList<Double> a)

	{

		if (a.size() == 0) {
			return "0.00";

		}
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);

		Double[] db = new Double[a.size()];
		Double num = (double) 0.0;

		for (int j = 0; j < a.size(); j++) {
			db[j] = a.get(j);
			num = Double.valueOf((df.format(db[j]))) + num;
		}
		num = (num / (db.length));
		return df.format(num);

	}

	public static Boolean panduanqujianzhi(Double bijiaozhi, Double max,
			Double min) {

		if (bijiaozhi >= min && bijiaozhi <= max) {
			return true;

		}

		return false;

	}

	public static ArrayList<Double> getlistdouble(ArrayList<Double> list,
			Double max, Double min) {
		ArrayList<Double> abc = new ArrayList<Double>();
		for (int i = 0; i < list.size(); i++) {

			Double value = list.get(i);

			Boolean a = panduanqujianzhi(value, max, min);
			if (a) {
				abc.add(value);
			}

		}

		return abc;

	}

}
