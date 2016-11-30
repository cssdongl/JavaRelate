package org.ldong.java.thread;

import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer>{
	private String name;
	private int time;//延时时间
	private boolean flag = true;
	private int step= 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public MyCall(String name){
		super();
		this.name = name;
	}
	public MyCall(String name,int time){
		
		super();
		this.name = name;
		this.time = time;
	}

	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(time);
			step++;
		}
		return step;
	}

}
