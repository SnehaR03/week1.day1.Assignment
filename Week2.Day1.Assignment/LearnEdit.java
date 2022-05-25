package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnEdit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Edit.html");
		//enter email
		driver.findElement(By.id("email")).sendKeys("sneha.renganathan03@gmail.com");
		//append text ad press tab
		WebElement enterText = driver.findElement(By.xpath("//input[@value='Append ']"));
		enterText.sendKeys("TextValue");
		enterText.sendKeys(Keys.TAB);

		//get the default text available
		System.out.println("Dfault text:"+driver.findElement(By.xpath("//label[contains(text(),'default text')]/following-sibling::input[@name='username']")).getAttribute("value"));
		//clear text
		driver.findElement(By.xpath("//label[contains(text(),'Clear')]/following-sibling::input[@name='username']")).clear();
		//verify isdisabled
		System.out.println("IsDisabled:"+driver.findElement(By.xpath("//label[contains(text(),'disabled')]/following-sibling::input")).isDisplayed());
	    driver.close();
	}

}
