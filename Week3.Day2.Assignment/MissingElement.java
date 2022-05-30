package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElement {

	public static void main(String[] args) {
		// Here is the input

		List<Integer> arr= new ArrayList<Integer>();
		Collections.addAll(arr, 1,2,3,4,7,6,8);
		// Sort the array	
		Collections.sort(arr);
        // loop through the array (start i from arr[0] till the length of the array)
		for (int i = 1; i < arr.size()-1; i++) {
		// check if the iterator variable is not equal to the array values respectively
			if(!arr.contains(i)) {

				System.out.println("Missing Element-"+i);
				break;
			}

		}
 }

}
