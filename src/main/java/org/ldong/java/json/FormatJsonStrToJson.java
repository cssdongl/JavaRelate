
package org.ldong.java.json;

import java.nio.charset.Charset;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

/**
 * @Title: FormatJsonStrToJson.java
 * @Package com.ldong.java.json
 * @Description: test sdfsfsdfs
 * @author cssdongl@gmail.com
 * @date 2016年10月28日 下午3:52:00
 * @version V1.0
 */
public class FormatJsonStrToJson {

	public static void main(String[] args) {
		// System.out.println(System.currentTimeMillis());
		String jsonStr = "{\"appname\":\"Laucher\",\"apppackage\":\"com.jj.yyy\",\"appver\":\"3.4.1\",\"city\":\"Beijing\",\"clientip\":\"124.192.141.232\",\"county\":\"China\",\"dataquantity\":19396,\"datetime\":1930,\"devicebrand\":\"Hongmi\",\"devicefactory\":\"XIAOMI\",\"deviceid\":\"xxxxxxxxxxxxxxxxxxx18\",\"devicename\":\"XIAOMI Hongmi 2\",\"dnstime\":1540,\"firsttime\":1653,\"network\":\"wifi\",\"operator\":\"China Union\",\"os\":\"android\",\"osversion\":\"7.0\",\"region\":\"Beijing\",\"reqtype\":\"http\",\"rescode\":\"200\",\"reserror\":\"error1\",\"resolution\":\"1080x1920\",\"restime\":5734,\"sdkversion\":\"1.1.0\",\"serverip\":\"126.192.141.30\",\"ssltime\":1790,\"sysversion\":\"LMY47V20160720\",\"tcptime\":2030,\"time\":\"2016-09-26 23:59:00\",\"url\":\"http://jj.cn\"}";
		String base64BinaryString = DatatypeConverter.printBase64Binary(jsonStr.getBytes(Charset.forName("UTF-8")));
		String jsonString = new String(DatatypeConverter.parseBase64Binary(base64BinaryString));
		System.out.println(jsonString);
	}

	/**
	 * 得到格式化json数据 退格用\t 换行用\r
	 */
	public static String format(String jsonStr) {
		int level = 0;
		StringBuffer formatJson = new StringBuffer();
		for (int i = 0; i < jsonStr.length(); i++) {
			char c = jsonStr.charAt(i);
			if (level > 0 && '\n' == formatJson.charAt(formatJson.length() - 1)) {
				formatJson.append(getLevelStr(level));
			}
			switch (c) {
			case '{':
			case '[':
				formatJson.append(c + "\n");
				level++;
				break;
			case ',':
				formatJson.append(c + "\n");
				break;
			case '}':
			case ']':
				formatJson.append("\n");
				level--;
				formatJson.append(getLevelStr(level));
				formatJson.append(c);
				break;
			default:
				formatJson.append(c);
				break;
			}
		}
		return formatJson.toString();
	}

	private static String getLevelStr(int level) {
		StringBuffer levelStr = new StringBuffer();
		for (int levelI = 0; levelI < level; levelI++) {
			levelStr.append("\t");
		}
		return levelStr.toString();
	}

}
