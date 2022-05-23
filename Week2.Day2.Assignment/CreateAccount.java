package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sneha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("R");
		driver.findElement(By.xpath("//input[@name='reg_email__' ]")).sendKeys("9978979480");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Sneha@0308");
		Select date=new Select(driver.findElement(By.xpath("//select[@id='day']")));
		date.selectByVisibleText("3");
		Select month=new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month.selectByVisibleText("Jun");
		Select year=new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year.selectByVisibleText("1992");
		driver.findElement(By.xpath("//label[@class='_58mt' and text()='Female']/following-sibling::input[@name='sex']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit' and text()='Sign Up']")).click();
		Thread.sleep(2000);
		System.out.println("Account ccreated");
		driver.close();
		
		

	}

}
