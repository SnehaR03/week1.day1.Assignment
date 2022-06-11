package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException
		  {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			// Loads a new web page in the current browser window
			// Maximise the screen
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//load URL
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			//get heading and print
			System.out.println(driver.findElement(By.tagName("h1")).getText());
			String text = driver.findElement(By.xpath("//label/span[contains(text(),'Topic')]")).getText();
			System.out.println(text);
			//switch frame and enter text to topic field
			driver.switchTo().frame("frame1");
			driver.findElement(By.xpath("//body/b[@id='topic']/following-sibling::input")).sendKeys(text);
			//switch to innerframe select check box
			driver.switchTo().frame("frame3");
			System.out.println(driver.findElement(By.xpath("//body/b[contains(text(),'Check box')]")).getText());
			driver.findElement(By.id("a")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame2");
			//select dropdown
			WebElement dropdown = driver.findElement(By.id("animals"));
			Select animals=new Select(dropdown);
			animals.selectByVisibleText("Big Baby Cat");
			//come out all frames
			driver.switchTo().defaultContent();
			String heading = driver.findElement(By.tagName("h1")).getText();
		    System.out.println(heading);
		    driver.close();
			
	}

}
