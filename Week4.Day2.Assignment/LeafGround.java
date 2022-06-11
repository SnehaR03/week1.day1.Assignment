package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Instantaite the ChromeDriver
		
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		Actions builder=new Actions(driver);
		WebElement option1=driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Selenium']"));
		WebElement option2=driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Appium']"));
		builder.keyDown(Keys.CONTROL).click(option1).perform();
		builder.keyDown(Keys.CONTROL).click(option2).perform();
		driver.close();

	}

}
