package week3.day2;
//class extens abstract class and implements multiple interface
public class Automation extends MultipleLanguage implements Language,TestTool{

	public static void main(String[] args) {
		Automation test=new Automation();
		test.Java();
		test.Selenium();
		test.python();
		test.ruby();
	}
//implementation of unimplemednted method
	public void Selenium() {
		System.out.println("Selenium-Open source tool");
		
	}

	public void Java() {
		System.out.println("Java-object oriented programming language");
		
		
	}
//method override the super class unimplemented abstract method
	@Override
	public void ruby() {
		System.out.println("Ruby");
		
	}

}
