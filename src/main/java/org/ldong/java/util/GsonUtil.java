
package org.ldong.java.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @Title: GsonUtil.java
 * @Description: 利用gson解析嵌套json
 * @author cssdongl@gmail.com
 * @date 2016年10月11日 上午11:58:42
 * @version V1.0
 */
public class GsonUtil {
	
	/**
	 * parseJsonWithGson:将Json数据解析成相应的映射Java对象. <br/>
	 * @author dongliang
	 * @param jsonData
	 * @param type
	 * @return
	 * @since JDK 1.7
	 */
	public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
		Gson gson = new Gson();
		T result = gson.fromJson(jsonData, type);
		return result;
	}

	
	/**
	 * parseJsonArrayWithGson:将Json数组解析成相应的映射对象列表. <br/>
	 * @author dongliang
	 * @param jsonData
	 * @param type
	 * @return
	 * @since JDK 1.7
	 */
	public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
		Gson gson = new Gson();
		List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
		}.getType());
		return result;
	}
}
