package org.ldong.java.datastructure.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//二个数组中相同的元素
public class RemoveRepeatElement {
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5};
		
		int[] b = new int[]{3,4,5,6,7};
		
		Set<Integer> tempSet = new HashSet<Integer>();
		
		for(int numberFromA : a){
			tempSet.add(numberFromA);
		}
		
		Set<Integer> sameElementSet = new HashSet<Integer>();
		for(int numberFromB : b){
			if(!tempSet.add(numberFromB)){
				sameElementSet.add(numberFromB);
				
			}
			
		}
		
		Iterator<Integer> t = sameElementSet.iterator();
	
		
		while(t.hasNext()){
			Integer elment = (Integer) t.next();
			System.out.println(elment);
		}
		
		
	}
}
