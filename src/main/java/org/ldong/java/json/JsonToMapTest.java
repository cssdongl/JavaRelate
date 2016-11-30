
package org.ldong.java.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Title: JsonToMapTest.java
 * @Package com.ldong.java.json
 * @author cssdongl@gmail.com
 * @date 2016年10月31日 下午5:55:53
 * @version V1.0
 */
public class JsonToMapTest {
	public static void main(String[] args) {

		String jsonStr = "{\"appname\":\"Laucher\",\"apppackage\":\"com.jj.yyy\",\"appver\":\"3.4.1\",\"city\":\"Beijing\",\"clientip\":\"124.192.141.232\",\"county\":\"China\",\"dataquantity\":19396,\"datetime\":1930,\"devicebrand\":\"Hongmi\",\"devicefactory\":\"XIAOMI\",\"deviceid\":\"xxxxxxxxxxxxxxxxxxx18\",\"devicename\":\"XIAOMI Hongmi 2\",\"dnstime\":1540,\"firsttime\":1653,\"network\":\"wifi\",\"operator\":\"China Union\",\"os\":\"android\",\"osversion\":\"7.0\",\"region\":\"Beijing\",\"reqtype\":\"http\",\"rescode\":\"200\",\"reserror\":\"error1\",\"resolution\":\"1080x1920\",\"restime\":5734,\"sdkversion\":\"1.1.0\",\"serverip\":\"126.192.141.30\",\"ssltime\":1790,\"sysversion\":\"LMY47V20160720\",\"tcptime\":2030,\"time\":\"2016-09-26 23:59:00\",\"url\":\"http://jj.cn\"}";

		Map jsonMap1 = jsonToMap(jsonStr);
//
//		String appName = (String) jsonMap.get("appname");
//
//		String appVer = (String) jsonMap.get("appver");
//
//		String city = (String) jsonMap.get("city");
//
//		String subStrTest = appName + "_" + appVer + "_" + city;
		
		Map jsonMap = (Map) json2Map(jsonStr);
		String appName = (String) jsonMap.get("operator");
		System.out.println(appName);
	}

	public static String getObject(String key, String JSON) {
		Pattern p = Pattern.compile(String.format("\"%s\":\\s*(.*),", key));
		Matcher matcher = p.matcher(JSON);
		if (matcher.find())
			return matcher.group();
		return null;
	}

	private static HashMap<String, String> toHashMap(Object object) {
		HashMap<String, String> data = new HashMap<String, String>();
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = (String) jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}

	public static Map parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	public Map parseJsonToMap(String jsonStr) {
		Map map = new HashMap();
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			if (v instanceof JSONArray) {
				List list = new ArrayList();
				Iterator it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = (JSONObject) it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	public static Map<Object, Object> jsonToMap(Object jsonObj) {
		JSONObject jsonObject = JSONObject.fromObject(jsonObj);
		Map<Object, Object> map = (Map) jsonObject;
		return map;
	}

	public static Object json2Map(String jsonstring) {

		Stack<Map> maps = new Stack<Map>(); // 用来表示多层的json对象
		Stack<List> lists = new Stack<List>(); // 用来表示多层的list对象
		Stack<Boolean> islist = new Stack<Boolean>();// 判断是不是list
		Stack<String> keys = new Stack<String>(); // 用来表示多层的key

		String keytmp = null;
		Object valuetmp = null;
		StringBuilder builder = new StringBuilder();
		char[] cs = jsonstring.toCharArray();

		for (int i = 0; i < cs.length; i++) {

			switch (cs[i]) {
			case '{': // 如果是{map进栈
				maps.push(new HashMap());
				islist.push(false);
				break;
			case ':':// 如果是：表示这是一个属性建，key进栈
				keys.push(builder.toString());
				builder = new StringBuilder();
				break;
			case '[':
				islist.push(true);
				lists.push(new ArrayList());
				break;
			case ',':// 这是一个分割，因为可能是简单地string的键值对，也有可能是string=map
				// 的键值对，因此valuetmp 使用object类型；
				// 如果valuetmp是null 应该是第一次，如果value不是空有可能是string，那是上一个键值对，需要重新赋值
				// 还有可能是map对象，如果是map对象就不需要了

				boolean listis = islist.peek();

				if (builder.length() > 0)
					valuetmp = builder.toString();
				builder = new StringBuilder();
				if (!listis) {
					keytmp = keys.pop();
					maps.peek().put(keytmp, valuetmp);
				} else
					lists.peek().add(valuetmp);

				break;
			case ']':
				islist.pop();

				if (builder.length() > 0)
					valuetmp = builder.toString();
				builder = new StringBuilder();
				lists.peek().add(valuetmp);
				valuetmp = lists.pop();
				break;
			case '}':
				islist.pop();
				// 这里做的和，做的差不多，只是需要把valuetmp=maps.pop();把map弹出栈
				keytmp = keys.pop();

				if (builder.length() > 0)
					valuetmp = builder.toString();

				builder = new StringBuilder();
				maps.peek().put(keytmp, valuetmp);
				valuetmp = maps.pop();
				break;
			default:
				builder.append(cs[i]);
				break;
			}

		}
		return valuetmp;
	}
}
