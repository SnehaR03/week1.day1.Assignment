package week2.day1;


import java.time.Duration;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LFImage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Image.html");
		//click image to go to home page
		driver.findElement(By.xpath("//label[contains(text(),'Click on this image')]/following-sibling::img")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
        driver.navigate().back();
        //verify broken image by attribute
        WebElement brokenImage = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
        if (brokenImage.getAttribute("naturalWidth").equals("0"))
        {
            System.out.println(brokenImage.getAttribute("outerHTML") + " is broken.");
        
        
	    }
        //mouse click action perform
        WebElement mouseImg = driver.findElement(By.xpath("//label[contains(text(),'Click me using')]/following-sibling::img"));
        Actions builder = new Actions(driver);
        Action mouseOverImg = builder.moveToElement(mouseImg).build();
        mouseOverImg.perform();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.close();
        
        
        

}
}
