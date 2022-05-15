package week2.day2;

public class ArmstrongNumber {


	public static void main(String[] args) {
// Declare your input
		int input=153,calculated=0,remainder;
		int original=input;
// Declare 3 more int variables as calculated, remainder, original (Tip: Initialize calculated alone)
// Assign input into variable original 
        while(input>0) {
			remainder=input%10;
			input=input/10;
			calculated+=Math.pow(remainder,3);
			//calculated=calculated+(remainder*remainder*remainder);
		}
		if(calculated==original) {
			System.out.println(original+" Armstrong Number");
		}
		else
		{
			System.out.println(original+" Not Armstrong Number");
		}



		// Use loop to calculate: use while loop to set condition until the number greater than 0



		// Within loop: get the remainder when done by 10 (Tip: Use Mod operator)



		// Within loop: get the quotient when done by 10 (Tip: Assign the result to input)



		// Within loop: Add calculated with the cube of remainder & assign it to calculated




		// Check whether calculated and original are same



		//When it matches print it as Armstrong number
















	}




}


