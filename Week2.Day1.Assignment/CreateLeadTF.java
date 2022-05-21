package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadTF {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("tcs");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sneha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Renganathan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Surya");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test Analyst");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ssneharenganathaan@gmail.com");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state=new Select(dropdown);
		state.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		//to close browser
        
        //WebElement title=driver.findElement(By.id("sectionHeaderTitle_leads"));
		String title = driver.getTitle();
        System.out.println("Title of CreateLead: "+title);
        driver.close();

}
}