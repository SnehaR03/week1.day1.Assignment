package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//setup chrome driver
		WebDriverManager.chromedriver().setup();
       //open the browser
		ChromeDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//load the URL
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("tcs");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sneha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Renganathan");
		WebElement source=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdown=new Select(source);
		dropdown.selectByIndex(2);
		Thread.sleep(2000);
        driver.findElement(By.className("smallSubmit")).click();
		//to close browser
        String title = driver.getTitle();
        System.out.println("Title of CreateLead: "+title);
        driver.close();
        

	}

}
