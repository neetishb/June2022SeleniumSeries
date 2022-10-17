package seleniumtest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://amazon.com");

		List<WebElement> listelement = driver.findElements(By.tagName("a"));
		System.out.println("Total links : " + listelement.size());

//		for (int i = 0; i < listelement.size(); i++) {
//			String text = listelement.get(i).getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//		}
		
//		for(WebElement e : listelement) {
//			String text = e.getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//			
//			String attri = e.getAttribute("href");
//			System.out.println(attri);
//		}
		
//		List<WebElement> imglist = driver.findElements(By.tagName("img"));
//		System.out.println("Total images : " + imglist.size());
//
//		for(WebElement e: imglist) {
//			String imgName = e.getAttribute("alt");
//			String imgRef = e.getAttribute("src");
//			
//			System.out.println(imgName +" : "+imgRef);
//		}
	
		By linkText = By.tagName("a");
		By linkimg = By.tagName("img");
		
		int linkCnt = getElementsCount(linkText);
		int imgCnt = getElementsCount(linkimg);
		
		System.out.println("Total Links Count : "+linkCnt);
		System.out.println("Total Image Count : "+imgCnt);
		
		ArrayList<String> linklistText = getElementsTextList(linkText);
		//ArrayList<String> linklistImg = getElementsTextList(linkimg);
		
		System.out.println(linklistText);
		
	}
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public static ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> listEle = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		
		for(WebElement e : listEle) {
			
			String alist = e.getText();
			eleTextList.add(alist);
		}
		
		return eleTextList;
	}

}
