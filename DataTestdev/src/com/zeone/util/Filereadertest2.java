package com.zeone.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import com.zeone.Maths.Maths;
import com.zeone.bean.SensorData;
import com.zeone.bean.lingdianyangben;
import com.zeone.io.FileOperation;
import com.zeone.jdbc.SensorService;
import com.zeone.txt.imp.FileFactoryReadimp;

public class Filereadertest2 {

	static int filedataRow = 0;
	static String Bridgename;
	static String Equipmentname;
	static String type;
	static int pl;
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static int i = 0;
	static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
	static String date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);
	private static FileFactoryReadimp fa;
	private static ArrayList<String> filelist = new ArrayList<String>();
	private static ArrayList<SensorData> SensorData;

	public void init() throws Throwable 
	{

		fa = new FileFactoryReadimp();
		date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);
		test(date);

	}

	/**
	 * 执行分析文件数据 加工报表
	 * 
	 * @throws Throwable
	 * 
	 * */

	static void test(final String date) throws Throwable 
	{
		SensorData = SensorService.getAllSensorInfo();
		System.out.println(date);
		String path = "D://bridgetestdemo";// 定义文件路径
		filelist = fa.getfilenames(path);
		System.out.println(filelist.size());
		System.out.println("开始时间" + new Date());
		Iterator<String> it1 = filelist.iterator();

		StringBuffer sb1 = new StringBuffer();
		sb1.append("桥梁名称" + "\t");
		sb1.append("检测类型" + "\t");
		sb1.append("传感器名称" + "\t");
		sb1.append("模块号" + "\t");
		sb1.append("通道号" + "\t");
		sb1.append("区间最小值" + "\t");
		sb1.append("区间最大值" + "\t");
		sb1.append("符合区间数量" + "\t");
		sb1.append("总数" + "\t");
		sb1.append("占比%" + "\t");
		sb1.append("区间平均值" + "\n");
		FileOperation.writeTxFile(sb1.toString(), date, "平衡清零测试数据依据");

		while (it1.hasNext()) 
		{
			String path1 = it1.next();
			System.out.println(path1);
			fa.getfilename(path1);
			
			String a = fa.getGatewaynum();
			String b = fa.getmodularnum();
			String c = fa.getpathnum();
			
			SensorData sa = getSensorData(a, b, c);
			if (fa.getTesttype().equals("单测量值")|| fa.getTesttype().equals("双测量值")&&!(sa.getLeixing().equals("温度"))&&!(sa.getLeixing().equals("风速"))&&!(sa.getLeixing().equals("风向"))) 
			{
			
				ArrayList<Double> du = fa.getarrlist(path1);

				Double maxvalue = Maths.germaxdouble(du);
				Double minvalue = Maths.getminDouble(du);
				Double rule = Maths.getfenzuqujian(maxvalue, minvalue);//获取最大值最小值以后 通过最大值减去最小值 获取一个加权的值 
				ArrayList<lingdianyangben> yblist= new ArrayList<lingdianyangben>();//
				ArrayList<double[]> la = Maths.getfenzulist(maxvalue, minvalue,rule);// 然后以最小值+加权值 形成一个分组 这个分组不能大于最大值
				int a1 = 0;
				if (a1 == 0) 
				{
					double min = 0;
					double max = 0;
					int size = 0;
					String avg = null;
					for (int i = 0; i < la.size(); i++) 
					{
						double[] da = la.get(i);
						 min = da[0];
						 max = da[1];
						ArrayList<Double> temp = Maths.getlistdouble(du, max,min);//遍历数据分组 获取每个分组的命中数据的占比 命中后就将命中数据返回到list
						 size = temp.size();
						 avg = Maths.getavgdouble(temp);
						 lingdianyangben yb=new lingdianyangben();
						 yb.setVluaetype("实时值");
						 yb.setAvg(avg);
						 yb.setMax(max);
						 yb.setMaxsize(du.size());
						 yb.setSensorData(sa);
						 yb.setMin(min);
						 yb.setSize(size);
						 yb.setZhanbi(Maths.getbaifenbi(size, du.size()));
						 yblist.add(yb);//数据加工 把这个分组的 最大值 最小值 个数 对应传感器信息  平均值 占比率 封装到ArrayList<lingdianyangben> 对象中

					}
					
					lingdianyangben lingdianshuju=Maths.getmaxlingdianyangben(yblist);//通过方法获取最大占比的分组样本
					StringBuffer sb2 = new StringBuffer();
					sb2.append(lingdianshuju.getSensorData().getBridgename() + "\t");
					sb2.append(lingdianshuju.getVluaetype() + "\t");
					sb2.append(lingdianshuju.getSensorData().getEquipmentname() + "\t");
					sb2.append(lingdianshuju.getSensorData().getModularnum() + "\t");
					sb2.append(lingdianshuju.getSensorData().getPathnum() + "\t");
					sb2.append(lingdianshuju.getMin() + "\t");
					sb2.append(lingdianshuju.getMax() + "\t");
					sb2.append(lingdianshuju.getSize() + "\t");
					sb2.append(lingdianshuju.getMaxsize() + "\t");
					sb2.append(lingdianshuju.getZhanbi() + "\t");
					sb2.append(lingdianshuju.getAvg() + "\n");
					FileOperation.writeTxFile(sb2.toString(), date,sa.getBridgename() + "平衡清零测试数据依据");
					
				}

				else 
				{
					for (int i = 0; i < la.size(); i++) 
					{

						double[] da = la.get(i);
						double min = da[0];
						double max = da[1];
						ArrayList<Double> temp = Maths.getlistdouble(du, max,min);
						int size = temp.size();
						String avg = Maths.getavgdouble(temp);
						StringBuffer sb2 = new StringBuffer();
						sb2.append(sa.getBridgename() + "\t");
						sb2.append("实时值" + "\t");
						sb2.append(sa.getEquipmentname() + "\t");
						sb2.append(sa.getModularnum() + "\t");
						sb2.append(sa.getPathnum() + "\t");
						sb2.append(min + "\t");
						sb2.append(max + "\t");
						sb2.append(size + "\t");
						sb2.append(du.size() + "\t");
						sb2.append(Maths.getbaifenbi(size, du.size()) + "\t");
						sb2.append(avg + "\n");
						FileOperation.writeTxFile(sb2.toString(), date,sa.getBridgename() + "平衡清零测试数据依据");
					}

				}


			}

		}
	}

	public static SensorData getSensorData(String Gatewaynum,String Modularnum, String Pathnum) 
	{
		for (SensorData s : SensorData) 
		{
			if (s.getGatewaynum().equals(Gatewaynum)&& s.getModularnum().equals(Modularnum)&& s.getPathnum().equals(Pathnum)) 
			{
				System.out.println("---------");
				return s;
			}
		}
		return null;
	}

	public static SensorData getSensorData2(String bridgename,String Modularnum, String Pathnum) 
	{
		for (SensorData s : SensorData) 
		{
			if (s.getBridgename().equals(bridgename)&& s.getModularnum().equals(Modularnum)&& s.getPathnum().equals(Pathnum)) 
			{
				return s;
			}
		}
		return null;
	}

}
