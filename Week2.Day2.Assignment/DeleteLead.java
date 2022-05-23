package week2.day1;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//div[@id=\"label\"]/a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		//find lead by providing phone number
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9955184848");
		driver.findElement(By.xpath("//button[@class='x-btn-text' and text()='Find Leads']")).click(); 
		Thread.sleep(2000);
		//get the first resulting LeadID
		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'col-partyId')]/a"));
		String LeadID = element.getText();
		element.click();
		//delete lead
		driver.findElement(By.linkText("Delete")).click();
		//confirm lead is deleted
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(LeadID);
		driver.findElement(By.xpath("//button[@class='x-btn-text' and text()='Find Leads']")).click();
		//verify no result found message displayed
		WebElement msg = driver.findElement(By.xpath("//div[@class='x-paging-info' and contains(text(),'No')]"));
		String text = msg.getText();

		System.out.println("Deleted:"+text); 
		//create the lead again
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("tcs");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sneha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Renganathan");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9955184848");
		driver.findElement(By.className("smallSubmit")).click();
		//to close browser
        String title = driver.getTitle();
        System.out.println("Title of CreateLead: "+title);
		driver.close();

	}





	/*
	 * java.util.List<WebElement> elements =
	 * driver.findElements(By.xpath("//table[@class='x-grid3-row-table']/tbody"));
	 * for (WebElement rowElem : elements) { java.util.List<WebElement> cells =
	 * rowElem.findElements(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr")
	 * );
	 * 
	 * //String LeadID=cells.get(0).findElement(By.tagName("a")).getText();
	 * cells.get(0).findElement(By.tagName("a")).click(); //
	 * System.out.println(LeadID); }
	 */


	//driver.findElement(By.xpath("//div[contains(@class,'formatedPrimaryPhone') and contains(text(),'9955184848')] /preceding::div[contains(@class,'col-partyId')]/a")).click(); 


}
