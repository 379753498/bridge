package com.zeone.txt.imp;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TreeMap;
import org.apache.commons.io.FileUtils;
import com.zeone.Maths.Maths;
import com.zeone.bean.SensorData;
import com.zeone.bean.bridgemathpath;
import com.zeone.bean.databaen;
import com.zeone.bean.tablemaxmin;
import com.zeone.data.databiud;
import com.zeone.io.FileOperation;
import com.zeone.jdbc.databiudmysql;
import com.zeone.lifeline.collector.util.DateUtil;
import com.zeone.txt.FileFactoryRead;

public class FileFactoryReadimp implements FileFactoryRead {

	private static TreeMap<String, ArrayList<String>> tmp = new TreeMap<String, ArrayList<String>>();

	public static ArrayList<databiud> datatest = new ArrayList<databiud>();

	public static ArrayList<databiud> datatesttzz = new ArrayList<databiud>();
	static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
	static long nh = 1000 * 60 * 60;// 一小时的毫秒数
	static long nm = 1000 * 60;// 一分钟的毫秒数
	static long ns = 1000;// 一秒钟的毫秒数long
	ArrayList<String> filelist = new ArrayList<String>();
	ArrayList<databaen> datab;
	private static Double Test;
	private static Double Test1;
	private static String datenow;
	private static Double num = 0.0;
	private static Double avg = 0.0;
	/**
	 * @see 历史数据条数
	 */

	static int lishishujutiaoshu;
	/**
	 * @see 未来数据条数
	 */
	static int weilaishujutiaoshu;
	/**
	 * @see totalLines 文件行数
	 */
	static int totalLines;
	/**
	 * @see chongfushuju 重复数据个数
	 */
	static int chongfushuju = 0;
	/**
	 * @see zhongduanshujugeshu 中断数据个数
	 */
	static int zhongduanshujugeshu = 0;
	/**
	 * @see cuowu 错误频率数据个数
	 */
	static int cuowu;
	/**
	 * @see chaochuliangchenggeshu 超出量程数据
	 */
	static int chaochuliangchenggeshu;
	static int leijizhongduanshijian;
	private static ArrayList<String> as = new ArrayList<String>();
	String Filename;

	@Override
	public String getfilename(String str) {
		String[] s1 = str.split("\\\\");// 第一次加工
		Filename = s1[s1.length - 1];// 取出文件名}
		return Filename;
	}

	/**
	 * 返回目标文件夹以下的所有文件名称List
	 * 
	 * @Override
	 */
	public ArrayList<String> getfilenames(String Filepath) {

		System.out.println(Filepath);

		File root = new File(Filepath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getfilenames(file.getAbsolutePath());

			} else {
				filelist.add(file.getAbsolutePath());

			}

		}

