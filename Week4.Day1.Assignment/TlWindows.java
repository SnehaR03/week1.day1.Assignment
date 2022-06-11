package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TlWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Window.html");
		//go to home
		driver.findElement(By.id("home")).click();
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		//get windows handle
		Set<String> windowsHandle = driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowsHandle);
		//open new window
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();
		//switch to parent window
		driver.switchTo().window(parentWindow);
		//open multiple windows
		driver.findElement(By.xpath("//button[contains(text(),'Multiple Windows')]")).click();
		Thread.sleep(3000);
		//get windows handle
		Set<String> windowsHandle1 = driver.getWindowHandles();
		List<String> windows1=new ArrayList<String>(windowsHandle1);
		System.out.println("No. of Windows: " + windows1.size());
		for(int i=0; i< windowsHandle1.size(); i++) {
			driver.switchTo().window(windows1.get(i));
			System.out.println(driver.getTitle());
		}
		driver.switchTo().window(parentWindow);
		//do not close me
		driver.findElement(By.id("color")).click();
		Set<String> windowsHandle2 = driver.getWindowHandles();
		List<String> windows2=new ArrayList<String>(windowsHandle2);
		System.out.println("No of windows open:"+windows.size());
		for(int i=1; i< windowsHandle2.size(); i++) {
	    driver.switchTo().window(windows2.get(i));
		driver.close();
	}
		driver.switchTo().window(parentWindow);
		System.out.println("All windows except parent closed-get title of current window:"+driver.getTitle());
		driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();
		Thread.sleep(5000);
		Set<String> windowsHandle3 = driver.getWindowHandles();
		List<String> windows3=new ArrayList<String>(windowsHandle3);
		for(int i=0; i< windowsHandle1.size(); i++) {
			Thread.sleep(5000);
			driver.switchTo().window(windows3.get(i));
			System.out.println(driver.getTitle());
		}
		driver.switchTo().window(parentWindow);
		driver.quit();

}
}
