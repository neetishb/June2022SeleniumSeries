package seleniumtest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	private Select select;
	private Actions act;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetAttributeName(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	

	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public  int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public  ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> listEle = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		
		for(WebElement e : listEle) {
			
			String alist = e.getText();
			eleTextList.add(alist);
		}
		
		return eleTextList;
	}
	
	// ******************Drop Down utils*****************//
	// only when html tag = <select>
	
	public void doSelectDropDownByIndex(By locator, int index) {
		select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectDropDownByVisibleText(By locator, String text) {
		select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectDropDownByValue(By locator, String value) {
		select = new Select(getElement(locator));
		select.deselectByValue(value);
	}
	
	// ************************Actions Utils *****************************//
		public void handleLevel1MenuItems(By parentMenu, By childMenu) throws InterruptedException {
			act.moveToElement(getElement(parentMenu)).build().perform();
			Thread.sleep(3000);
			// getElement(childMenu).click();
			doClick(childMenu);
		}

		public void doActionsClick(By locator) {
			act.click(getElement(locator)).build().perform();
		}

		public void doActionsSendkeys(By locator, String value) {
			act.sendKeys(getElement(locator), value).build().perform();
		}

		// *********************wait utils**********************//

		/**
		 * An expectation for checking that an element is present on the DOM of a page.
		 * This does not necessarily mean that the element is visible.
		 * 
		 * @param locator
		 * @param timeOut
		 * @return
		 */
		public WebElement waitForElementPresence(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}

		public void doSendKeysWithWait(By locator, int timeOut, String value) {
			waitForElementPresence(locator, timeOut).sendKeys(value);
		}

		public void doClickWithWait(By locator, int timeOut) {
			waitForElementPresence(locator, timeOut).click();
		}

		public String getElementTextWithWait(By locator, int timeOut) {
			return waitForElementPresence(locator, timeOut).getText();
		}

}
