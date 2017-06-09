package com.zeone.tendency;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import javax.naming.ldap.HasControls;

import com.zeone.Maths.Maths;
import com.zeone.bean.SensorData;
import com.zeone.bean.TendencyBean;
import com.zeone.bean.TendencyGroup;
import com.zeone.bean.databaen;
import com.zeone.io.FileOperation;
import com.zeone.jdbc.SensorService;
import com.zeone.loadometer.LoadoMeterinfo;
import com.zeone.txt.imp.FileFactoryReadimp;

public class Tendency {

	private static ArrayList<String> filelist = new ArrayList<String>();
	private static ArrayList<SensorData> SensorData = SensorService
			.getAllSensorInfo();
	private static FileFactoryReadimp fa = new FileFactoryReadimp();
	private static ArrayList<String> as = new ArrayList<String>();

	public ArrayList<TendencyBean> inint(String path) throws Exception {
		String path1 = path;
		System.out.println(path1 + "开始时间" + new Date());
		fa.getfilename(path1);

		String a = fa.getGatewaynum();
		String b = fa.getmodularnum();
		String c = fa.getpathnum();

		if (fa.getTesttype().equals("单测量值") || fa.getTesttype().equals("双测量值")) {
			SensorData sa = getSensorData(a, b, c);
			System.out.println(path1 + "开始读取时间" + new Date());
			fa.getfilerow(path1);
			System.out.println(path1 + "完成读取时间" + new Date());
			ArrayList<databaen> databean = fa.datab;
			ArrayList<TendencyBean> tblist = new ArrayList<TendencyBean>();

			for (int i = 0; i < databean.size(); i++) {
				if (i == databean.size() - 1) {
					databaen date = databean.get(i);
					as.add(date.getVALUE());
					TendencyBean tb = new TendencyBean();
					tb.setMax(Maths.germax(as));
					tb.setMin(Maths.getmin(as));
					tb.setAvg(Maths.getavg(as));
					tb.setTime(date.getDatetime().toString());
					tb.setSa(sa);
					tblist.add(tb);
					as = new ArrayList<String>();
				}

				else {
					databaen date = databean.get(i);

					as.add(date.getVALUE());
					if (!date
							.getDatetime()
							.toString()
							.equals(databean.get(i + 1).getDatetime()
									.toString())) {
						TendencyBean tb = new TendencyBean();
						tb.setMax(Maths.germax(as));
						tb.setMin(Maths.getmin(as));
						tb.setAvg(Maths.getavg(as));
						tb.setTime(date.getDatetime().toString());
						tb.setSa(sa);
						tblist.add(tb);
						as = new ArrayList<String>();
					}

				}
			}

			return tblist;
		}

		return new ArrayList<TendencyBean>();

	}

	public static void main(String[] args) throws Exception {
		String path = "D://bridgetestdemo";// 定义文件路径

		filelist = fa.getfilenames(path);

		for (int i = 0; i < filelist.size(); i++) {
			Tendency ts = new Tendency();
			ArrayList<TendencyBean> datab = ts.inint(filelist.get(i));
			double criterion;
			if (datab.get(0).getSa().getEquipmentname().equals("应变计Sx21")){
				 criterion = 9.17;	
			}
			else
			{
				criterion = 13.95;	
			}
		
		TendencyGroup tendencyGroup = getGroup(datab, criterion);

		TreeMap<Integer, ArrayList<String>> tmp =tendencyGroup.getTmp();
		for(Integer inta : tmp.keySet())
		{
			ArrayList<String> arrayList = tmp.get(inta);
			for (String string : arrayList) {
				StringBuffer sb11 = new StringBuffer();
				sb11.append(tendencyGroup.getSa().getBridgename() + "\t");
				sb11.append(tendencyGroup.getSa().getEquipmentname() + "\t");
				sb11.append(inta + "\t");
				sb11.append(string + "\n");
				FileOperation.writeTxFile(sb11.toString(), tendencyGroup.getSa().getEquipmentname(),
						"应变数据命中波峰情况");
				sb11 = new StringBuffer();
				
			}
			
		
		}
			
		ArrayList<HashMap<String, Double>>lb = tendencyGroup.getLb();
		for (int j = 0; j < lb.size(); j++) {
			
			HashMap<String, Double> als= lb.get(j);
			for (String inta : als.keySet())
			{
				
				StringBuffer sb1 = new StringBuffer();
				sb1.append(tendencyGroup.getSa().getBridgename() + "\t");
				sb1.append(tendencyGroup.getSa().getEquipmentname() + "\t");
				sb1.append(inta + "\t");
				sb1.append(als.get(inta) + "\n");
				FileOperation.writeTxFile(sb1.toString(), tendencyGroup.getSa().getEquipmentname(),
						"应变数据波峰情况");
				sb1 = new StringBuffer();
				
				
			}
			
		}
	
			

		

		}

	}

