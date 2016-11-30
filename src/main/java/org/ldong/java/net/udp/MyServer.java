package org.ldong.java.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(8888);
		byte[] container = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(container, container.length);
		
		ds.receive(dp);
		
		byte[] data = dp.getData();
		
		System.out.println(new String(data,0,data.length));
	}
}
