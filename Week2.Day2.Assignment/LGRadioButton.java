package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGRadioButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/radio.html");
		//select the radio button
		driver.findElement(By.id("yes")).click();
		//driver.findElement(By.id("no")).click();
		Boolean value=driver.findElement(By.id("yes")).isSelected();
		System.out.println("Element Selected:" +value);
		//check the default selected-default selected radio button and print
		boolean dfault = driver.findElement(By.xpath("//label[contains(text(),'default selected')]/following-sibling::input[@checked]")).isSelected();
		System.out.println("Element checked by default:" +dfault);
		//select the unchecked radio button
		driver.findElement(By.xpath("//label[contains(text(),'default selected')]/following-sibling::input[@value=0]")).click();
		//check for the deafult selected again
		boolean selected = driver.findElement(By.xpath("//label[contains(text(),'default selected')]/following-sibling::input[@checked]")).isSelected();
		System.out.println("Element selected:" +selected);
		//check the default selected-age radio button and print
		boolean dfaultAge = driver.findElement(By.xpath("//label[contains(text(),'age')]/following-sibling::input[@checked]")).isSelected();
		System.out.println("Element checked by default:" +dfaultAge);
		//click or select the other radio button
		driver.findElement(By.xpath("//label[contains(text(),'age')]/following-sibling::input[@value=2]")).click();
		driver.navigate().refresh();
		//verify the value age 40 is selected 
		Boolean age=driver.findElement(By.xpath("//label[contains(text(),'age')]/following-sibling::input[@value=2]")).isSelected();
		System.out.println("Age selected:"+age);
		driver.close();

	}

	

}
