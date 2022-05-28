package org.student;

import org.department.Department;

public class Student extends Department{
	public void studentName(String sName) {
		System.out.println("Student Name:"+sName);
	}
	public void studentDept() {
		System.out.println("Student Department: CSE");
	}
	public void studentId(int sID) {
		System.out.println("Student ID:"+sID);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student myStudent=new Student();
		myStudent.collegeName("KRCT");
		myStudent.collegeCode(6546);
		myStudent.collegeRank(95);
		myStudent.departmentName();
		myStudent.studentName("Surya");
		myStudent.studentDept();
		myStudent.studentId(101);
	}

}
