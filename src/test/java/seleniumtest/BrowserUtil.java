package seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize driver based on browser name
	 * 
	 * @param browser
	 * @throws Exception
	 */
	public WebDriver launchBrowser(String browser) throws Exception {

		System.out.println("Browser name : " + browser);

		switch (browser.toLowerCase()) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Invalid browser name : " + browser);
			throw new Exception("INCALID_BROWSER");
		}
		
		return driver;
	}

	public void launchUrl(String url) throws Exception {

		if (url == null) {
			System.out.println("Url is NULL");
			throw new Exception("URL_IS_NULL");
		}
		if (url.length() == 0) {
			System.out.println("Url is Blank");
			throw new Exception("URL_IS_BLANK");

		}
		if ((url.indexOf("http") != 0) && (url.indexOf("https") != 0)) {
			System.out.println("http(s) is missing in Url");
			throw new Exception("HTTP(s)_IS_MISSING");

		}

		driver.get(url);
	}

	public String getTitle() {

		String title = driver.getTitle();
		System.out.println("Page title : " + title);
		if (title != null) {
			return title;
		} else {
			System.out.println("Getting null title....");
			return null;
		}
	}

	public String getCurrentUrl() {

		String url = driver.getCurrentUrl();
		System.out.println("Page Url : " + url);
		if (url != null) {
			return url;
		} else {
			System.out.println("Getting null Url....");
			return null;
		}
	}
	
	public void closeBrowser() {
		if(driver!=null)
		{
			driver.close();
			System.out.println("Browser is closed.");
		}
	}
	
	public void quitBrowser() {
		if(driver!=null)
		{
			driver.quit();
			System.out.println("Browser is closed.");
		}
	}
}
