package seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsClose {

	public static void main(String[] args) {

//		1. 	Quit ----> Session id becomes null
//			Close()----> Session id remains same but becomes invalid

		WebDriverManager.chromedriver().setup();

		/*
		WebDriver driver = new ChromeDriver();	//New session id will be created lets say 123
		driver.get("https://www.google.com"); // session id= 123
		String pageTitle = driver.getTitle(); // session id= 123
		System.out.println("Page title : " + pageTitle);

		driver.quit(); // session id= 123
		//After executing above line, session id will become 'null'
		
		System.out.println("Page title : " + driver.getTitle());
		
		// org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

		//To overcome above exception, we need to create new object of ChromeDriver and hence 
		//new session id will be created.
		
		driver = new ChromeDriver();  // New session id = 987
		System.out.println("Page title : " + driver.getTitle()); // New session id = 987
		
		*/
		
		WebDriver driver = new ChromeDriver();	//New session id will be created lets say 123
		driver.get("https://www.google.com"); // session id= 123
		String pageTitle = driver.getTitle(); // session id= 123
		System.out.println("Page title : " + pageTitle);

		driver.close(); // session id= 123
		//After executing above line, session id will remain 123 but it will become invalid
		
		System.out.println("Page title : " + driver.getTitle());
		
		//  org.openqa.selenium.NoSuchSessionException: invalid session id

		//To overcome above exception, we need to create new object of ChromeDriver and hence 
		//new session id will be created.
//		
//		driver = new ChromeDriver();
//		System.out.println("Page title : " + driver.getTitle());

	}

}
