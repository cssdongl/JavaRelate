
package org.ldong.java.json;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.util.*;

/**
 * @Title: TestJson.java
 * @Package com.ldong.java.json
 * @author cssdongl@gmail.com
 * @date 2016年10月12日 下午4:49:39
 * @version V1.0
 */
public class TestJson {
	public static void main(String[] args) {
		// 把Map看成一个对象
		String json = "{personlist:[{name:'test1'},{name:'test2'}],map:{test1:{name:'test1'},test2:{name:'test2'}}}";
		Map classMap = new HashMap();
		classMap.put("personlist", Person.class);
		classMap.put("map", Map.class);
		// 使用暗示，直接将json解析为指定自定义对象，其中List完全解析,Map没有完全解析
		MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(JSONObject.fromObject(json),
				MyBeanWithPerson.class, classMap);
		System.out.println(diyBean);

		System.out.println("do the list release");
		List<Person> list = diyBean.getPersonlist();
		for (Person o : list) {
			Person p = (Person) o;
			System.out.println(p.getName());
		}

		System.out.println("do the map release");

		// 先往注册器中注册变换器，需要用到ezmorph包中的类
		MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
		Morpher dynaMorpher = new BeanMorpher(Person.class, morpherRegistry);
		morpherRegistry.registerMorpher(dynaMorpher);

		Map map = diyBean.getMap();
		/* 这里的map没进行类型暗示，故按默认的，里面存的为net.sf.ezmorph.bean.MorphDynaBean类型的对象 */
		System.out.println(map);
		List<Person> output = new ArrayList();
		for (Iterator i = map.values().iterator(); i.hasNext();) {
			// 使用注册器对指定DynaBean进行对象变换
			output.add((Person) morpherRegistry.morph(Person.class, i.next()));
		}

		for (Person p : output) {
			System.out.println(p.getName());
		}
	}
}
