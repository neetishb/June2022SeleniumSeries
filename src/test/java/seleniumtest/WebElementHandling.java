package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// 1.
//		driver.findElement(By.id("input-email")).sendKeys("test");
//		driver.findElement(By.id("input-password")).sendKeys("123");
//		
		// 2. Using WebElement

//		WebElement email = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		email.sendKeys("test");
//		password.sendKeys("123");

		// 3. By Locator

//		By emailid = By.id("input-email");
//		By pass = By.id("input-password");
//
//		WebElement email = driver.findElement(emailid);
//		WebElement password = driver.findElement(pass);
//
//		email.sendKeys("test");
//		password.sendKeys("123");

		// 4. By Locator +findElement generic function

//		By emailid = By.id("input-email");
//		By pass = By.id("input-password");
//		
//		getElement(emailid).sendKeys("test");
//		getElement(pass).sendKeys("123");

		// 5. By Locator + sendkeys generic function

//		By emailid = By.id("input-email");
//		By pass = By.id("input-password");
//
//		doSendKeys(emailid, "test");
//		doSendKeys(pass, "123");

		// 6. By Locator + ElementUtil generic function

		By emailid = By.id("input-email");
		By pass = By.id("input-password");

		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.doSendKeys(emailid, "test@gmail.com");
		eUtil.doSendKeys(pass, "123");
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
