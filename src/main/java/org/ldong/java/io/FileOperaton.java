package org.ldong.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileOperaton {

	public static void main(String[] args) {
		// TODO Auto-generated meth
		File dir = new File("/Users/Dongliang");
		System.out.println(Arrays.toString(dir.listRoots()));
		System.out.println(dir.exists());
		File[] subFiles = dir.listFiles();
//		for(File file:subFiles){
//			System.out.println(file.getName());
//		}
		
		File[] subFilterFiles = dir.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith("m2")){
					return true;
				}
				return false;
			}
		});
		
		for(File file:subFilterFiles){
			System.out.println(file.getName());
		}
	}

}
