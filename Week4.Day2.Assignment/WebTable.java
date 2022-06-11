package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//load URL
		driver.get("http://www.leafground.com/pages/table.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
		System.out.println(colSize);
        // Get the count of number of rows
		int rowSize = driver.findElements(By.xpath("//table//tr")).size();
		System.out.println(rowSize);
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='even']/td[2]"));
		for (int i = 0; i < elements.size(); i++) {
			String progress = elements.get(i).getText();
			System.out.println(driver.findElement(By.xpath("//td/font"))+":"+progress);

	}
        for(int i=2; i<= rowSize; i++) {
        	//iterate through columns
             for (int j=1; j<=colSize; j++) {
				String text = driver.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]")).getText();
				System.out.println(text);
				driver.findElement(By.name("vital")).click();
			}
		}
        driver.close();

}
}
