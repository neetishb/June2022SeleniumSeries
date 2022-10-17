package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import seleniumtest.BrowserUtil;

public class BaseTest {

	WebDriver driver;

	@Parameters({"url","browser"})
	@BeforeTest
	public void launchBrowser(String url, String browser) throws Exception {
	
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		BrowserUtil bu = new BrowserUtil();
		driver = bu.launchBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
