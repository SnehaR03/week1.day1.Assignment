package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	//create new contact-click on contacts
	driver.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();
	driver.findElement(By.linkText("Create Contact")).click();
	//enter mandatory details
	driver.findElement(By.id("firstNameField")).sendKeys("Harsha");
	driver.findElement(By.id("lastNameField")).sendKeys("Vardhan");
	driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Bobby");
	driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Venku");
	driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("IT");
	driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("Create contact Info");
	driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("harshajun4@gmail.com");
	//drop down
	Select state=new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
	state.selectByVisibleText("New York");
	driver.findElement(By.xpath("//input[@class='smallSubmit' and @name='submitButton']")).click();
	//edit the contact
	driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
	//clear and update value
	driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
	driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("Lead-contact info");
	driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
	System.out.println("Contact Title: "+driver.getTitle());
	driver.close();

		
		
		
	}

}
