package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//div[@jsid='partyIdFromComboBoxStore']/following-sibling::a/img")).click();
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'col-partyId')]/a"));
		element.click();
        driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@jsid='partyIdToComboBoxStore']/following-sibling::a/img")).click();
		Set<String> windows2 = driver.getWindowHandles();
		List<String> win2=new ArrayList<String>(windows2);
		driver.switchTo().window(win2.get(1));
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'col-partyId')]/a/following::table/tbody/tr[1]/td[1]/div/a"));
		Thread.sleep(2000);
		element1.click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		driver.close();
		
		
		
		
	}

}
