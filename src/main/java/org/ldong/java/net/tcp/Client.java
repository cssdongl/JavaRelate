package org.ldong.java.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8888);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = br.readLine();
		System.out.println(msg);
	}
}