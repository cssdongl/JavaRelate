package org.ldong.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyFile {
	public static void main(String[] args) {
		String srcPath = "/Users/dongliang/java/1.txt";
		String destPath = "/Users/dongliang/java/2.txt";
		try {
			copyFile(srcPath, destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}

	/**
	 * 
	 * @param 源文件的路径
	 * @param 目标文件的路径
	 * @throws IOException 
	 * @throws FileNotFoundException
	 *             ,IOException
	 */
	public static void copyFile(String srcPath, String desPath) throws IOException {
		File src = new File("/Users/dongliang/java/1.txt");
		File desc = new File("/Users/dongliang/java/2.txt");
		if (!desc.exists()) {
			desc.createNewFile();
		}
		FileInputStream is = new FileInputStream(src);
		java.io.FileOutputStream os = new java.io.FileOutputStream(desc);

		byte[] flush = new byte[100];

		int len = 0;
		while ((len = is.read(flush)) != -1) {
			os.write(flush, 0, len);
		}
		os.flush();
		is.close();
		os.close();
	}
}
