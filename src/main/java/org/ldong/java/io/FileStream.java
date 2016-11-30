package org.ldong.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileStream {
	public static void main(String[] args) {
		File src = new File("/Users/dongliang/.bash_profile");
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(src);
			byte[] c = new byte[10];
			int len=0;
			while ((len=fs.read(c)) != -1) {
				String str = new String(c,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
