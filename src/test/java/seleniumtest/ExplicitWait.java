package seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	static WebDriver driver;
	public static void main(String[] args) {
		// explicit wait
			//1. its applied for a specific element, not for all the elements
			//2. not a global wait
			//3. can be used for non web elements: title, url, alerts
			//4. polling/interval

		// 1. webdriverwait
		// 2. fluentwait

		// WebDriverWait(c) -- extends --> FluentWait(c) ---implements--> Wait(I) -
		// until();

		// FluentWait(c) -- until() -- @override + other methods

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		By logo = By.cssSelector("img.img-responsive");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//		WebElement email_el = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		email_el.sendKeys("neetishb@gmail.com");
//		
//		driver.findElement(pwd).sendKeys("test@123");
//		
//		//boolean flag = driver.findElement(logo).isDisplayed();
//		//System.out.println(flag);
//		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement logo_el = wait1.until(ExpectedConditions.presenceOfElementLocated(logo));
//		boolean flag = logo_el.isDisplayed();
//		System.out.println(flag);
		
		
		waitForElementPresence(emailId, 10).sendKeys("abc@test.com");
		if (waitForElementPresence(logo, 5).isDisplayed()) {
			System.out.println("logo is present");
		}
		
		

	}

	public static WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
