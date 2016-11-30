package org.ldong.java.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTasker {
	public static void main(String[] args){
		new Timer().scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				System.out.println("Bombing");
				
			}
			
		}, 10,1000);
	}
}
