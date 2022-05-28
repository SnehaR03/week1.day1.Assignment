package week3.day1;

public class Students {
public void getStudentInfo() {
	System.out.println("Get Students Info");
}
public void getStudentInfo(int sID) {
	System.out.println("1 argument-StudentID:"+sID);
}
public void getStudentInfo(int sID,String name) {
	System.out.println("2 argument-StudentID:"+sID);
	System.out.println("2 argument-Student Name:"+name);
}
public void getStudentInfo(String email,long phoneNo) {
	System.out.println("2 argument-Student Email:"+email);
	System.out.println("2 argument-Student PhoneNumber:"+phoneNo);
}

	public static void main(String[] args) {
		Students sDetails=new Students();
		sDetails.getStudentInfo();
		sDetails.getStudentInfo(104);
		sDetails.getStudentInfo(103, "Harsha");
		sDetails.getStudentInfo("harshajune4@gmail.com",9984848651L);
		

	}

}
