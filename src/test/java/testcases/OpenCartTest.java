package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

	
	@Test
	public void seachboxText() {
		boolean flag = driver.findElement(By.name("search")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	@Test
	public void pageTitleTest() {
		String text = driver.getTitle();
		System.out.println("Page title : "+text);
		Assert.assertEquals(text, "Your Store");
	}
	
//	@Test
//	public void logoTest() {
//		//boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
//		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
//	}
	
	

}
