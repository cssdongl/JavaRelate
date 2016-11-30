package org.ldong.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOutputStream {
	public static void main(String[] args) {
		File dest = new File("/Users/dongliang/java/1.txt");
		if(!dest.exists()){	
			try {
				dest.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		java.io.FileOutputStream fs = null;
		try {
			fs = new java.io.FileOutputStream(dest,true)	;
			String str = "hello,ldong,this one write by java io";
			byte[] bs = str.getBytes();
			fs.write(bs, 0, bs.length);
			fs.flush();
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
}
