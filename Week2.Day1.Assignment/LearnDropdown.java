package week2.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		//select training dropdown using index
		WebElement dropdown =driver.findElement(By.id("dropdown1")); 
		Select training=new Select(dropdown); 
		training.selectByIndex(1);
		//select dropdown using text
		WebElement ddtext =driver.findElement(By.name("dropdown2")); 
		Select text=new Select(ddtext); 
		text.selectByVisibleText("Appium");
		//select dropdown using value
		WebElement ddvalue =driver.findElement(By.name("dropdown3")); 
		Select value=new Select(ddvalue); 
		value.selectByValue("3");

		//get number of options
		WebElement findOptions = driver.findElement(By.className("dropdown"));
		Select count=new Select(findOptions); 
		List<WebElement> options = count.getOptions();
		int size=count.getOptions().size();
		System.out.println("Number of options:"+size);
		System.out.println("options available in dropdown:");
		for(int i=0;i<size;i++)
		{
			WebElement element = options.get(i);
			String ddText=element.getText();
			System.out.println(ddText);
		}
		//select using sendkey values
		WebElement sKeys = driver.findElement(By.xpath("//select/option[contains(text(),'sendKeys to select')]/parent::select"));
		sKeys.sendKeys("Selenium");
		//select your program
		WebElement programs=driver.findElement(By.xpath("//select/option[text()='Select your programs']/parent::select"));
		System.out.println("Default value selected:"+driver.findElement(By.xpath("//select/option[text()='Select your programs']/parent::select")).isSelected());
		Select programValue=new Select(programs); 
		programValue.selectByValue("3");
		driver.close();


	}

}
