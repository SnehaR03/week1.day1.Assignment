package week3.day2;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int[] num = {4,6,7,2,3,1,9,10,8,8,6,2};
		// 1) Remove the duplicates using Set
	    Set<Integer> numbers=new TreeSet<Integer>();
	    for(int i=0;i<num.length;i++) {
	    numbers.add(num[i]);	
	    }
	    
	    for(Integer missingNumber:numbers)
	    {
		if(!(missingNumber==missingNumber+1)) {
			System.out.println(missingNumber);
		}
		

	}

}
}
