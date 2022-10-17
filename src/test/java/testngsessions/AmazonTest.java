package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.com/");
	}
	
	@Test
	public void seachboxText() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	@Test
	public void pageTitleTest() {
		String text = driver.getTitle();
		System.out.println("Page title : "+text);
		Assert.assertEquals(text, "Amazon.com. Spend less. Smile more.");
	}
	
	@Test
	public void logoTest() {
		//boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
