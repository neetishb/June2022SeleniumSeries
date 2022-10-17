package seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		WebElement countryselect = driver.findElement(By.id("Form_getForm_Country"));

		Select sel = new Select(countryselect);

		List<WebElement> countryOpt = sel.getOptions();
		System.out.println("Total Country count : " + countryOpt.size());

		for (WebElement e : countryOpt) {
			String text = e.getText();
			System.out.println(text);
		}

//		sel.selectByIndex(5);
//		sel.selectByVisibleText("Bahrain");
//		sel.selectByValue("Spain");
		
		By countrylocator = By.id("Form_getForm_Country");
		doSelectDropDownByIndex(countrylocator, 15);
		doSelectDropDownByVisibleText(countrylocator, "India");
		doSelectDropDownByValue(countrylocator, "France");
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectDropDownByIndex(By locator, int index) {
		Select sel = new Select(getElement(locator));
		sel.selectByIndex(index);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String text) {
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(text);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select sel = new Select(getElement(locator));
		sel.deselectByValue(value);
	}
	
	public static List<WebElement> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}
	
	public static int getDropDownOptionsCount(By locator) {
		return getDropDownOptions(locator).size();
	}
}
