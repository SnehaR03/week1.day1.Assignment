package week3.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Step 2: Instantaite the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ajio.com/");
		//In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("Bags");
		driver.findElement(By.className("ic-search")).click();
		driver.findElement(By.xpath("//*[@id='facets']//label[contains(text(),'Fashion Bags')]")).click();
		String count = driver.findElement(By.className("length")).getText();
		System.out.println("No of Items Found:"+count);
		List<WebElement> brands = driver.findElements(By.className("brand"));
		System.out.println("Brands Count:"+brands.size());
		System.out.println("BrandList");
		for(WebElement brandList:brands) {
			System.out.println(brandList.getText());

		}
		List<WebElement> bagNames = driver.findElements(By.className("nameCls"));
		System.out.println("Bag Name List");
		for(WebElement nameList:bagNames) {
			System.out.println(nameList.getText());
		}


		driver.close();
		}
}