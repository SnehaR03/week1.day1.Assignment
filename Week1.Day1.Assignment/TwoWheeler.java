package week1.day1;

public class TwoWheeler {
	int noOfWheels=2;
	short noOfMirrors=2;
	long chassisNumber=16475643449765L;
	boolean isPunctured=false;
	String bikeName="Pulsar150";
	double runningKM=1234.567;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoWheeler tw=new TwoWheeler();
		System.out.println("TwoWheeler Properties:");
		System.out.println("Wheels:"+tw.noOfWheels);
		System.out.println("Mirrors:"+tw.noOfMirrors);
		System.out.println("ChassisNumber:"+tw.chassisNumber);
		System.out.println("Punctured:"+tw.isPunctured);
		System.out.println("BikeName:"+tw.bikeName);
		System.out.println("Total KM covered:"+tw.runningKM);

	}

}
