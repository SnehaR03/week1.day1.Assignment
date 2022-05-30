package week3.day2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrintDuplicatesInArrayList {

	public static void main(String[] args) {
		List<Integer> numbers= new ArrayList<Integer>();
		Collections.addAll(numbers,14,12,13,11,15,14,18,16,17,19,18,17,20);
		// get the length of the array
		int size = numbers.size();
		// declare an int variable named count

		// iterate from 0 to the array length-1 (outer loop starts here)
		for (int i = 0; i < size-1; i++) {


			//iterate from i to the length of the array by adding 1 to it (inner loop starts here)
			for (int j = i+1; j < numbers.size(); j++) {
				// compare both the loop variables & check they're equal
				if(numbers.get(i).equals(numbers.get(j))) {

					System.out.println(numbers.get(i));
				}
			}
		}
	}
}
