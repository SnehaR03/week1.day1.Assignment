package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class PrintOnlyUniqueCharacters {

	public static void main(String[] args) {
		String input = "babu";
		//1) Convert String to Character array
		char[] charArray = input.toCharArray();
		//2) Create a new Set -> HashSet
		Set<Character> unique=new HashSet<Character>();
		//3) Add each character to the Set and if it is already there, remove it
		for(int i=0;i<charArray.length;i++) {
			int flag=0;
			for(int j=0;j<charArray.length;j++) {
				if((charArray[i]==charArray[j])){
					flag=flag+1;
				}
				if(flag==0) {
					unique.add(charArray[i]);
							}
			}
		}System.out.println(unique);
		
		
		//4) Finally, print the set
			 

	}

}
