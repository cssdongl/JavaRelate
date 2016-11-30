package org.ldong.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo2 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
//		InputStream ins = url.openStream();
//		byte[] temp = new byte[1024];
//		int len = 0;
//		while(-1 != (len=ins.read(temp))){
//			System.out.println(new String(temp,0,len));
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		while(br.readLine() != null){
			System.out.println(br.readLine());
		}
		br.close();
	}
}
