package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//load URL
		driver.get("http://www.leafground.com/pages/sortable.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 5']"));
        WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 2']"));
        Actions builder = new Actions(driver);
		builder.clickAndHold(item5).moveToElement(item2).release().perform();
		driver.close();
	}

}
