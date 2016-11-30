
package org.ldong.java.string;
/**   
* @Title: StringBuilderTest.java 
* @Package org.ldong.java.string 
* @author cssdongl@gmail.com
* @date 2016年9月27日 上午11:56:39 
* @version V1.0   
*/
public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append(" ").append("\t").append("").append("\t").append("");
		String x = sb.toString();
		String[] y = x.split("\t");
		String String = new String("xxx");
		System.out.println(y.length);
	}
}

