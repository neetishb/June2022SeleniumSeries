package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcept {
	
	/*
	 * 
	BS--Open Db connection
	BT--Create new user
	BC--Launch Url
		BM--Login
		Test--addToCartTest
		BM--Logout

		BM--Login
		Test--paymentTest
		BM--Logout
		
		BM--Login
		Test--searchTest
		BM--Logout
	AC--Close Url
	AT--Delete new user
	AS--Close Db connection

	 */
	
	@BeforeSuite
	public void openDbConnection() {
		System.out.println("BS--Open Db connection");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT--Create new user");
	}
	
	@BeforeClass
	public void openUrl() {
		System.out.println("BC--Launch Url");
	}
	
	@BeforeGroups
	public void openGroup() {
		System.out.println("BG--Group");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BM--Login");
	}
	
	@Test
	public void searchTest() {
		System.out.println("Test--searchTest");
	}
	
	@Test
	public void addToCartTest() {
		System.out.println("Test--addToCartTest");
	}
	
	@Test
	public void paymentTest() {
		System.out.println("Test--paymentTest");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("BM--Logout");
	}
	
	@AfterSuite
	public void closeDbConnection() {
		System.out.println("AS--Close Db connection");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT--Delete new user");
	}
	
	@AfterClass
	public void closeUrl() {
		System.out.println("AC--Close Url");
	}
	
	@AfterGroups
	public void closeGroup() {
		System.out.println("AG--Close Group");
	}

}
