package seleniumtest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window : "+parentWindow);
		
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[1]")).click();//linkedIn
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[2]")).click();//facebook
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[3]")).click();//twitter
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[4]")).click();//youtube
	
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			System.out.println("Window ID : "+windowId);
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			System.out.println(title);
			
			if(!windowId.equals(parentWindow)) {
			driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
	}

}
