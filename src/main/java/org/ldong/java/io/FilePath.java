package org.ldong.java.io;

import java.io.File;

public class FilePath {
	public static void main(String[] args) {
		String path1 = "/Users/dongliang";
		String name = "1.txt";
		File file = new File(path1,name);
		System.out.println(file.getName());
		System.out.println(file.getPath());
		
		file =new File("2.txt");
		System.out.println(file.getAbsolutePath());
	}
}
