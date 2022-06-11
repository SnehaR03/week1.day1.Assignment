package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		options.addArguments("--disable-notifications");
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//load URL
		driver.get("https://www.nykaa.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        //select brands
       // WebElement brands = driver.findElement(By.linkText("brands"));
        WebElement brands=driver.findElement(By.xpath("//div[@id='headerMenu']/div/ul[@class='HeaderNav css-f7ogli']/li/a[text()='brands']"));
        Thread.sleep(2000);
        Actions builder=new Actions(driver);
        builder.moveToElement(brands).perform();
        Thread.sleep(3000);
        //select Loreal Paris
        driver.findElement(By.linkText("L'Oreal Paris")).click();
        String title = driver.getTitle();
        //Check the title contains L'Oreal Paris(Hint-GetTitle)
        boolean contains = title.contains("L'Oreal Paris");
        System.out.println(contains);
        //select by top customer brand
        driver.findElement(By.xpath("//button/span[contains(text(),'Sort')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'customer top')]/following::div")).click();
        //select category->hair->haircare->shampoo
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']")).click();
        //select concern->color protection
        driver.findElement(By.xpath("//div/span[contains(text(),'Concern')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/span[contains(text(),'Color Protection')]/following::div")).click();
        //verify filter applied
        String filter = driver.findElement(By.className("css-1emjbq5")).getText();
        if(filter.contains("Shampoo")) {
        	System.out.println("Filter Applied");
        }
        else {
        	System.out.println("Not Applied");
        }
        //switch to frame and click and select product
        driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
        //String parentWindow = driver.getWindowHandle();
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandle);
		driver.switchTo().window(window.get(1));
		//print MRP
		System.out.println("MRP:"+driver.findElement(By.className("css-1jczs19")).getText());
		Thread.sleep(2000);
		//select 175ML from dropdown
		WebElement size = driver.findElement(By.xpath("//select[@title='SIZE' and @class='css-2t5nwu']"));
		Select dropdown=new Select(size);
		dropdown.selectByValue("0");
		//click on Add to Bag
		driver.findElement(By.xpath("//button[@class=' css-12z4fj0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		WebElement newframes = driver.findElement(By.className("css-acpm4k"));
		driver.switchTo().frame(newframes);
		Thread.sleep(2000);
		//get the total amount
		String total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String amount=total.substring(1, 4);
		System.out.println("Total:"+amount);
		//proceed and continue as guest
		driver.findElement(By.xpath("//span[@class='vernacular-string' and text()='Proceed']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		//get the grand total andn verify is same as total amount
		String grandTotal = driver.findElement(By.xpath("//div[@class='name' and text()='Grand Total']/following::div/span")).getText();
		System.out.println(grandTotal);
		if(amount.equals(grandTotal)) {
			System.out.println("Correct total");
		
		}
		else
		{
			System.out.println("Incorrect");
		}
		driver.quit();

        
        
        
        
        

	}

}
