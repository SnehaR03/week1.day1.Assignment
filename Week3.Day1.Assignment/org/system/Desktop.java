package org.system;

public class Desktop extends Computer {
	public void desktopSize() {
		System.out.println("Screen size-18inches");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Desktop mySystem=new Desktop();
     mySystem.computerModel();
     mySystem.desktopSize();
	}

}
