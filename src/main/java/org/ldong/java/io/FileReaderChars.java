package org.ldong.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderChars {
	public static void main(String[] args) throws FileNotFoundException {
		File src = new File("/Users/dongliang/java/1.txt");
		Reader reader = new FileReader(src);
		char[] flush = new char[100];
		int len=0;
		try {
			while((len =reader.read(flush)) != -1){
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
