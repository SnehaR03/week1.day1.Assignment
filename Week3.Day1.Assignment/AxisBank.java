package week3.day1;

public class AxisBank extends Banking {
	public void deposit() {
		System.out.println("Amount deposited to-Axis Bank account");
	}

	public static void main(String[] args) {
	 AxisBank myBank=new AxisBank();
	 myBank.saving();
	 myBank.fixed();
	 myBank.deposit();
	 

	}

}
