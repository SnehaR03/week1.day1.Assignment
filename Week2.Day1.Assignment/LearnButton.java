package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Button.html");
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
	    driver.close();

	}

}