	/**
	 * 核心 根据挖掘数据秒情况根据最大值 基准值判断是否存在曲线运动 记录曲线运动规律 并找出波峰
	 * 
	 * @param datab
	 * @Description:
	 */
	public static TendencyGroup getGroup(ArrayList<TendencyBean> datab, double criterion) {

		TreeMap<Integer, ArrayList<String>> tmp =new TreeMap<Integer, ArrayList<String>>();				
		ArrayList<HashMap<String, Double>>lb= new ArrayList<HashMap<String,Double>>();
		HashMap<String, Double> lb1= new HashMap<String, Double>();
		for (int i = 0; i < datab.size()-120; i++) {
			double zero = LoadoMeterinfo.Stringtodouble(datab.get(i).getMax());
			double one = LoadoMeterinfo.Stringtodouble(datab.get(i+1).getMax());
			double two = LoadoMeterinfo.Stringtodouble(datab.get(i + 2)
					.getMax());
			double three = LoadoMeterinfo.Stringtodouble(datab.get(i + 3)
					.getMax());

			
			// 进入上升期间 下降 反之
			if ((one > (criterion + 0.5) &&  two-one>0.2 && three-two>0.2)||(one > (criterion + 0.5)&&one-zero>1.5)) {
				ArrayList<String> ls=  new ArrayList<String>();
				ls.add(datab.get(i).getMax());
				for (int k = i; k < i + 30; k++) {
					double flag = LoadoMeterinfo.Stringtodouble(datab.get(k+1).getMax());

					ls.add(datab.get(k).getMax());
					if (flag < criterion) {
						
						ls.add(datab.get(k+1).getMax());
						
						lb1=Mathchanagesize(ls, criterion, datab.get(i));
						lb.add(lb1);
						TreeMap<Integer, ArrayList<String>> checkandtest = checkandtest(tmp, ls, criterion);
						for (Integer key : checkandtest.keySet()) 
						{  
							tmp.put(key, checkandtest.get(key));
						}
						
						i = k+1;
						break;
					}

				}

			}


		}
		
		TendencyGroup la = new TendencyGroup();
		la.setTmp(tmp);
		la.setSa(datab.get(0).getSa());
		la.setLb(lb);
	
		return la;

	}
	/**
	 * 
	 * 1、加工数据的变化率
	 * 2、匹配现有变化率
	 * 3、产生新的变化率权衡 变化率超过%5丢弃
	 * @param tmp
	 * @param criterion
	 * @return  
	 * @Description:
	 */
	public static TreeMap<Integer, ArrayList<String>> checkandtest(TreeMap<Integer, ArrayList<String>> tmp ,ArrayList<String> ls, double criterion) 
	
	{
		int size=ls.size();//变化个数
		ArrayList<String> arrayList = tmp.get(size);//根据变化个数 分别查找有没有合适匹配分组信息
		
		if(arrayList!=null)
		{
			ArrayList<String> change = Mathchanage(ls, criterion);//获取新的变化率
			ArrayList<String> getbianhua = Getbianhua(arrayList, change);
			
			tmp.put(getbianhua.size(), getbianhua);	
			
			
			
		}
		else
		{
			ArrayList<String> mathchanage = Mathchanage(ls, criterion);
			tmp.put(mathchanage.size(), mathchanage);	
		}
		
		
		return tmp;
		
		
	}

	
/**
 * 根据现有变化率命中后进行平均值操作
 * @param ls
 * @param lss
 * @return  
 * @Description:
 */
public static ArrayList<String> Getbianhua(ArrayList<String> ls, ArrayList<String> lss) 
	
	{
	
		ArrayList<String> la=new ArrayList<String>();
		
		for (int i = 0; i < lss.size(); i++) {
			double ls1 = LoadoMeterinfo.Stringtodouble(ls.get(i));
			double lss1 = LoadoMeterinfo.Stringtodouble(lss.get(i));
			Double avg=(ls1+lss1)/2;
			la.add(avg.toString());
			
		}
	
		return la;
		
	}


/**
 * 返回数据变化率List
 * @param ls
 * @param criterion
 * @return  
 * @Description:
 */
	public static ArrayList<String> Mathchanage(ArrayList<String> ls, double criterion) 
	
	{ArrayList<String> la=new ArrayList<String>();
		if(ls!=null)
		{
			for (int i = 0; i < ls.size(); i++) {
				double stringtodouble = LoadoMeterinfo.Stringtodouble(ls.get(i));
				
				Double x=(stringtodouble-criterion)/criterion*100;
				la.add(x.toString());
				
			}
			
		}
		return la;
		
	}
	/**\
	 * 返回数据有多少个波峰 以及对应的实际应变量
	 * @param ls
	 * @param criterion
	 * @return  
	 * @Description:
	 */
	public static HashMap<String, Double> Mathchanagesize(ArrayList<String> ls, double criterion,TendencyBean la )

	{
		HashMap<String, Double> Bf=new HashMap<String, Double>();
		int num = 0;
		if (ls != null) {
			double zero = LoadoMeterinfo.Stringtodouble(ls.get(0));
			double one = LoadoMeterinfo.Stringtodouble(ls.get(1));
			for (int i = 0; i < ls.size()- 1; i++) {

				if ( zero>one) {
					Bf.put(la.getTime(), zero-criterion);
					num=num+1;
					i++;
				} else {
					
					zero = one;
					one = LoadoMeterinfo.Stringtodouble(ls.get(i + 1));
					i++;
				}

			}

		}

		return Bf;

	}
	
	

	public static SensorData getSensorData(String Gatewaynum,
			String Modularnum, String Pathnum) {
		for (SensorData s : SensorData) {
			if (s.getGatewaynum().equals(Gatewaynum)
					&& s.getModularnum().equals(Modularnum)
					&& s.getPathnum().equals(Pathnum)) {
				return s;
			}
		}
		return null;
	}

	public static SensorData getSensorData2(String bridgename,
			String Modularnum, String Pathnum) {
		for (SensorData s : SensorData) {
			if (s.getBridgename().equals(bridgename)
					&& s.getModularnum().equals(Modularnum)
					&& s.getPathnum().equals(Pathnum)) {
				return s;
			}
		}
		return null;
	}
}