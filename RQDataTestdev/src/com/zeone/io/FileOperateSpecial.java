package com.zeone.io;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;


import java.io.File;
import java.io.IOException;

/**
 * 当读取的文件太大就不能直接放入内存中，这样会把内存充爆 出现OutofMemoryError 大文件处理可以使用readLines方法的另一个重载。
 * 下面的例子演示从一个大文件中逐行读取文本，并做行号计数。 Created by panther.dongdong on 2015/11/15.
 */
public class FileOperateSpecial {
//	private final static String INPUT_FILE = "D://collector-data//2017022//bridge//HF_JZQM_00000005//HF_JZQM_00000005_6_12_(0).dat";
	private final static String INPUT_FILE = "C://Users//Administrator//Desktop//danxiancheng.txt";
	static class ReadLine implements LineProcessor<Integer> {

		private Integer totalRow = 0;

		@Override
		public boolean processLine(String line) throws IOException {
			totalRow++;
			return true;
		}

		@Override
		public Integer getResult() {
			return totalRow;
		}
	}

	public static void main(String[] args) {
		File testFile = new File(INPUT_FILE);
		ReadLine counter = new ReadLine();
		try {
			System.out.println("aaaa1");
			Files.readLines(testFile, Charsets.UTF_8, counter);
			System.out.println("aaaa2");
			System.out.println(counter.getResult());
			System.out.println("aaaa");
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.exit(0);
	}
}
