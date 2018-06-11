package com.zeone.util;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.apache.commons.io.FileUtils;

import com.zeone.bean.databaen;
import com.zeone.lifeline.collector.util.DateUtil;
import com.zeone.txt.imp.FileFactoryReadimp;

public class FutureTaskCallableFileTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		Date  date = new Date();
		 
		 System.out.println(date.toString());
		FileFactoryReadimp FileFactoryReadimp = new FileFactoryReadimp();
		// 获取文件列表

		String path = "D://bridgetestdemo";// 定义文件路径
		ArrayList<String> filelist = FileFactoryReadimp.getfilenames(path);

		ExecutorService ExecutorService = Executors.newFixedThreadPool(5);
		List<FutureTask<ArrayList<databaen>>> FutureTask = new ArrayList<FutureTask<ArrayList<databaen>>>();
		for (int i = 0; i < filelist.size(); i++) {

			String string = filelist.get(i).toString();
			FileCallable FileCallable = new FileCallable(string,
					FileFactoryReadimp.getfilename(string));
			FutureTask<ArrayList<databaen>> fa = new FutureTask<ArrayList<databaen>>(
					FileCallable);
			ExecutorService.submit(fa);
			FutureTask.add(fa);

		}
		ExecutorService.shutdown();

		for (FutureTask<ArrayList<databaen>> future : FutureTask) {
			while (true) {
				
				if(future.isDone())
				{ArrayList<databaen> x = future.get();
				
					System.out.println(x.size());

			
				x.clear();
				break;
					
				}
				
			}
		}

		
		Date  date1 = new Date();
		 
		 System.out.println(date1.toString());
	}

}


