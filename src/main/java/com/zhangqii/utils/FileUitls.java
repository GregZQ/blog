package com.zhangqii.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUitls {

	public static void  InputToFile(InputStream in,File file)throws Exception{
		OutputStream out=new FileOutputStream(file);
		
		
		
		int redebytes=0;
		byte[]bytes=new byte[8192];
		while((redebytes=in.read(bytes, 0, 8192))!=-1){
			out.write(bytes, 0, redebytes);
		}
		out.close();
		in.close();
	}
}
