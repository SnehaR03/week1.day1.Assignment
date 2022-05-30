package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Link.html");
		List<WebElement> findLinks = driver.findElements(By.tagName("a"));
		WebElement firstLink = findLinks.get(0);
		firstLink.click();
		//findLinks.get(0).click();
		System.out.println("Title of page:"+driver.getTitle());
		driver.navigate().back();
		List<WebElement> getLinks = driver.findElements(By.tagName("a"));
		System.out.println("Size:"+getLinks.size());
		WebElement secLink = findLinks.get(1);
		//System.out.println("Hrefofsecond link-"+findLinks.get(1).getAttribute("href"));
		System.out.println("Href ofsecond link-"+secLink.getAttribute("href"));
		driver.close();
		
		

	}

}
