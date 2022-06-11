package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		//go to home
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 9 pro");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String amount = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("Price:"+amount);
		WebElement rating = driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']/i"));
		Actions builder=new Actions(driver);
		builder.moveToElement(rating).perform();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//a/span[@class='a-size-medium a-color-base a-text-normal']"));
		builder.moveToElement(ele).perform();
		ele.click();
		Thread.sleep(3000);
		//get windows handle
		Set<String> windowsHandle = driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowsHandle);
		//open new window
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
		Thread.sleep(4000);
		//get customer rating
		String cusReviews = driver.findElement(By.xpath("//span[@id='acrCustomerReviewText']")).getText();
		System.out.println("Customer Reviews:"+cusReviews);
		String price = driver.findElement(By.xpath("//td[contains(text(),'Deal')]/following-sibling::td/span/span[2]")).getText();
		//taking screenshot 
		File source =driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:/Users/Admin/Screenshot/result.jpg");
		FileUtils.copyFile(source, destination);
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(3000);
		String cartTotal = driver.findElement(By.xpath("//span/b[text()='Cart subtotal']/following::span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Cart Total:"+cartTotal);
		if(price.equals(cartTotal)) {
				System.out.println("Total Amount"+price);
		}
		else {
			System.out.println("Incorrect");
		}
		driver.quit();

}
}
