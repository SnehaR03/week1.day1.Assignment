package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//login
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		//find leads
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//div[contains(@class,'x-panel-body-noheader')]//input[ @name='firstName' and contains(@class,'x-form-text')]")).sendKeys("Sneha");
		driver.findElement(By.xpath("//button[@class='x-btn-text' and text()='Find Leads']")).click(); 
		Thread.sleep(2000);
		//get the name of first resulting lead
	    WebElement element = driver.findElement(By.xpath("//div[contains(@class,'col-firstName')]/a"));
	    element.click();
		Thread.sleep(2000);
		//update the details
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("IBM");
		driver.findElement(By.className("smallSubmit")).click();
		//verify details updated for lead
		 WebElement cName = driver.findElement(By.id("viewLead_companyName_sp"));
		String text=cName.getText();
		if(text.contains("IBM")) {
		
		System.out.println("Updated Successfully "+text);
        }
		else
		{
			System.out.println("Failed");
		}
		driver.close();
	}

}
