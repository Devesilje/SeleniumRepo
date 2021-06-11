package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MyAddressesPage;
import pages.YourAddressesPage;
import pages.LogInPage;
import pages.MainNavigation;
import pages.MyAccountPage;

public class BaseTests {

	WebDriver driver;
	MainNavigation mainNavigation;
	LogInPage logInPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	YourAddressesPage yourAddressesPage;
	ExcelReader excelReader;
	String homeUrl;
	
	@BeforeClass 
	public void beforeTests() throws IOException{
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mainNavigation = new MainNavigation(driver);
		logInPage = new LogInPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		yourAddressesPage = new YourAddressesPage(driver);
		excelReader = new ExcelReader("data/TestPlan.xlsx");
		homeUrl = "http://automationpractice.com/index.php";
	}
	@AfterClass
	public void afterTests () {
		driver.close();
	}

}
