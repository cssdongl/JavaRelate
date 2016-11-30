package org.ldong.java.kafka;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: InteractiveHelper.java
 * @Copyright: Copyright (c) 2015
 * @Description: <br>
 *               <br>
 * @Company: jj.com
 * @Created on 2016年9月20日 下午2:21:15
 * @author dongliang
 */
public class InteractiveHelper {
	private static List<String> deviceidList = new ArrayList<String>();
	private static List<String> clientipList = new ArrayList<String>();
	private static List<String> operatorList = new ArrayList<String>();
	private static List<String> areaList = new ArrayList<String>();
	private static List<String> deviceList = new ArrayList<String>();
	private static List<String> osVersionList = new ArrayList<String>();
	private static List<String> networkList = new ArrayList<String>();
	private static List<String> viewList = new ArrayList<String>();

	static {
		for (int i = 0; i < 100; i++) {
			deviceidList.add("xxxxxxxxxxxxxxxxxxx" + i);
		}

		for (int i = 10; i < 250; i++) {
			clientipList.add("124.192.141." + i);
		}

		operatorList.add("China Union");
		operatorList.add("China Mobile");

		networkList.add("3g");
		networkList.add("wifi");
		networkList.add("4g");

		areaList.add("China,Beijing,Beijing");
		areaList.add("China,Shanxi,Xian");
		areaList.add("China,Henan,Zhengzhou");

		deviceList.add("LENOVO,Lenovo,LENOVO Lenovo A516");
		deviceList.add("HUAWEI,Huawei,HUAWEI Huawei 920");
		deviceList.add("XIAOMI,Hongmi,XIAOMI Hongmi 2");

		osVersionList.add("6.0");
		osVersionList.add("7.0");

		viewList.add("mainView#loading");
		viewList.add("subView#loading");
	}

	public String getDeviceid() {
		Integer index = (int) (Math.random() * deviceidList.size());
		return deviceidList.get(index);
	}

	public String getClientip() {
		Integer index = (int) (Math.random() * clientipList.size());
		return clientipList.get(index);
	}

	public String getOperator() {
		Integer index = (int) (Math.random() * operatorList.size());
		return operatorList.get(index);
	}

	public String getArea() {
		Integer index = (int) (Math.random() * areaList.size());
		return areaList.get(index);
	}

	public String getDevice() {
		Integer index = (int) (Math.random() * deviceList.size());
		return deviceList.get(index);
	}

	public String getNetwork() {
		Integer index = (int) (Math.random() * networkList.size());
		return networkList.get(index);
	}

	public String getOsVersion() {
		Integer index = (int) (Math.random() * osVersionList.size());
		return osVersionList.get(index);
	}

	public String getView() {
		Integer index = (int) (Math.random() * viewList.size());
		return viewList.get(index);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Integer index = (int) (Math.random() * areaList.size());
			System.out.println(index);
		}
	}

}
