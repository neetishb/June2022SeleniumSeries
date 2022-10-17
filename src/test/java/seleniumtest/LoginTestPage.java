package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTestPage {

	public static void main(String[] args) throws Exception {
		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.launchBrowser("Chrome");
		bUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		bUtil.getTitle();
		bUtil.getCurrentUrl();
		
		By emailid = By.id("input-email");
		By pass = By.id("input-password");
		
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.doSendKeys(emailid, "test@gmail.com");
		eUtil.doSendKeys(pass, "123");
	}

}
