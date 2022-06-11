package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal_Ass3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		// Step 2: Instantaite the ChromeDriver
		ChromeDriver driver = new ChromeDriver(options);
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		Actions builder=new Actions(driver);
		WebElement men = driver.findElement(By.className("catText"));
		builder.moveToElement(men).perform();
		WebElement shoe = driver.findElement(By.xpath("//a/span[text()='Sports Shoes']"));
		builder.click(shoe).perform();
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(2000);
		WebElement sort=driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]"));
		builder.moveToElement(sort).perform();
		builder.click(sort).perform();
		//driver.findElement(By.xpath("//div[@class='sort-selected'][contains(text(),'Price Low')]")).click();
		System.out.println("Sorted");
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("500");
		WebElement toValue = driver.findElement(By.name("toVal"));
		toValue.clear();
		toValue.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View More ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Navy']/following-sibling::label")).click();
		Thread.sleep(2000);
		String filter=driver.findElement(By.xpath("//div[@class='filters']/div[@class='navFiltersPill' and text()='Price: ']")).getText();
		System.out.println(filter);
		String filter1=driver.findElement(By.xpath("//div[@class='filters']/div[@class='navFiltersPill' and text()='Color: ']")).getText();
		System.out.println(filter1);
		WebElement firstShoe = driver.findElement(By.className("product-image"));
		builder.moveToElement(firstShoe).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'view details')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText());
		File source=driver.getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:/Users/Admin/Screenshot/snap.jpg");
		FileUtils.copyFile(source, Destination);
		driver.close();
		
		
		
		
		
	}

}
