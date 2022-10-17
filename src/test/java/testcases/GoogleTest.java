package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	
	@Test
	public void seachboxText() {
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	@Test
	public void pageTitleTest() {
		String text = driver.getTitle();
		System.out.println("Page title : "+text);
		Assert.assertEquals(text, "Google");
	}
	
//	@Test
//	public void logoTest() {
//		//boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
//		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
//	}
	

}
