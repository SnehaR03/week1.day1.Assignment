package week1.day1;

public class Mobile {
	public void makeCall() {
		System.out.println("Call connected");
	}
	public void sendMessage() {
		System.out.println("Message Sent");
		System.out.println(2+3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Mobile myMobile=new Mobile();
myMobile.makeCall();
myMobile.sendMessage();
	}

}
