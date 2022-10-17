package seleniumtest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoTable {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get(
				"https://www.espncricinfo.com/series/india-women-in-england-2022-1289245/england-development-squad-women-vs-india-women-warm-up-1332750/full-scorecard");

		Thread.sleep(4000);
		
//		String text = driver.findElement(By.xpath("//span[text()='Shafali Verma']/ancestor::td/following-sibling::td")).getText();
//		System.out.println(text);
		
		getWicketTakerInfo("Shafali Verma");
		getWicketTakerInfo("Harmanpreet Kaur");
		
		ArrayList<String> text = getBatsmanDetails("Dayalan Hemalatha");
		System.out.println(text);
	}
	
	public static void getWicketTakerInfo(String name) {
		String text = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::td/following-sibling::td")).getText();
		System.out.println(text);
	}
	
	public static ArrayList<String> getBatsmanDetails(String name) {
		List<WebElement> batsmanList = driver.findElements(By.xpath("//span[text()='"+name+"']/ancestor::td/following-sibling::td"));
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement e : batsmanList) {
			String text = e.getText();
			list.add(text);
			//System.out.println(text);
		}
		return list;
	}

}
