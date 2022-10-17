package seleniumtest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Preceding_Following_Sibling_Concept {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		//https://selectorshub.com/xpath-practice-page/
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("neetishb");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9960630454");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		Thread.sleep(3000);
		
		//getContactClicked("Ashish Singh");
		//getContactClicked("Ritu Kumari");
		
		////a[text()='Piyush Goyal']/parent::td/following-sibling::td
		//a[text()='Piyush Goyal']/parent::td/preceding-sibling::td/parent::tr/td
		
//		List<WebElement> contactList = driver.findElements(By.xpath("//a[text()='Piyush Goyal']/parent::td/preceding-sibling::td/parent::tr/td"));
//		for(WebElement e : contactList) {
//			String text = e.getText();
//			if(text.length()!=0) {
//				System.out.println(text);	
//			}
//			
//		}
		
		getUserinfo("Ajay Nagar");
		getUserinfo("Piyush Goyal");


	}
	
		public static void getContactClicked(String name) {
			String contactCheckbox = "//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
			driver.findElement(By.xpath(contactCheckbox)).click();
			
		}
		
		public static ArrayList<String> getUserinfo(String userName) {
			//List<WebElement> contList = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
			List<WebElement> contList = driver
					.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/parent::tr/td"));
			
			
			ArrayList<String> contValues = new ArrayList<String>();
			for(int i=0; i<contList.size()-1; i++) {
				String text = contList.get(i).getText();
				System.out.println(text);
				contValues.add(text);
			}
			return contValues;
		}

}
