package com.zeone.txt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public interface FileFactoryRead {
	
	public String getfilename(String str);
	public  ArrayList<String> getfilenames(String Filepath);
	public  String getGatewaynum();
	public  String getTesttype();
	public  String getpathnum();
	public  String modularnum ();
	public  int getfilerow(String filepath) throws FileNotFoundException, UnsupportedEncodingException, IOException;
	public  ArrayList<Object> getbeans( Object Object) throws IOException;


}
