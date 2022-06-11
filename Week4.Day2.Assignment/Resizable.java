package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//load URL
		driver.get("https://jqueryui.com/resizable");
		//switch to frame
		WebElement frameEle = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameEle);
		System.out.println("Heading:"+driver.findElement(By.tagName("h3")).getText());
		WebElement element = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		//action class
		Actions builder=new Actions(driver);
		builder.clickAndHold(element).moveByOffset(200,220).release();
		int height1 = element.getSize().getHeight();
		int width1 = element.getSize().getWidth();
		System.out.println("After resize"+height1+" "+width1);
		driver.close();
		
	}

}
