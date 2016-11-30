package org.ldong.java.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URlDemo1 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=bj");
		URL url1 = new URL(url,"b.text");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
	}
}
