package seleniumtest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandleWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		Thread.sleep(2000);
		
		Set<String> windowList = driver.getWindowHandles();
		
		Iterator<String> it = windowList.iterator();
		String parentWindow = it.next();
		System.out.println("Parent window : "+parentWindow);
		
		String childWindow = it.next();
		System.out.println("Child window : "+childWindow);
		
		driver.switchTo().window(childWindow);
		
		String childWinTitle = driver.getTitle();
		System.out.println("Child Window title : "+childWinTitle);
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Neetish");
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(parentWindow);
		String parentWinTitle = driver.getTitle();
		System.out.println("Parent Window title : "+parentWinTitle);
		
	}

}
