package week2.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LGHyperLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Link.html");
		//navigate to home page
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("Home Page:"+driver.getTitle());
		driver.navigate().back();
		//navigate to buttons page
		driver.findElement(By.xpath("//a[contains(text(),'without clicking')]")).click();
		System.out.println("Buttons Page:"+driver.getTitle());
		System.out.println("URL: "+driver.getCurrentUrl());
		//click button
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getPageSource());
		driver.navigate().back();
		//get position of button
	    Point location = driver.findElement(By.id("position")).getLocation();
	    System.out.println("Position of Button:"+location);
	    //get color,height,width,tagname
	    String bgColor = driver.findElement(By.id("color")).getCssValue("background-color");
	    System.out.println("Button Color:"+bgColor);
	    System.out.println("Height"+driver.findElement(By.id("size")).getSize().getHeight());
	    System.out.println("Width"+driver.findElement(By.id("size")).getSize().getWidth());
	    System.out.println("Tagname "+driver.findElement(By.id("size")).getTagName());
	    driver.navigate().back();
	    //verify error message
	    driver.findElement(By.linkText("Verify am I broken?")).click();
		System.out.println("Error:"+driver.getCurrentUrl()); 
		String text = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Error msg displayed:"+text);
		driver.navigate().back();
		//go to home page
		driver.findElement(By.xpath("//label[contains(text(),'(Interact')]/preceding-sibling::a[contains(text(),'Home Page')]")).click();
		System.out.println("Current URL"+driver.getCurrentUrl());
		driver.navigate().back();
		//get no of links in page
		driver.findElement(By.linkText("How many links are available in this page?")).click();
		boolean displayed = driver.findElement(By.linkText("How many links are available in this page?")).isDisplayed();
		System.out.println("Link Displayed:"+displayed);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("No of Links:"+list.size());
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
	}

}
