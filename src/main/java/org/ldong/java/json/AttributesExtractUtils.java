
package org.ldong.java.json;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**   
* @Title: xx.java 
* @Package com.ldong.java.json 
* @Description: 释放json部分字段 
* @author cssdongl@gmail.com
* @date 2016年10月24日 下午2:41:15 
* @version V1.0   
*/
public class AttributesExtractUtils {

    private static Logger LOGGER = LogManager.getLogger(AttributesExtractUtils.class);

    /**
     * 从集合中提取信息
     *
     * @param targets
     * @param targetFields
     * @return
     */
    public static List<Map<String, Object>> extractForCollection(Collection<?> targets, String... targetFields) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Object target : targets) {
            result.add(extract(target, targetFields));
        }
        return result;
    }

    /**
     * 从普通POJO类中提取关键信息, 要求遵循 getMethod 规范
     *
     * @param target       目标JAVA POJO类,要求装有数据
     * @param targetFields 类的属性名字: 希望从 POJO 中提取哪些字段的数据
     * @return 数据会被装载于MAP中
     */
    public static Map<String, Object> extract(Object target, String... targetFields) {
        if ((null == target) || null == targetFields || 0 == targetFields.length) {
            return new HashMap<String, Object>();
        }
        Map<String, Object> objectMap = new HashMap<String, Object>();
        for (String targetField : targetFields) {
            Class<?> targetClass = target.getClass();
            try {
                Field field = targetClass.getDeclaredField(targetField);
                String methodNamePrefix = field.getType().getName().equals("boolean") ? "is" : "get";
                String methodName = methodNamePrefix + String.valueOf(targetField.charAt(0)).toUpperCase()
                        + targetField.substring(1);
                Method targetMethod = targetClass.getMethod(methodName);
                Object invoke = targetMethod.invoke(target);
                objectMap.put(getNameOfElegant(targetField), invoke);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return objectMap;
    }

    private static String getNameOfElegant(String old) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : old.toCharArray()) {
            if (Character.isUpperCase(c) && stringBuilder.length() > 0) {
                stringBuilder.append("_");
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString().toLowerCase();
    }

    public static void main(String[] args) {
        // System.out.println(getNameOfElegant("AbcDef"));
        // System.out.println(getNameOfElegant("abcDefXlA"));

        ModelExample lisi = new ModelExample();
        lisi.setFirstName("李");
        lisi.setLastName("四");
        lisi.setGender(1);
        lisi.setRegisterTime(System.currentTimeMillis());

        ModelExample zhangsan = new ModelExample();
        zhangsan.setFirstName("张");
        zhangsan.setLastName("三");
        zhangsan.setGender(0);
        zhangsan.setRegisterTime(System.currentTimeMillis() - 86400000);

        // 从单个对象中提取
        Map<String, Object> lisiExtracted = AttributesExtractUtils.extract(lisi, "firstName", "lastName");
        System.out.println("lisiExtracted = " + lisiExtracted);

        // 从集合中提取
        List<ModelExample> users = new ArrayList<ModelExample>(Arrays.asList(lisi, zhangsan));
        List<Map<String, Object>> usersExtracted = AttributesExtractUtils
                .extractForCollection(users, "lastName", "registerTime");
        System.out.println("usersExtracted = " + usersExtracted);
    }

    private static class ModelExample {

        private String firstName;
        private String lastName;
        private int gender;
        private long registerTime;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public long getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(long registerTime) {
            this.registerTime = registerTime;
        }
    }
}
