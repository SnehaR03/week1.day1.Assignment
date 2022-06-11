package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Step 2: Instantaite the ChromeDriver
		
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in");
		WebElement fromStn = driver.findElement(By.id("txtStationFrom"));
		fromStn.clear();
		fromStn.sendKeys("MS");
		Thread.sleep(1000);
		fromStn.sendKeys(Keys.ENTER);
		WebElement toStn = driver.findElement(By.id("txtStationTo"));
		toStn.clear();
		toStn.sendKeys("MDU");
		Thread.sleep(1000);
		toStn.sendKeys(Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(5000);
		List<WebElement> name = driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader'//tr]"));
		System.out.println(name);
		//WebElement table = driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']"));
		int size=driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr")).size(); 
		List<String> trainName=new ArrayList<String>();
		
	    for(int i=1;i<size;i++) {
	     String text = driver.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader'//tr["+i+"]//td[2]")).getText();
	     trainName.add(text);
	     
	    }
	    Set<String> uniqueTrain=new HashSet<String>(trainName); 
	    if(trainName.size()==uniqueTrain.size()) {
	    	System.out.println("No Duplicates");
	    	System.out.println(uniqueTrain.size());
	    	System.out.println(uniqueTrain);
	    }
	    else
	    {
	    	System.out.println("Duplicates");
	    }
	}

}
