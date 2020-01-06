package com.zeone.excel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.zeone.bean.databaen;
import com.zeone.io.FileOperation;
import com.zeone.lifeline.collector.util.DateUtil;

public class test {
public static void main(String[] args) throws Exception {
	
//	 Map<String, List<String[]>> map=excel.readExcel("D://20181023144628-yaliji008.xls");
	 excel excel = new excel("D://20181023144628-yaliji008.xls");
	 
	 List<databaen> showExcel = excel.showExcel();
	 
	 TreeMap<String, databaen> map = new TreeMap<String, databaen>();
	 for (databaen databaen : showExcel) {
		 
		 Date da=DateUtil.parse("2016-10-15 00:00:53","yyyy-MM-dd HH:mm:ss");
		 String datetime = databaen.getDatetime();
		 Date parse =  DateUtil.parse(databaen.getDatetime(),"yyyy-MM-dd HH:mm:ss");
		 
		 if(parse.getTime()>da.getTime())
		 {
		 String format = DateUtil.format(parse, "yyyy-MM-dd HH");
		 System.out.println(format);	
		 if(map.get(format)==null)
		 {
			 map.put(format, databaen);
		 }
			 
		 } 
	}
		
	 
	 Set<Entry<String, databaen>> entrySet = map.entrySet();
	 
	 for (Entry<String, databaen> entry : entrySet) {
		 databaen databaen = entry.getValue();
		 StringBuffer sb = new StringBuffer();
		 sb.append(databaen.getDatetime());
		 sb.append("\t");
		 sb.append(databaen.getVALUE());
		 sb.append("\n");
		 FileOperation.writeTxFile(sb.toString(), "20181023", "a");
		 
	}
	} 
	
	 
}

