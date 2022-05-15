

package week2.day2;

public class CalculatorFunc {
	public double add(int num1,int num2,int num3) {
		return num1+num2+num3;
		 
	}
public double subraction(int num1,int num2) {
	return num1-num2;
		 
	}
public double multiply(double num1,double num2) {
	return num1*num2;
		
	}
public float division(float num1,float num2) {
	return num1/num2;
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorFunc calc1=new CalculatorFunc();
		System.out.println("Calculator Functions");
		System.out.println("Sum of 3 numbers:"+calc1.add(48,75,65));
		System.out.println("Difference b/w numbers:"+calc1.subraction(35,12));
		System.out.println("Multiplication:"+calc1.multiply(123.25, 96.615));
		System.out.println("Divided by value"+calc1.division(35.65F, 5.24F));
		

	}
}
