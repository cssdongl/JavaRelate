package org.ldong.java.net.udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket client = new DatagramSocket(6666);
		
//		int data = 87;
		
//		DataInputStream ds = new DataInputStream(new )
		
		String msg = "helo,dongruining";
		
		DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,InetAddress.getLocalHost(),8888);
		
		client.send(dp);
		
		client.close();
	}
	public byte[] convert(double num){
		
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bis);
		try {
			dos.writeDouble(num);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return bis.toByteArray();
	}
}
