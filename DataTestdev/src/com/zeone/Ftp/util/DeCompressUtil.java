

package com.zeone.Ftp.util;     
    
import java.io.File;     
import java.io.FileInputStream;
import java.io.FileOutputStream;     
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
    

import org.apache.tools.ant.Project;     
import org.apache.tools.ant.taskdefs.Expand;        
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;


import com.zeone.txt.imp.FileFactoryReadimp;

import de.innosystec.unrar.Archive;     
import de.innosystec.unrar.rarfile.FileHeader;     
    
public class DeCompressUtil {     
   /**   
    * 解压zip格式压缩包   
    * 对应的是ant.jar   
    */    
   private static void unzip(String sourceZip,String destDir) throws Exception{     
       try{     
           Project p = new Project();     
           Expand e = new Expand();     
           e.setProject(p);     
           e.setSrc(new File(sourceZip));     
           e.setOverwrite(false);     
           e.setDest(new File(destDir));     
           /*   
           ant下的zip工具默认压缩编码为UTF-8编码，   
           而winRAR软件压缩是用的windows默认的GBK或者GB2312编码   
           所以解压缩时要制定编码格式   
           */    
           e.setEncoding("gbk");     
           e.execute();     
       }catch(Exception e){     
           throw e;     
       }     
   }     
   /**   
    * 解压rar格式压缩包。   
    * 对应的是java-unrar-0.3.jar，但是java-unrar-0.3.jar又会用到commons-logging-1.1.1.jar   
    */    
   private static void unrar(String sourceRar,String destDir) throws Exception{     
       Archive a = null;     
       FileOutputStream fos = null;     
       try{     
           a = new Archive(new File(sourceRar));     
           FileHeader fh = a.nextFileHeader();     
           while(fh!=null){     
               if(!fh.isDirectory()){     
                   //1 根据不同的操作系统拿到相应的 destDirName 和 destFileName     
                   String compressFileName = fh.getFileNameString().trim();     
                   String destFileName = "";     
                   String destDirName = "";     
                   //非windows系统     
                   if(File.separator.equals("/")){     
                       destFileName = destDir + compressFileName.replaceAll("\\\\", "/");     
                       destDirName = destFileName.substring(0, destFileName.lastIndexOf("/"));     
                   //windows系统      
                   }else{     
                       destFileName = destDir + compressFileName.replaceAll("/", "\\\\");     
                       destDirName = destFileName.substring(0, destFileName.lastIndexOf("\\"));     
                   }     
                   //2创建文件夹     
                   File dir = new File(destDirName);     
                   if(!dir.exists()||!dir.isDirectory()){     
                       dir.mkdirs();     
                   }     
                   //3解压缩文件     
                   fos = new FileOutputStream(new File(destFileName));     
                   a.extractFile(fh, fos);     
                   fos.close();     
                   fos = null;     
               }     
               fh = a.nextFileHeader();     
           }     
           a.close();     
           a = null;     
       }catch(Exception e){     
           throw e;     
       }finally{     
           if(fos!=null){     
               try{fos.close();fos=null;}catch(Exception e){e.printStackTrace();}     
           }     
           if(a!=null){     
               try{a.close();a=null;}catch(Exception e){e.printStackTrace();}     
           }     
       }     
   }     
   /**   
    * 解压缩   
    */    
   public static void deCompress(String sourceFile,String destDir) throws Exception
   {     
	   
//	   FileOperation.createDir(destDir);
	   
       //保证文件夹路径最后是"/"或者"\"     
       char lastChar = destDir.charAt(destDir.length()-1);     
       if(lastChar!='/'&&lastChar!='\\'){     
           destDir += File.separator;     
       }     
       //根据类型，进行相应的解压缩     
       String type = sourceFile.substring(sourceFile.lastIndexOf(".")+1);     
       if(type.equals("zip")){     
           DeCompressUtil.unzip(sourceFile, destDir);     
        }else if(type.equals("rar")){     
            DeCompressUtil.unrar(sourceFile, destDir);     
        }else{     
            throw new Exception("只支持zip和rar格式的压缩包！");     
        }     
    }     
   
   public  void ZipFiles(java.io.File[] srcfile, java.io.File zipfile) 
   {
	    byte[] buf = new byte[1024];
	    try 
	    {
	      // Create the ZIP file
	      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
	      // Compress the files
	      for (int i = 0; i < srcfile.length; i++) 
	      {
	        FileInputStream in = new FileInputStream(srcfile[i]);
	        // Add ZIP entry to output stream.
	        out.putNextEntry(new ZipEntry(srcfile[i].getName()));
	        // Transfer bytes from the file to the ZIP file
	        int len;
	        while ( (len = in.read(buf)) > 0) 
	        {
	          out.write(buf, 0, len);
	        }
	        // Complete the entry
	        out.closeEntry();
	        in.close();
	      }
	      // Complete the ZIP file
	      out.close();
	      System.out.println("压缩完成.");
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
   
   public static File[] getFile(ArrayList<String> getfilenameslist)
   {
	   File[] f=null;
		if (getfilenameslist != null) 
		{
		 f = new File[getfilenameslist.size()];
			for (int i = 0; i < f.length; i++) 
			{
				f[i] = new File(getfilenameslist.get(i).toString());
			}

		}
	   
	   return f;	      
   }
   
   public String[] filedir( String filepath)
   {
	return null;
	   
	   
   }
   
   
   public void ZipFilesStart(String filesrc,String zipdir)
   {
   	
    	System.out.println( new Date()+"开始");
    	FileFactoryReadimp fa= new FileFactoryReadimp();
   	   
   	   		ArrayList<String> getfiledir = fa.getfiledir(filesrc);
   	   	File[] files= null;
   	   		for (String string : getfiledir) {
   	   	  ArrayList<String> getfilenameslist = fa.getfilenamess(string);
      	    files = getFile(getfilenameslist);
      	   String getname=fa.getdirname(string);
      	   File flie= new File(zipdir+getname+".zip");
      	
      	   ZipFiles(files, flie);
      	   files=null;
			}
   	
   	 
   	   System.out.println( new Date()+"结束");
   }
      
   
 

}   