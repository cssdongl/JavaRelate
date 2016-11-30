package org.ldong.java.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/**
 * 
 * @Title: StringUtil.java
 * @Copyright: Copyright (c) 2015
 * @Description: <br>
 *              字符串转换工具类 <br>
 * @Created on 2016年9月27日 上午10:27:03
 * @author cssdongl@gmail.com
 */
public class StringUtil {
	/**
	 * @param eventFiles
	 *            : HDFS 文件路径集合
	 * @return path1,path2,...,pathN
	 */
	public static String getPaths(List<String> eventFiles) {
		String rsStr = null;

		if (null != eventFiles && eventFiles.size() > 0) {
			String listStr = eventFiles.toString();
			String noSpaceStr = listStr.replaceAll(" ", "");
			rsStr = noSpaceStr.substring(1, noSpaceStr.length() - 1);
		}
		return rsStr;
	}

	/**
	 * getUrlDomain:get the host domain in the url. <br/>
	 * @author dongliang@mail.jj.com
	 * @param stringUrl original url
	 * @return the domain in the url
	 * @throws MalformedURLException
	 * @since JDK 1.7
	 */
	public static String getUrlDomain(String stringUrl) throws MalformedURLException {
		//Preconditions.checkNotNull(stringUrl, "stringUrl must not be null");

		URL url = new URL(stringUrl);
		//get the host
		String host = url.getHost();
		
		return host;
	}
	

	public static void main(String[] args) throws MalformedURLException {
		String url = getUrlDomain("http://jj.cn/box");
		System.out.println(url);
		StringBuilder sb = new StringBuilder(16);
		System.out.println(sb.append("xxx").append(1142314234).toString());
	}

}
