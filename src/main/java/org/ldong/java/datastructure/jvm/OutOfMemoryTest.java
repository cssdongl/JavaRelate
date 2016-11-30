package org.ldong.java.datastructure.jvm;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryTest {
	public static void main(String[] args){
		List<OutOfMemoryTest> objectList = new ArrayList<OutOfMemoryTest>();

		while(true){
			objectList.add(new OutOfMemoryTest());
			
		}
	}
}
