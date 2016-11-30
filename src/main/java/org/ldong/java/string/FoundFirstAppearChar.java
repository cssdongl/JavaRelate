package org.ldong.java.string;

public class FoundFirstAppearChar {
	public static void main(String[] args){
		String str = "bbaacde";
		int[] b = new int[]{2,3};
		b[1]++;
		for(int c : b){
			System.out.println(c);
		}
//		foundFirstAppearChar(str);
		int[] hashArray = new int[256];
		for(int i=0;i<hashArray.length;i++){
			hashArray[i] = 0;
		}
		
		for(int i=0;i<str.length();i++){
			hashArray[str.charAt(i)]++;
		}
		
		for(int i=0;i<str.length();i++){
			if(hashArray[str.charAt(i)] == 1){
				System.out.println("the first character which only exist one is "+str.charAt(i));
			}
		}

	}
	private void foundFirstCharacter(String str){
		for(int i=0;i<str.length();i++){
			char currentChar = str.charAt(i);
			boolean foundRepeat = false;
			for(int j=0;j<str.length();j++){
				if(i == j){
					continue;
				}
				char otherChar = str.charAt(j);
				if(otherChar == currentChar){
					foundRepeat = true;
					break;
				}
			}
			if(!foundRepeat){
				System.out.println("the first character which only exist one is "+currentChar);
				break;
			}
		}
	}
}
