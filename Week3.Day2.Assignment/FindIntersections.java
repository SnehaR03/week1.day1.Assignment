

package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindIntersections {

	public static void main(String[] args) {
		//a) Declare An array for {3,2,11,4,6,7};	 
		List<Integer> array1= new ArrayList<Integer>();
		Collections.addAll(array1,3,2,11,4,6,7);
		// b) Declare another array for {1,2,8,4,9,7};
		List<Integer> array2= new ArrayList<Integer>();
		Collections.addAll(array2,1,2,8,4,9,7);
		//c) Declare for loop iterator from 0 to array length
		for (int i = 0; i < array1.size(); i++) {
			// * d) Declare a nested for another array from 0 to array length
			for (int j = 0; j < array2.size(); j++) {
				//* e) Compare Both the arrays using a condition statement
				if(array1.get(i).equals(array2.get(j))) {
					//*  f) Print the first array (shoud match item in both arrays)
					System.out.print(array1.get(i)+",");
					
				}
			}
		}
	}


}


