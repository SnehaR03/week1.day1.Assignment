package week2.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LFCheckBoxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/checkbox.html");
		System.out.println(driver.getTitle());
		//select languages known
		driver.findElement(By.xpath("//label[contains(text(),'Select the languages')]/following-sibling::input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Select the languages')]/following-sibling::input[4]")).click();
		//verify ischecked
		boolean checked = driver.findElement(By.xpath("//label[contains(text(),'Selenium is checked')]/following-sibling::input[@checked]")).isSelected();
		if(checked==true)
		{
			System.out.println("Selenium is Checked");
		}
		else 
		{
			System.out.println("Not Selected");	
		}
		//Deselect the checked
		
		driver.findElement(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input[@checked]")).click();
		boolean uncheck=driver.findElement(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input[2]")).isSelected();
		if(uncheck==false)
		{
			System.out.println("check box unselected");
		}
		else 
		{
			System.out.println("checkbox Selected");	
		}
		
		//select all elements
		List<WebElement> element = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']//following-sibling::input"));
		for(WebElement checkall:element) {
			checkall.click();

	}
		System.out.println("All below options selected");
		driver.close();


}
}

