package org.ldong.java.kafka;

import java.util.List;

/**
 * @Title: InteractiveData.java
 * @Copyright: Copyright (c) 2015
 * @Description: 交互数据 json model<br>
 *               <br>
 * @Company: jj.com
 */
public class InteractiveData {
	private String deviceid;
	private String appname;
	private String apppackage;
	private String appver;
	private String os;
	private String osversion;
	private String sysversion;
	private String devicefactory;
	private String devicebrand;
	private String devicename;
	private String resolution;
	private String clientip;
	private String county;
	private String region;
	private String city;
	private String network;
	private String operator;
	private String time;
	private String view;
	private int durationtime;
	private List<MemoryInfo> meminfo;
	private List<CpuInfo> cpuinfo;
	private List<NetworkReq> networkreq;
	private List<MainThread> mainthread;
	private List<WorkThread> workthread;

	// public InteractiveData(String deviceid, String appname, String
	// apppackage, String appver, String os,
	// String osversion, String sysversion, String devicefactory, String
	// devicebrand, String devicename,
	// String sdkversion, String resolution, String clientip, String county,
	// String region, String city,
	// String network, String operator, String time, String reqtype, String url,
	// String serverip, String reserror,
	// String rescode, int restime, int tcptime, int dnstime, int ssltime, int
	// firsttime, int dataquantity,
	// int datetime) {
	// super();
	// this.deviceid = deviceid;
	// this.appname = appname;
	// this.apppackage = apppackage;
	// this.appver = appver;
	// this.os = os;
	// this.osversion = osversion;
	// this.sysversion = sysversion;
	// this.devicefactory = devicefactory;
	// this.devicebrand = devicebrand;
	// this.devicename = devicename;
	// this.resolution = resolution;
	// this.clientip = clientip;
	// this.county = county;
	// this.region = region;
	// this.city = city;
	// this.network = network;
	// this.operator = operator;
	// this.time = time;
	// }
	//
	// public InteractiveData() {
	// super();
	// }

	public static class MemoryInfo {
		private int memory;
		private int starttime;
		private int durationtime;

		public int getMemory() {
			return memory;
		}

		public void setMemory(int memory) {
			this.memory = memory;
		}

		public int getStarttime() {
			return starttime;
		}

		public void setStarttime(int starttime) {
			this.starttime = starttime;
		}

		public int getDurationtime() {
			return durationtime;
		}

		public void setDurationtime(int durationtime) {
			this.durationtime = durationtime;
		}

	}

	public static class CpuInfo {
		private int cpu;
		private int starttime;
		private int durationtime;

		public int getCpu() {
			return cpu;
		}

		public void setCpu(int cpu) {
			this.cpu = cpu;
		}

		public int getStarttime() {
			return starttime;
		}

		public void setStarttime(int starttime) {
			this.starttime = starttime;
		}

		public int getDurationtime() {
			return durationtime;
		}

		public void setDurationtime(int durationtime) {
			this.durationtime = durationtime;
		}

	}

	public static class NetworkReq {
		private String url;
		private int processingtime;
		private int datacount;
		private int rescode;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getProcessingtime() {
			return processingtime;
		}

		public void setProcessingtime(int processingtime) {
			this.processingtime = processingtime;
		}

		public int getDatacount() {
			return datacount;
		}

		public void setDatacount(int datacount) {
			this.datacount = datacount;
		}

		public int getRescode() {
			return rescode;
		}

		public void setRescode(int rescode) {
			this.rescode = rescode;
		}
	}

	public static class MainThread {
		private String threadname;
		private int starttime;
		private int processingtime;
		private List<Method> method;

		public String getThreadname() {
			return threadname;
		}

		public void setThreadname(String threadname) {
			this.threadname = threadname;
		}

		public int getStarttime() {
			return starttime;
		}

		public void setStarttime(int starttime) {
			this.starttime = starttime;
		}

		public int getProcessingtime() {
			return processingtime;
		}

		public void setProcessingtime(int processingtime) {
			this.processingtime = processingtime;
		}

		public List<Method> getMethod() {
			return method;
		}

		public void setMethod(List<Method> method) {
			this.method = method;
		}

	}

	public static class WorkThread {
		private String threadname;
		private int starttime;
		private int processingtime;
		private List<Method> method;

		public String getThreadname() {
			return threadname;
		}

		public void setThreadname(String threadname) {
			this.threadname = threadname;
		}

		public int getStarttime() {
			return starttime;
		}

		public void setStarttime(int starttime) {
			this.starttime = starttime;
		}

		public int getProcessingtime() {
			return processingtime;
		}

		public void setProcessingtime(int processingtime) {
			this.processingtime = processingtime;
		}

		public List<Method> getMethod() {
			return method;
		}

		public void setMethod(List<Method> method) {
			this.method = method;
		}

	}

	public static class Method {
		private String frontorback;
		private String performance;
		private String methodname;
		private int starttime;
		private int processingtime;

		public String getFrontorback() {
			return frontorback;
		}

		public void setFrontorback(String frontorback) {
			this.frontorback = frontorback;
		}

		public String getPerformance() {
			return performance;
		}

		public void setPerformance(String performance) {
			this.performance = performance;
		}

		public String getMethodname() {
			return methodname;
		}

		public void setMethodname(String methodname) {
			this.methodname = methodname;
		}

		public int getStarttime() {
			return starttime;
		}

		public void setStarttime(int starttime) {
			this.starttime = starttime;
		}

		public int getProcessingtime() {
			return processingtime;
		}

		public void setProcessingtime(int processingtime) {
			this.processingtime = processingtime;
		}

	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getApppackage() {
		return apppackage;
	}

	public void setApppackage(String apppackage) {
		this.apppackage = apppackage;
	}

	public String getAppver() {
		return appver;
	}

	public void setAppver(String appver) {
		this.appver = appver;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsversion() {
		return osversion;
	}

	public void setOsversion(String osversion) {
		this.osversion = osversion;
	}

	public String getSysversion() {
		return sysversion;
	}

	public void setSysversion(String sysversion) {
		this.sysversion = sysversion;
	}

	public String getDevicefactory() {
		return devicefactory;
	}

	public void setDevicefactory(String devicefactory) {
		this.devicefactory = devicefactory;
	}

	public String getDevicebrand() {
		return devicebrand;
	}

	public void setDevicebrand(String devicebrand) {
		this.devicebrand = devicebrand;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public int getDurationtime() {
		return durationtime;
	}

	public void setDurationtime(int durationtime) {
		this.durationtime = durationtime;
	}

	public List<MemoryInfo> getMeminfo() {
		return meminfo;
	}

	public void setMeminfo(List<MemoryInfo> meminfo) {
		this.meminfo = meminfo;
	}

	public List<CpuInfo> getCpuinfo() {
		return cpuinfo;
	}

	public void setCpuinfo(List<CpuInfo> cpuinfo) {
		this.cpuinfo = cpuinfo;
	}

	public List<NetworkReq> getNetworkreq() {
		return networkreq;
	}

	public void setNetworkreq(List<NetworkReq> networkreq) {
		this.networkreq = networkreq;
	}

	public List<MainThread> getMainthread() {
		return mainthread;
	}

	public void setMainthread(List<MainThread> mainthread) {
		this.mainthread = mainthread;
	}

	public List<WorkThread> getWorkthread() {
		return workthread;
	}

	public void setWorkthread(List<WorkThread> workthread) {
		this.workthread = workthread;
	}

}
