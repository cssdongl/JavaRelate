package org.ldong.java.kafka;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import org.ldong.java.kafka.InteractiveData.CpuInfo;
import org.ldong.java.kafka.InteractiveData.MainThread;
import org.ldong.java.kafka.InteractiveData.MemoryInfo;
import org.ldong.java.kafka.InteractiveData.Method;
import org.ldong.java.kafka.InteractiveData.NetworkReq;
import org.ldong.java.kafka.InteractiveData.WorkThread;
import org.ldong.java.util.TimeUtil;

import net.sf.json.JSONObject;

/**
 * @Title: NetworkDataCreator.java
 * @Copyright: Copyright (c) 2015
 * @Description: <br>
 *               生成network的网络数据 <br>
 * @Created on 2016年9月20日 下午2:11:43
 */
public class InteractiveDataCreator {
	private static final String startTime = "2016-10-10 00:00:00";
	private static InteractiveData interactive = null;

	static {
		interactive = initInteractive();
	}

	public static InteractiveData initInteractive() {
		String jsonModel = null;
		try {
			jsonModel = FileUtils
					.readFileToString(new File("D:\\testData\\input\\interactive_data_templateFormat.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// jsonModel = "[" + jsonModel + "]";
		// GsonUtil.parseJsonWithGson(jsonModel, InteractiveData.class);
		// List<InteractiveData> results =
		// GsonUtil.parseJsonArrayWithGson(jsonModel, InteractiveData.class);

		// InteractiveData x = results.get(0);
		JSONObject jsonObj = JSONObject.fromObject(jsonModel);

		@SuppressWarnings("rawtypes")
		Map<String, Class> classMap = new HashMap<String, Class>();

		classMap.put("meminfo", MemoryInfo.class);

		classMap.put("cpuinfo", CpuInfo.class);

		classMap.put("networkreq", NetworkReq.class);

		classMap.put("mainthread", MainThread.class);

		classMap.put("workthread", WorkThread.class);

		classMap.put("method", Method.class);

		interactive = (InteractiveData) JSONObject.toBean(jsonObj, InteractiveData.class, classMap);

		List<MemoryInfo> memoryList = interactive.getMeminfo();

		List<MainThread> mainThreadsList = interactive.getMainthread();

		for (MemoryInfo meminfo : memoryList) {
			System.out.println(meminfo.getMemory());
		}

		for (MainThread mainThread : mainThreadsList) {
			List<Method> methods = mainThread.getMethod();
			for(Method method :methods){
				System.out.println(method.getFrontorback());
			}
		}

		return interactive;
	}

	public static void main(String[] args) throws IOException {
		List<String> jsonList = new ArrayList<String>();
		for (int i = 0; i < 1440 * 3; i++) {
			String time = TimeUtil.getCommonMinute(startTime, null, i);
			String json = null;

			Integer top = 15 + (int) (Math.random() * 5);

			for (int j = 0; j < top; j++) {
				json = createInitInteractiveJson(time);
				jsonList.add(json);
			}
			interactive = initInteractive();
		}

		// FileUtils.writeLines(new
		// File("D:\\testData\\output\\interactive_all.txt"), jsonList);

	}

	/**
	 * @param time
	 * @param j
	 * @return : network data json串
	 */
	private static String createInitInteractiveJson(String time) {
		InteractiveData interactiveData = interactive;
		// 设置时间
		interactiveData.setTime(time);

		/**
		 * deviceid,clientip,network,operator
		 */
		InteractiveHelper helper = new InteractiveHelper();
		interactiveData.setDeviceid(helper.getDeviceid());
		interactiveData.setClientip(helper.getClientip());
		interactiveData.setNetwork(helper.getNetwork());
		interactiveData.setOperator(helper.getOperator());

		/**
		 * area , device
		 */
		String[] areas = helper.getArea().split(",");
		String[] devices = helper.getDevice().split(",");

		interactiveData.setCounty(areas[0]);
		interactiveData.setRegion(areas[1]);
		interactiveData.setCity(areas[2]);

		interactiveData.setDevicefactory(devices[0]);
		interactiveData.setDevicebrand(devices[1]);
		interactiveData.setDevicename(devices[2]);
		/**
		 * osversion,view
		 */
		interactiveData.setOsversion(helper.getOsVersion());
		interactiveData.setView(helper.getView());

		JSONObject jsonObj = JSONObject.fromObject(interactiveData);
		return jsonObj.toString();
	}

}
