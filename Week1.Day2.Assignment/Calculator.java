package week2.day2;

public class Calculator {
	public double add(int num1,int num2) {
		int sum=num1+num2;
		return sum;
	}
public double subraction(double num1,double num2) {
	double sub=num1-num2;
		return sub;
	}
public double multiply(double num1,double num2) {
	double mul=num1*num2;
		return mul;
	}
public int division(int num1,int num2) {
	int div=num1/num2;
		return div;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc=new Calculator();
		System.out.println("Calculator Functions");
		System.out.println(calc.add(15, 45));
		System.out.println(calc.subraction(35.25, 24.65));
		System.out.println(calc.multiply(13.25, 76.615));
		System.out.println(calc.division(35, 5));

	}

}
