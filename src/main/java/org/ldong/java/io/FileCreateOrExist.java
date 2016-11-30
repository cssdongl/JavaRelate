package org.ldong.java.io;

import java.io.File;
import java.io.IOException;

public class FileCreateOrExist {

	public static void main(String[] args) throws IOException {
		File file = new File("3.txt");
		System.out.println(file.exists());
		System.out.println(System.getProperty("user.dir"));
		if (!file.exists()) {
			file.createNewFile();
		}
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.isAbsolute());
		System.out.println(file.isFile());
		System.out.println(file.getParentFile());
		System.out.println(file.length());
		file.delete();
		File tempFile = File.createTempFile("ddxxxxx", ".tmp",new File("/Users/dongliang"));
		if(tempFile.exists()){
			System.out.println(tempFile.getAbsolutePath());
		}
		// File file1 = new File("3.txt");
		// System.out.println(file1.isDirectory());
	}

}
