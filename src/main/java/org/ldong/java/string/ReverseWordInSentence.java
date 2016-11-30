package org.ldong.java.string;

import java.util.Stack;

public class ReverseWordInSentence {
	public static void main(String[] args){
		String sentence = "hello i am a serious man";
		
		Stack<String> stack = new Stack<String>();
		StringBuffer subWorld = new StringBuffer();
		for(int i=0;i < sentence.length();i++){
			
			
			char charater = sentence.charAt(i);
			if(charater == ' '){
				if(subWorld.toString().length() > 0){
					stack.push(subWorld.toString());
					subWorld.delete(0, subWorld.length());
				}
				continue;
			}else{
				subWorld.append(charater);
			}
		}
		StringBuffer reverseString = new StringBuffer();
		while(!stack.isEmpty()){
			String subString = stack.pop();
			reverseString.append(subString);
			reverseString.append(" ");
		}
		System.out.println(reverseString.toString());
	}
}
