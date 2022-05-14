package week1.day1;

public class Car {
 public void applyBrake() {
	 System.out.println("Applied CarBrake");
	
}
 public void applyGear() {
	 System.out.println("Changed CarGear");
}
 public void switchOnAC() {
	 System.out.println("Turned on AC");
}
 public void applyAccelerate() {
	 System.out.println("Applied Accelerate-Car SpeededUp");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Actions on Car");
        Car myCar=new Car();
        myCar.applyBrake();
        myCar.applyGear();
        myCar.switchOnAC();
        myCar.applyAccelerate();
	}

}
