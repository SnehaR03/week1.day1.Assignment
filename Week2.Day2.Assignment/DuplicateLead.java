package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/control/login");
			//login
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			driver.findElement(By.xpath("//div[@id=\"label\"]/a[contains(text(),'CRM/SFA')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//span[@class='x-tab-strip-text ' and text()='Email']")).click();
			//search lead by email
			driver.findElement(By.name("emailAddress")).sendKeys("harshajune4@gmail.com");
			driver.findElement(By.xpath("//button[@class='x-btn-text' and text()='Find Leads']")).click(); 
			Thread.sleep(2000);
			//get the name of first resulting lead
		    WebElement element = driver.findElement(By.xpath("//div[contains(@class,'col-firstName')]/a"));
			String leadName = element.getText();
			System.out.println(leadName);
			element.click();
			//duplicate lead and get title
			driver.findElement(By.linkText("Duplicate Lead")).click();
			System.out.println("Title: "+driver.getTitle());
			driver.findElement(By.className("smallSubmit")).click();
			Thread.sleep(3000);
			//confirm the duplicate name is same as captured name
			String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			if(leadName.equals(text)) {
			
			System.out.println("Duplicate Lead successfull "+text);
            

	}
			else
			{
				System.out.println("Failed");
			}
			driver.close();

}}
