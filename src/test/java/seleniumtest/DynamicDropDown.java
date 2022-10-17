package seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

//		driver.get("https://www.google.com");

//		driver.findElement(By.name("q")).sendKeys("selenium");
//		Thread.sleep(3000);
//
//		By searchLocator = By.xpath("//ul[@class='G43f7e']/li");
//		List<WebElement> dynamicList = driver.findElements(searchLocator);
//
//		System.out.println("Total search count : " + dynamicList.size());
//
//		for (WebElement e : dynamicList) {
//			String text = e.getText();
//			System.out.println(text);
//
//			if (text.equalsIgnoreCase("selenium webdriver")) {
//				e.click();
//				break;
//			}
//		}
		
//		By searchbox = By.name("q");
//		By searchLocator = By.xpath("//ul[@class='G43f7e']/li");
//		
//		dynamicSearch(searchbox, "selenium", searchLocator, "selenium download");
		
//		Example : 2
		
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);
		By searchbox = By.id("search_query_top");
		By searchLocator = By.xpath("//div[@class='ac_results']/ul/li");
		dynamicSearch(searchbox, "dress", searchLocator, "Casual Dresses > Printed Dress");
		
		By actualLocator = By.xpath("//*[@itemprop='name']");
		String actualText = getElement(actualLocator).getText();
		if(actualText.equals("Printed Dress")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Pass");
		}
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void dynamicSearch(By locator, String sendkey, By searchLocator, String value) throws InterruptedException {
		getElement(locator).sendKeys(sendkey);
		Thread.sleep(8000);

		List<WebElement> dynamicList = getElements(searchLocator);
		Thread.sleep(8000);
		System.out.println("Total search count : " + dynamicList.size());

		for (WebElement e : dynamicList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equalsIgnoreCase(value)) {
				e.click();
				System.out.println("You have selected : "+text);
				break;
			}
		}
	}
}
