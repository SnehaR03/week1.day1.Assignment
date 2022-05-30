package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Here is the input
		List<Integer> data= new ArrayList<Integer>();
		Collections.addAll(data, 3,2,11,4,6,7);
       // 1) Arrange the array in ascending order
		Collections.sort(data);
		System.out.println("second largest"+data.get(data.size()-2));
		 //2) Pick the 2nd element from the last and print it
		 
		
	}

}