		return filelist;

	}

	
	public ArrayList<String> getfilenamess(String Filepath) {

		System.out.println(Filepath);
		ArrayList<String> str= new ArrayList<String>();
		File root = new File(Filepath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getfilenames(file.getAbsolutePath());

			} else {
				str.add(file.getAbsolutePath());

			}

		}

		return str;

	}

	
	
	public ArrayList<String> getfiledir(String Filepath) {
		ArrayList<String> as= new ArrayList<String>();
		System.out.println(Filepath);

		File root = new File(Filepath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				as.add(file.getPath());

			} 

		}

		return as;

	}
	
	public String getdirname(String Filepath) {

		String[] sa = Filepath.split("\\\\");
		return sa[sa.length-1];
	}
	
	
	/**
	 * 根据文件的名称返回主机名称
	 * 
	 * @Override
	 */
	public String getGatewaynum() {
		String Gatewaynum;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] filenames = Filename.split("_");
			Gatewaynum = filenames[0] + "_" + filenames[1] + "_" + filenames[2]
					+ "_" + filenames[3];
		} else {

			String[] filenames = Filename.split("_");
			Gatewaynum = filenames[0] + "_" + filenames[1] + "_" + filenames[2];
		}

		return Gatewaynum;
	}

	/**
	 * 根据名称获取测量值的类型
	 * 
	 * @Override
	 */
	public String getTesttype() {

		String filelx;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] s1 = Filename.split("_");
			String s4 = s1[6];
			filelx = s4.substring(1, 2);
		} else {
			String[] s3 = Filename.split("_");
			String s4 = s3[5];

			filelx = s4.substring(1, 2);
		}

		if (filelx.equals("0")) {
			filelx = "单测量值";

		} else if (filelx.equals("1")) {
			filelx = "双测量值";
		} else if (filelx.equals("3")) {
			filelx = "特征值";
		} else if (filelx.equals("4")) {
			filelx = "傅立叶变换值";
		} else {
			filelx = "null";
		}
		return filelx;
	}

	/**
	 * 根据文件名称返回通道号
	 * 
	 * @Override
	 */
	public String getpathnum() {

		String pathnum;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] s3 = Filename.split("_");
			pathnum = s3[5];
		} else {
			String[] s3 = Filename.split("_");

			pathnum = s3[4];

		}

		return pathnum;
	}

	/**
	 * @Override 根据文件路径返回 文件的总行数 并调用getstrsz 方法 生成每个文件的databean
	 * 
	 */

	public int getfilerow(String filepath) throws IOException, ParseException {

		datab = new ArrayList<databaen>();
		File file = new File(filepath);
		List<String> list = FileUtils.readLines(file, "utf-8");
		int size = list.size() - 13;
		for (int i = 13; i < list.size(); i++) {
			String al = list.get(i);
			if (al.indexOf("#") > -1) {
				size--;
				continue;
			} else if (al.indexOf("2017") == 0) {

				getstrsz(al);
			} else {
				continue;
			}

		}
		list = null;
		return size;

	}

	public ArrayList<Double> getarrlist(String filepath) throws IOException,ParseException 
	{
		ArrayList<Double> u11 = new ArrayList<Double>();
		File file = new File(filepath);
		FileUtils futil = new FileUtils();
		String al;
		String s;
		Double a;
		@SuppressWarnings("static-access")
		List<String> list = futil.readLines(file, "utf-8");

		for (int i = 13; i < list.size(); i++) 
		{

			al = list.get(i);

			if (al.indexOf("#") > -1) 
			{
				continue;
			} 
			else if (al.indexOf("2017") == 0) 
			{

				s = getvalue(al);
				a = Double.valueOf(s);
				u11.add(a);
			} 
			else
			{
				continue;
			}

		}
		list = null;
		return u11;
	}

	/**
	 * 
	 * @param s
	 *            传感器的设备bean
	 * @param filedataRow
	 *            文件的行数
	 * @throws Exception
	 * 
	 * 
	 */
	public String getmap(SensorData s, int filedataRow) throws Exception {

		StringBuffer sb2 = new StringBuffer();
		sb2.append("桥梁名称" + "\t");
		sb2.append("传感器名称" + "\t");
		sb2.append("模块号" + "\t");
		sb2.append("通道号" + "\t");
		sb2.append("数据时间" + "\t");
		sb2.append("单位时间最大值" + "\t");
		sb2.append("单位时间最小值" + "\t");
		sb2.append("单位时间平均值" + "\t");
		sb2.append("实际采集（频率）" + "\t");
		sb2.append("最大量程" + "\t");
		sb2.append("最小量程" + "\t");
		sb2.append("标准频率" + "\n");

		FileOperation.writeTxFile(sb2.toString(), s.getEquipmentname(), "分析数据");
		sb2 = null;

		for (int i = 0; i < datab.size(); i++) {

			databaen date = datab.get(i);
			num = Double.valueOf(date.getVALUE()) + num;

			Double max = tablemaxmin.max_vlaue(s.getLeixing());
			Double min = tablemaxmin.min_vlaue(s.getLeixing());
			as.add(date.getVALUE());
			Double value = Double.valueOf(date.getVALUE());
			if (value > max || value < min) {// 超出量程范围统计
				chaochuliangchenggeshu = chaochuliangchenggeshu + 1;
				StringBuffer sbchao = new StringBuffer();
				sbchao.append(s.getBridgename()).append("\t");
				sbchao.append(s.getEquipmentname()).append("\t");
				sbchao.append(s.getModularnum()).append("\t");
				sbchao.append(s.getPathnum()).append("\t");
				sbchao.append(date.getDatetime()).append("\t");
				sbchao.append(date.getVALUE()).append("\n");
				FileOperation.writeTxFile(sbchao.toString(),
						s.getEquipmentname(), "超出量程数据明细");

			}
			Date hdatetime = DateUtil.parse(date.getDatetime(),
					"yyyy/MM/dd HH:mm:ss");
			Date hsystime = DateUtil.parse(date.getSystime(),
					"yyyy/MM/dd HH:mm:ss");
			
			if ((hsystime.getTime() - hdatetime.getTime()) > 1000 * 120) 
			{
				lishishujutiaoshu = lishishujutiaoshu + 1;
				StringBuffer sbchao = new StringBuffer();
				sbchao.append(s.getBridgename()).append("\t");
				sbchao.append(s.getEquipmentname()).append("\t");
				sbchao.append(s.getModularnum()).append("\t");
				sbchao.append(s.getPathnum()).append("\t");
				sbchao.append(date.getSystime()).append("\t");
				sbchao.append(date.getDatetime()).append("\t");
				sbchao.append(date.getVALUE()).append("\n");
				FileOperation.writeTxFile(sbchao.toString(),
						s.getEquipmentname(), "历史数据明细");

			}// 系时间大于数据时间超过30秒以上预警数据==历史预警数据条数
			if ((hdatetime.getTime() - hsystime.getTime()) > 1000 * 120) 
			{

				weilaishujutiaoshu = weilaishujutiaoshu + 1;
				StringBuffer sbchao = new StringBuffer();
				sbchao.append(s.getBridgename()).append("\t");
				sbchao.append(s.getEquipmentname()).append("\t");
				sbchao.append(s.getModularnum()).append("\t");
				sbchao.append(s.getPathnum()).append("\t");
				sbchao.append(date.getSystime()).append("\t");
				sbchao.append(date.getDatetime()).append("\t");
				sbchao.append(date.getVALUE()).append("\n");
				FileOperation.writeTxFile(sbchao.toString(),
						s.getEquipmentname(), "未来数据明细");

			}// 系时间小雨数据时间超过30秒以上预警数据==未来预警数据条数
				//

			/**
			 *
			 */

			if (i == datab.size() - 1) {
				datenow = datab.get((int)(datab.size()/2)).getSystime();
				Date numberdate = DateUtil
						.parse(datenow, "yyyy/MM/dd HH:mm:ss");

				datenow = DateUtil.format(numberdate, "yyyy-MM-dd");
				ArrayList<String> als = tmp.get(date.getDatetime());

				if (als != null) {

					StringBuffer sb61 = new StringBuffer();
					sb61.append(s.getBridgename()).append("\t");
					sb61.append(s.getEquipmentname()).append("\t");
					sb61.append(s.getModularnum()).append("\t");
					sb61.append(s.getPathnum()).append("\t");
					sb61.append(date.getDatetime()).append("\n");

					FileOperation.writeTxFile(sb61.toString(),
							s.getEquipmentname(), "重复数据的明细");
					chongfushuju = chongfushuju + 1;
					als.addAll(as);

				} else {// 确认这个时间戳是否已经在map中有重复的KEY 如果没有就把值的集合存起来
					als = as;
				}

				tmp.put(date.getDatetime(), als);// 如果没有就把值的集合存起来
				Date a1 = DateUtil.parse(datab.get(i - 1).getDatetime(),
						"yyyy/MM/dd HH:mm:ss");
				Date a2 = DateUtil.parse(date.getDatetime(),
						"yyyy/MM/dd HH:mm:ss");

				if (a2.getTime() - a1.getTime() > tablemaxmin.longtime(s) && a2.getTime() - a1.getTime() != 0) {
					// System.out.println(date.getDatetime());
					zhongduanshujugeshu = zhongduanshujugeshu + 1;
					long a = a2.getTime() - a1.getTime();
					a = a - (10 * 1000 * 60);

					leijizhongduanshijian = (int) (leijizhongduanshijian + a);

					long day = a / nd;// 计算差多少天
					long hour = a % nd / nh;// 计算差多少小时
					long ming = a % nd % nh / nm;// 计算差多少分钟
					long sec = a % nd % nh % nm / ns;// 计算差多少秒//输出结果
					String b = day + "天" + hour + "小时" + ming + "分钟" + sec
							+ "秒";
					StringBuffer sb5 = new StringBuffer();
					sb5.append(s.getBridgename()).append("\t");
					sb5.append(s.getEquipmentname()).append("\t");
					sb5.append(s.getModularnum()).append("\t");
					sb5.append(s.getPathnum()).append("\t");
					sb5.append(date.getDatetime()).append("上一条数据时间\t");
					sb5.append(datab.get(i).getDatetime()).append("当前时间\t");
					sb5.append(b + "\n");
					FileOperation.writeTxFile(sb5.toString(),
							s.getEquipmentname(), "中断数据明细");

					// System.out.println(b);
				}

				if (als.size() != tablemaxmin.max_frequency(s.getLeixing(),s)) {// 如果这个频率不等于需要的频率
																				// 说明这个值的集合频率存在问题
																				// 是错误频率的数据

					cuowu = cuowu + 1;

					StringBuffer nb = new StringBuffer();
					nb.append(s.getBridgename()).append("\t");
					nb.append(s.getEquipmentname()).append("\t");
					nb.append(s.getModularnum()).append("\t");
					nb.append(s.getPathnum()).append("\t");
					nb.append(date.getDatetime()).append("\t");
					nb.append(als.size()).append("\n");

					FileOperation.writeTxFile(nb.toString(),
							s.getEquipmentname(), "错误频率数据明细表");

				}

				StringBuffer sb1 = new StringBuffer();
				sb1.append(s.getBridgename()).append("\t");
				sb1.append(s.getEquipmentname()).append("\t");
				sb1.append(s.getModularnum()).append("\t");
				sb1.append(s.getPathnum()).append("\t");
				sb1.append(date.getDatetime()).append("\t");
				sb1.append(Maths.germax(als)).append("\t");
				sb1.append(Maths.getmin(als)).append("\t");
				sb1.append(Maths.getavg(als)).append("\t");
				sb1.append(Maths.getsize(als)).append("\t");
				sb1.append(tablemaxmin.max_vlaue(s.getLeixing())).append("\t");
				sb1.append(tablemaxmin.min_vlaue(s.getLeixing())).append("\t");
				sb1.append(tablemaxmin.max_frequency(s.getLeixing(),s)).append(
						"\n");

				FileOperation.writeTxFile(sb1.toString(), s.getEquipmentname(),
						"分析数据");

				sb1 = null;
			
				as = new ArrayList<String>(50000);

				break;

			}

			/**
			 * 
			 * 判断date.getdatatime与下个时间戳是否相同 此项存在的意义是 因为一秒超过一条数据的话 就不进行重复数据的统计了
			 * 继续累加值的集合
			 */

			if (!date.getDatetime().toString().equals(datab.get(i + 1).getDatetime().toString())) 
			{

				ArrayList<String> als = tmp.get(date.getDatetime());
				if (als != null) {// 确认这个时间戳是否已经在map中有重复的KEY 如果有
									// 说明有重复的数据时间戳来了
									// 要记录下来
					StringBuffer sb61 = new StringBuffer();
					sb61.append(s.getBridgename()).append("\t");
					sb61.append(s.getEquipmentname()).append("\t");
					sb61.append(s.getModularnum()).append("\t");
					sb61.append(s.getPathnum()).append("\t");
					sb61.append(date.getDatetime()).append("\n");

					FileOperation.writeTxFile(sb61.toString(),
							s.getEquipmentname(), "重复数据的明细");
					// System.out.println(chongfushuju);

					chongfushuju = chongfushuju + 1;
					als.addAll(as);
				} else {// 确认这个时间戳是否已经在map中有重复的KEY 如果没有就把值的集合存起来
					als = as;
				}

				tmp.put(date.getDatetime(), als);// 如果没有就把值的集合存起来

				if (als.size() != tablemaxmin.max_frequency(s.getLeixing(),s)) {// 如果这个频率不等于需要的频率
																				// 说明这个值的集合频率存在问题
																				// 是错误频率的数据

					cuowu = cuowu + 1;
					StringBuffer nb = new StringBuffer();
					nb.append(s.getBridgename()).append("\t");
					nb.append(s.getEquipmentname()).append("\t");
					nb.append(s.getModularnum()).append("\t");
					nb.append(s.getPathnum()).append("\t");
					nb.append(date.getDatetime()).append("\t");
					nb.append(als.size()).append("\n");

					FileOperation.writeTxFile(nb.toString(),
							s.getEquipmentname(), "错误频率数据明细表");

				}

				Date a1 = DateUtil.parse(date.getDatetime(),
						"yyyy/MM/dd HH:mm:ss");
				Date a2 = DateUtil.parse(datab.get(i + 1).getDatetime(),
						"yyyy/MM/dd HH:mm:ss");

				/**
				 * 判断下一秒的数据时间戳与当前的时间 如果是不等于理论间隔
				 * 
				 */

				if (a2.getTime() - a1.getTime() != tablemaxmin.longtime(s) && a2.getTime() - a1.getTime() != 0) {
					// System.out.println(date.getDatetime());
					long a = a2.getTime() - a1.getTime()- tablemaxmin.longtime(s);
//					if(a>0||a<-1000)
//					{
						leijizhongduanshijian = (int) (leijizhongduanshijian + a);
						long day = a / nd;// 计算差多少天
						long hour = a % nd / nh;// 计算差多少小时
						long ming = a % nd % nh / nm;// 计算差多少分钟
						long sec = a % nd % nh % nm / ns;// 计算差多少秒//输出结果
						String b = day + "天" + hour + "小时" + ming + "分钟" + sec
								+ "秒";
						StringBuffer sb5 = new StringBuffer();
						sb5.append(s.getBridgename()).append("\t");
						sb5.append(s.getEquipmentname()).append("\t");
						sb5.append(s.getModularnum()).append("\t");
						sb5.append(s.getPathnum()).append("\t");
						sb5.append(date.getDatetime()).append("上一条数据时间\t");
						sb5.append(datab.get(i + 1).getDatetime()).append(
								"当前数据时间\t");
						sb5.append(b + "\n");
						FileOperation.writeTxFile(sb5.toString(),
								s.getEquipmentname(), "中断数据明细");
						
						zhongduanshujugeshu = zhongduanshujugeshu + 1;
//					}
					

				}
				StringBuffer sb1 = new StringBuffer();
				sb1.append(s.getBridgename()).append("\t");
				sb1.append(s.getEquipmentname()).append("\t");
				sb1.append(s.getModularnum()).append("\t");
				sb1.append(s.getPathnum()).append("\t");
				sb1.append(date.getDatetime()).append("\t");
				sb1.append(Maths.germax(als)).append("\t");
				sb1.append(Maths.getmin(als)).append("\t");
				sb1.append(Maths.getavg(als)).append("\t");
				sb1.append(Maths.getsize(als)).append("\t");
				sb1.append(tablemaxmin.max_vlaue(s.getLeixing())).append("\t");
				sb1.append(tablemaxmin.min_vlaue(s.getLeixing())).append("\t");
				sb1.append(tablemaxmin.max_frequency(s.getLeixing(),s)).append(
						"\n");

				FileOperation.writeTxFile(sb1.toString(), s.getEquipmentname(),
						"分析数据");

				sb1 = null;
				as=new ArrayList<String>();
			

			}

		}
		// 加入数据统计功能
		avg = num / datab.size();
		StringBuffer sb = new StringBuffer();

		sb.append(filedataRow).append("\n");
		sb.append(avg).append("\n");
		bridgemathpath bmpath = new bridgemathpath();
		bmpath.setBridgename(s.getBridgename());
		bmpath.setAvg(avg);
		bmpath.setEquipmentid(s.getEquipmentid());
		bmpath.setEquipmentname(s.getEquipmentname());
		bmpath.setFilerow(filedataRow);
		bmpath.setGatewaynum(s.getGatewaynum());
		bmpath.setLeixing(s.getLeixing());
		bmpath.setModularnum(s.getModularnum());
		bmpath.setPathnum(s.getPathnum());
		bmpath.setNowdate(datenow);
		bmpath.setName("实时值");
		databiudmysql.insertbridgedatatestdpath(bmpath);

		FileOperation.writeTxFile(sb.toString(), s.getEquipmentname(), "分析数据");
		sb = null;

		databiud da = new databiud();
		da.setBridgename(s.getBridgename());
		da.setEquipmentname(s.getEquipmentname());
		da.setModularnum(s.getModularnum());
		da.setPathnum(s.getPathnum());
		da.setFilerow(filedataRow);

		da.setPl(cuowu);
		da.setLilunpl(tablemaxmin.max_frequency(s.getLeixing(),s));
		da.setTimesize(tmp.size());
		Date n1 = DateUtil.parse(datab.get(0).getDatetime(),
				"yyyy/MM/dd HH:mm:ss");
		Date n2 = DateUtil.parse(datab.get(datab.size() - 1).getDatetime(),
				"yyyy/MM/dd HH:mm:ss");
		long s1 = n2.getTime() - n1.getTime();

		if (s1 < nd) {
			da.setLilunsize((int) ((nd / tablemaxmin.longtime(s))));

		} else {
			da.setLilunsize((int) ((s1 / tablemaxmin.longtime(s))));
		}

		if (s1 == 0) {
			da.setLilunsize(1);
		}
		da.setLilunfilerow(da.getLilunsize()
				* tablemaxmin.max_frequency(s.getLeixing(),s));
		// if (da.getLilunsize() < 3000
		// && tablemaxmin.max_frequency(s.getLeixing()) > 5) {
		// leijizhongduanshijian = (int) ((da.getLilunsize() - da
		// .getTimesize()) * 1000 * 60 * 10);
		//
		// } else {
		// leijizhongduanshijian = (int) ((da.getLilunsize() - da
		// .getTimesize()) * tablemaxmin.longtime(s.getLeixing()));
		//
		// }
		long day = leijizhongduanshijian / nd;// 计算差多少天
		long hour = leijizhongduanshijian % nd / nh;// 计算差多少小时
		long ming = leijizhongduanshijian % nd % nh / nm;// 计算差多少分钟
		long sec = leijizhongduanshijian % nd % nh % nm / ns;// 计算差多少秒//输出结果
		String zhongduanshijian = day + "天" + hour + "小时" + ming + "分钟" + sec
				+ "秒";

		da.setZhongduanshuju(zhongduanshujugeshu);
		da.setChongfushujugeshu(chongfushuju);
		da.setChaochuliangchenggeshu(chaochuliangchenggeshu);
		da.setLishishujutiaoshu(lishishujutiaoshu);
		da.setWeilaishujutiaoshu(weilaishujutiaoshu);
		da.setShujujieshoushijianyichangzongshu(lishishujutiaoshu
				+ weilaishujutiaoshu);
		da.setZhongduanshijian(zhongduanshijian);
		da.setLeijizhongduanshijian(leijizhongduanshijian);
		da.setLeixing(s.getLeixing());
		int a = da.getPl() * da.getLilunpl();
		int b = (int) da.getFilerow();
		Test = (double) a;
		Test1 = (double) b;
		da.setCuowuPLzhanbi((Test / Test1) * 100);
		long a1 = da.getLeijizhongduanshijian() / 1000;
		long b1 = 86400;
		Test = (double) a1;
		Test1 = (double) b1;
		da.setLeijizhongduanshijianzhanbi((Test / Test1) * 100);
		int aaa = da.getChongfushujugeshu() * da.getLilunpl();
		int bba = (int) da.getFilerow();
		Test = (double) aaa;
		Test1 = (double) bba;
		da.setChongfushujzhanbi((Test / Test1) * 100);
		int aa = da.getChaochuliangchenggeshu();
		int ba = (int) da.getFilerow();
		Test = (double) aa;
		Test1 = (double) ba;
		da.setChaochuliangchengfanweizhanbi((Test / Test1) * 100);
		int aaaa = da.getShujujieshoushijianyichangzongshu();
		int bbba = (int) da.getFilerow();
		Test = (double) aaaa;
		Test1 = (double) bbba;

		da.setJieshouyichangzongshuzhanbi((Test / Test1) * 100);
		da.setNowdate(datenow);
		databiudmysql.insertintotable(da);
		datatest.add(da);

		num = 0.0;
		avg = 0.0;
		datenow = null;
		cuowu = 0;
		zhongduanshujugeshu = 0;
		chongfushuju = 0;
		chaochuliangchenggeshu = 0;
		lishishujutiaoshu = 0;
		weilaishujutiaoshu = 0;
		leijizhongduanshijian = 0;
		tmp = new TreeMap<String, ArrayList<String>>();
		return da.getNowdate();

	}

	/**
	 * 
	 * @param s
	 *            每一行的文本数据
	 * @throws ParseException
	 *             根据每一行的文本数据返回 需要的测试值 封装到datab的list中
	 */

	public void getstrsz(String s) throws ParseException {
		// SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String[] Strings = s.split("\t");
		String s4 = Strings[Strings.length - 1];
		String[] values = s4.split(",");
		Strings[Strings.length - 1] = values[0];

		for (int i = 0; i < Strings.length; i++) {
			String a = Strings[i];
			if (i < 2) {
				Date date = DateUtil.parse(a, "yyyyMMdd HHmmss SSS");
				a = DateUtil.format(date, "yyyy/MM/dd HH:mm:ss");
				Strings[i] = a;
			}

		}

		if (getTesttype().equals("特征值")) {
			databaen da = new databaen();
			da.setSystime(Strings[0]);
			da.setDatetime(Strings[1]);
			da.setLevel(Strings[2]);
			da.setMaxVALUE(values[0]);
			da.setMinVALUE(values[1]);
			da.setAvgVALUE(values[2]);
			datab.add(da);
		} else {
			databaen da = new databaen();
			da.setSystime(Strings[0]);
			da.setDatetime(Strings[1]);
			da.setLevel(Strings[2]);
			da.setVALUE(values[0]);
			datab.add(da);

		}
	}

	public String getvalue(String s) throws ParseException {
		// SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String[] Strings = s.split("\t");
		String s4 = Strings[Strings.length - 1];
		String[] values = s4.split(",");
		Strings[Strings.length - 1] = values[0];

		for (int i = 0; i < Strings.length; i++) {
			String a = Strings[i];
			if (i < 2) {
				Date date = DateUtil.parse(a, "yyyyMMdd HHmmss SSS");
				a = DateUtil.format(date, "yyyy/MM/dd HH:mm:ss");
				Strings[i] = a;
			}

		}

		if (getTesttype().equals("特征值")) {
			// databaen da = new databaen();
			// da.setSystime(Strings[0]);
			// da.setDatetime(Strings[1]);
			// da.setLevel(Strings[2]);
			// da.setMaxVALUE(values[0]);
			// da.setMinVALUE(values[1]);
			return values[2];

		} else {

			return values[0];

		}
	}

	/**
	 * 
	 * @param date1
	 *            之前的日期
	 * @param date2
	 *            当前日期
	 * @return 返回日期相差的天数
	 */
	public int getBetweenDay(Date date1, Date date2) {
		Calendar d1 = new GregorianCalendar();
		d1.setTime(date1);
		Calendar d2 = new GregorianCalendar();
		d2.setTime(date2);
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			// d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 根据文件名称返回模块号
	 * 
	 * @return
	 */
	public String getmodularnum() {
		String modularnum;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] s3 = Filename.split("_");
			modularnum = s3[4];
		} else {
			String[] s3 = Filename.split("_");
			modularnum = s3[3];
		}

		return modularnum;

	}

	/**
	 * @Override 根据文件名称返回模块号
	 * @return
	 */
	public String modularnum() {
		String[] s3 = Filename.split("_");
		String modularnum = s3[3];
		return modularnum;

	}

	@Override
	public ArrayList<Object> getbeans(Object Object) throws IOException,
			ParseException {
		return null;
	}

	public String gettezhengzhi(SensorData s, int filedataRow) throws Exception {

		s.setEquipmentname(s.getEquipmentname() + "_特征值");
		StringBuffer sb2 = new StringBuffer();
		sb2.append("桥梁名称" + "\t");
		sb2.append("传感器名称" + "\t");
		sb2.append("模块号" + "\t");
		sb2.append("通道号" + "\t");
		sb2.append("数据时间" + "\t");
		sb2.append("单位时间最大值" + "\t");
		sb2.append("单位时间最小值" + "\t");
		sb2.append("单位时间平均值" + "\t");
		sb2.append("实际采集（频率）" + "\t");
		sb2.append("最大量程" + "\t");
		sb2.append("最小量程" + "\t");
		sb2.append("标准频率" + "\n");

		FileOperation.writeTxFile(sb2.toString(), s.getEquipmentname(), "分析数据");
		sb2 = null;
		for (int i = 0; i < datab.size(); i++) {

			databaen date = datab.get(i);
			num = Double.valueOf(date.getAvgVALUE()) + num;
			Double max = tablemaxmin.max_vlaue(s.getLeixing());
			Double min = tablemaxmin.min_vlaue(s.getLeixing());
			as.add(date.getMaxVALUE());
			Double maxvalue = Double.valueOf(date.getMaxVALUE());
			Double minvalue = Double.valueOf(date.getMinVALUE());
			Double avgvalue = Double.valueOf(date.getAvgVALUE());

			if (maxvalue > max || maxvalue < min || minvalue > max
					|| minvalue < min || avgvalue > max || avgvalue < min) {// 超出量程范围统计
				chaochuliangchenggeshu = chaochuliangchenggeshu + 1;
				StringBuffer sbchao = new StringBuffer();
				sbchao.append(s.getBridgename()).append("\t");
				sbchao.append(s.getEquipmentname()).append("\t");
				sbchao.append(s.getModularnum()).append("\t");
				sbchao.append(s.getPathnum()).append("\t");
				sbchao.append(date.getDatetime()).append("\t");
				sbchao.append(date.getMaxVALUE()).append("\t");
				sbchao.append(date.getMinVALUE()).append("\t");
				sbchao.append(date.getAvgVALUE()).append("\n");
				FileOperation.writeTxFile(sbchao.toString(),
						s.getEquipmentname(), "超出量程数据明细");

			}
			Date hdatetime = DateUtil.parse(date.getDatetime(),
					"yyyy/MM/dd HH:mm:ss");
			Date hsystime = DateUtil.parse(date.getSystime(),
					"yyyy/MM/dd HH:mm:ss");
			if ((hsystime.getTime() - hdatetime.getTime()) > 1000 * 120) {
				lishishujutiaoshu = lishishujutiaoshu + 1;
				StringBuffer sbchao = new StringBuffer();
				sbchao.append(s.getBridgename()).append("\t");
				sbchao.append(s.getEquipmentname()).append("\t");
				sbchao.append(s.getModularnum()).append("\t");
				sbchao.append(s.getPathnum()).append("\t");
				sbchao.append(date.getSystime()).append("\t");
				sbchao.append(date.getDatetime()).append("\t");
				sbchao.append(date.getMaxVALUE()).append("\t");
				sbchao.append(date.getMinVALUE()).append("\t");
				sbchao.append(date.getAvgVALUE()).append("\n");
				FileOperation.writeTxFile(sbchao.toString(),
						s.getEquipmentname(), "历史数据明细");

			}// 系时间大于数据时间超过30秒以上预警数据==历史预警数据条数
			if ((hdatetime.getTime() - hsystime.getTime()) > 1000 * 120) {

				weilaishujutiaoshu = weilaishujutiaoshu + 1;
				StringBuffer sbchao = new StringBuffer();
				sbchao.append(s.getBridgename()).append("\t");
				sbchao.append(s.getEquipmentname()).append("\t");
				sbchao.append(s.getModularnum()).append("\t");
				sbchao.append(s.getPathnum()).append("\t");
				sbchao.append(date.getSystime()).append("\t");
				sbchao.append(date.getDatetime()).append("\t");
				sbchao.append(date.getMaxVALUE()).append("\t");
				sbchao.append(date.getMinVALUE()).append("\t");
				sbchao.append(date.getAvgVALUE()).append("\n");
				FileOperation.writeTxFile(sbchao.toString(),
						s.getEquipmentname(), "未来数据明细");

			}// 系时间小雨数据时间超过30秒以上预警数据==未来预警数据条数
				//
			if (i == datab.size() - 1) {

				datenow = datab.get((int)(datab.size()/2)).getSystime();
				Date numberdate = DateUtil
						.parse(datenow, "yyyy/MM/dd HH:mm:ss");

				datenow = DateUtil.format(numberdate, "yyyy-MM-dd");
				ArrayList<String> als = tmp.get(date.getDatetime());
				if (als != null) {// 确认这个时间戳是否已经在map中有重复的KEY 如果有 说明有重复的数据时间戳来了
									// 要记录下来
					StringBuffer sb6 = new StringBuffer();
					sb6.append(s.getBridgename()).append("\t");
					sb6.append(s.getEquipmentname()).append("\t");
					sb6.append(s.getModularnum()).append("\t");
					sb6.append(s.getPathnum()).append("\t");
					sb6.append(date.getDatetime()).append("\n");

					FileOperation.writeTxFile(sb6.toString(),
							s.getEquipmentname(), "重复数据的明细");
					chongfushuju = chongfushuju + 1;
					als.addAll(as);
				} else {// 确认这个时间戳是否已经在map中有重复的KEY 如果没有就把值的集合存起来
					als = as;
				}

				tmp.put(date.getDatetime(), als);

				if (als.size() != 1) {
					cuowu = cuowu + 1;
					StringBuffer nb1 = new StringBuffer();
					nb1.append(s.getBridgename()).append("\t");
					nb1.append(s.getEquipmentname()).append("\t");
					nb1.append(s.getModularnum()).append("\t");
					nb1.append(s.getPathnum()).append("\t");
					nb1.append(date.getDatetime()).append("\t");
					nb1.append(als.size()).append("\n");

					FileOperation.writeTxFile(nb1.toString(),
							s.getEquipmentname(), "错误频率数据明细表");

				}

				as = null;
				as = new ArrayList<String>();
				StringBuffer sb = new StringBuffer();
				sb.append(s.getBridgename()).append("\t");
				sb.append(s.getEquipmentname()).append("\t");
				sb.append(s.getModularnum()).append("\t");
				sb.append(s.getPathnum()).append("\t");
				sb.append(date.getDatetime()).append("\t");
				sb.append(date.getMaxVALUE()).append("\t");
				sb.append(date.getMinVALUE()).append("\t");
				sb.append(date.getAvgVALUE()).append("\t");
				sb.append(Maths.getsize(als)).append("\t");
				sb.append(tablemaxmin.max_vlaue(s.getLeixing())).append("\t");
				sb.append(tablemaxmin.min_vlaue(s.getLeixing())).append("\t");
				sb.append("1" + "\n");

				FileOperation.writeTxFile(sb.toString(), s.getEquipmentname(),
						"分析数据");
				sb = null;

				break;

			}

			else {// 判断一秒是否是大于一条数据如果等于一条数据就不需要判断小一秒的时间戳了

				Date a1 = DateUtil.parse(date.getDatetime(),
						"yyyy/MM/dd HH:mm:ss");
				Date a2 = DateUtil.parse(datab.get(i + 1).getDatetime(),
						"yyyy/MM/dd HH:mm:ss");
				if ( a2.getTime() - a1.getTime() != 1000*60*10) {
					// System.out.println(date.getDatetime());
					long a = a2.getTime() - a1.getTime();
					a = a - (10 * 1000 * 60);
					if(a>1000||a<-1000)
					{
						leijizhongduanshijian = (int) (leijizhongduanshijian + a);
						long day = a / nd;// 计算差多少天
						long hour = a % nd / nh;// 计算差多少小时
						long ming = a % nd % nh / nm;// 计算差多少分钟
						long sec = a % nd % nh % nm / ns;// 计算差多少秒//输出结果
						String b = day + "天" + hour + "小时" + ming + "分钟" + sec
								+ "秒";
						StringBuffer sb5 = new StringBuffer();
						sb5.append(s.getBridgename()).append("\t");
						sb5.append(s.getEquipmentname()).append("\t");
						sb5.append(s.getModularnum()).append("\t");
						sb5.append(s.getPathnum()).append("\t");
						sb5.append(date.getDatetime()).append("上一条数据时间\t");
						sb5.append(datab.get(i + 1).getDatetime()).append("当前时间\t");
						sb5.append(b + "\n");
						FileOperation.writeTxFile(sb5.toString(),
								s.getEquipmentname(), "中断数据明细");
						zhongduanshujugeshu = zhongduanshujugeshu + 1;
					}
	
				}
				ArrayList<String> als = tmp.get(date.getDatetime());
				if (als != null) {// 确认这个时间戳是否已经在map中有重复的KEY 如果有 说明有重复的数据时间戳来了
									// 要记录下来
					StringBuffer sb6 = new StringBuffer();
					sb6.append(s.getBridgename()).append("\t");
					sb6.append(s.getEquipmentname()).append("\t");
					sb6.append(s.getModularnum()).append("\t");
					sb6.append(s.getPathnum()).append("\t");
					sb6.append(date.getDatetime()).append("\n");

					FileOperation.writeTxFile(sb6.toString(),
							s.getEquipmentname(), "重复数据的明细");
					chongfushuju = chongfushuju + 1;
					als.addAll(as);
				} else {// 确认这个时间戳是否已经在map中有重复的KEY 如果没有就把值的集合存起来
					als = as;
				}

				tmp.put(date.getDatetime(), als);// 如果没有就把值的集合存起来

				if (als.size() != 1) {// 如果这个频率不等于需要的频率
										// 说明这个值的集合频率存在问题
										// 是错误频率的数据

					cuowu = cuowu + 1;

					StringBuffer nb = new StringBuffer();
					nb.append(s.getBridgename()).append("\t");
					nb.append(s.getEquipmentname()).append("\t");
					nb.append(s.getModularnum()).append("\t");
					nb.append(s.getPathnum()).append("\t");
					nb.append(date.getDatetime()).append("\t");
					nb.append(als.size()).append("\n");

					FileOperation.writeTxFile(nb.toString(),
							s.getEquipmentname(), "错误频率数据明细表");

				}
				StringBuffer sb1 = new StringBuffer();
				sb1.append(s.getBridgename()).append("\t");
				sb1.append(s.getEquipmentname()).append("\t");
				sb1.append(s.getModularnum()).append("\t");
				sb1.append(s.getPathnum()).append("\t");
				sb1.append(date.getDatetime()).append("\t");
				sb1.append(date.getMaxVALUE()).append("\t");
				sb1.append(date.getMinVALUE()).append("\t");
				sb1.append(date.getAvgVALUE()).append("\t");
				sb1.append(Maths.getsize(als)).append("\t");
				sb1.append(tablemaxmin.max_vlaue(s.getLeixing())).append("\t");
				sb1.append(tablemaxmin.min_vlaue(s.getLeixing())).append("\t");
				sb1.append("1" + "\n");

				FileOperation.writeTxFile(sb1.toString(), s.getEquipmentname(),
						"分析数据");

				sb1 = null;
				as = null;
				as = new ArrayList<String>();

			}
			/**
			 * 
			 * 判断date.getdatatime与下个时间戳是否相同 此项存在的意义是 因为一秒超过一条数据的话 就不进行重复数据的统计了
			 * 继续累加值的集合
			 */

		}
		avg = num / datab.size();
		StringBuffer sb = new StringBuffer();

		sb.append(filedataRow).append("\n");
		bridgemathpath bmpath = new bridgemathpath();
		bmpath.setBridgename(s.getBridgename());
		bmpath.setAvg(avg);
		bmpath.setEquipmentid(s.getEquipmentid());
		bmpath.setEquipmentname(s.getEquipmentname());
		bmpath.setFilerow(filedataRow);
		bmpath.setGatewaynum(s.getGatewaynum());
		bmpath.setLeixing(s.getLeixing());
		bmpath.setModularnum(s.getModularnum());
		bmpath.setPathnum(s.getPathnum());
		bmpath.setNowdate(datenow);
		bmpath.setName("特征值");
		databiudmysql.insertbridgedatatestdpath(bmpath);

		FileOperation.writeTxFile(sb.toString(), s.getEquipmentname(), "分析数据");
		sb = null;

		databiud da = new databiud();
		da.setBridgename(s.getBridgename());
		da.setEquipmentname(s.getEquipmentname());
		da.setModularnum(s.getModularnum());
		da.setPathnum(s.getPathnum());
		da.setFilerow(filedataRow);

		da.setPl(cuowu);
		da.setLilunpl(1);
		da.setTimesize(tmp.size());
		Date n1 = DateUtil.parse(datab.get(0).getDatetime(),
				"yyyy/MM/dd HH:mm:ss");
		Date n2 = DateUtil.parse(datab.get(datab.size() - 1).getDatetime(),
				"yyyy/MM/dd HH:mm:ss");
		long s1 = n2.getTime() - n1.getTime();
		if (s1 < nd) {
			da.setLilunsize((int) ((nd / (1000 * 60 * 10))));

		} else {
			da.setLilunsize((int) ((s1 / (1000 * 60 * 10))));

		}

		if (s1 == 0) {
			da.setLilunsize(1);
		}
		da.setLilunfilerow(da.getLilunsize() * 1);

		// if (da.getLilunsize() < 3000
		// && tablemaxmin.max_frequency(s.getLeixing()) > 5) {
		// leijizhongduanshijian = (int) ((da.getLilunsize() - da
		// .getTimesize()) * 1000 * 60 * 10);
		//
		// } else {
		// leijizhongduanshijian = (int) ((da.getLilunsize() - da
		// .getTimesize()) * tablemaxmin.longtime(s.getLeixing()));
		//
		// }
		long day = leijizhongduanshijian / nd;// 计算差多少天
		long hour = leijizhongduanshijian % nd / nh;// 计算差多少小时
		long ming = leijizhongduanshijian % nd % nh / nm;// 计算差多少分钟
		long sec = leijizhongduanshijian % nd % nh % nm / ns;// 计算差多少秒//输出结果
		String zhongduanshijian = day + "天" + hour + "小时" + ming + "分钟" + sec
				+ "秒";

		da.setZhongduanshuju(zhongduanshujugeshu);
		da.setChongfushujugeshu(chongfushuju);
		da.setChaochuliangchenggeshu(chaochuliangchenggeshu);
		da.setLishishujutiaoshu(lishishujutiaoshu);
		da.setWeilaishujutiaoshu(weilaishujutiaoshu);
		da.setShujujieshoushijianyichangzongshu(lishishujutiaoshu
				+ weilaishujutiaoshu);
		da.setZhongduanshijian(zhongduanshijian);
		da.setLeijizhongduanshijian(leijizhongduanshijian);
		da.setLeixing(s.getLeixing());
		int a = da.getPl() * da.getLilunpl();
		int b = (int) da.getFilerow();
		Test = (double) a;
		Test1 = (double) b;
		da.setCuowuPLzhanbi((Test / Test1) * 100);
		long a1 = da.getLeijizhongduanshijian() / 1000;
		long b1 = 86400;
		Test = (double) a1;
		Test1 = (double) b1;
		da.setLeijizhongduanshijianzhanbi((Test / Test1) * 100);
		int aaa = da.getChongfushujugeshu() * da.getLilunpl();
		int bba = (int) da.getFilerow();
		Test = (double) aaa;
		Test1 = (double) bba;
		da.setChongfushujzhanbi((Test / Test1) * 100);
		int aa = da.getChaochuliangchenggeshu();
		int ba = (int) da.getFilerow();
		Test = (double) aa;
		Test1 = (double) ba;
		da.setChaochuliangchengfanweizhanbi((Test / Test1) * 100);
		int aaaa = da.getShujujieshoushijianyichangzongshu();
		int bbba = (int) da.getFilerow();
		Test = (double) aaaa;
		Test1 = (double) bbba;
		da.setJieshouyichangzongshuzhanbi((Test / Test1) * 100);
		da.setNowdate(datenow);

		databiudmysql.insertintotabletz(da);

		// if(datatesttzz.size()>0)
		// {
		//
		// Iterator<Entry<SensorData, databiud>>
		// iter=datatesttzz.entrySet().iterator();
		//
		// while(iter.hasNext()){
		// Entry<SensorData, databiud> me=iter.next();
		// if(me.getKey()==s)
		// {
		// System.out.println(s.getEquipmentname()+s.getBridgename());
		// System.out.println(me.getKey().getBridgename()+me.getKey().getEquipmentname());
		// }
		// }
		//
		// }
		//
		//
		// datatesttzz.put(null, da);
		datatesttzz.add(da);

		num = 0.0;
		datenow = null;
		cuowu = 0;
		zhongduanshujugeshu = 0;
		chongfushuju = 0;
		chaochuliangchenggeshu = 0;
		lishishujutiaoshu = 0;
		weilaishujutiaoshu = 0;
		leijizhongduanshijian = 0;
		tmp = new TreeMap<String, ArrayList<String>>();

		return da.getNowdate();
	}

}
