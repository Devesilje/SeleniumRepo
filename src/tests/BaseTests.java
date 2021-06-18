package tests;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import pages.MyAddressesPage;
import pages.MyPersonalInfoPage;
import pages.MyWishlistPage;
import pages.WomenPage;
import pages.YourAddressesPage;
import pages.YourPersonalInfoCreateAccountPage;
import pages.CartPage;
import pages.FirstDressPrinted;
import pages.ForgotYourPasswordPage;
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
	MyPersonalInfoPage myPersonalInfoPage;
	MyWishlistPage myWishlistPage;
	WomenPage womenPage;
	FirstDressPrinted firstDressPrinted;
	ForgotYourPasswordPage forgotYourPasswordPage;
	YourPersonalInfoCreateAccountPage yourPersonalInfoCreateAccountPage;
	ExcelReader excelReader;
	String homeUrl;
	WebDriverWait wd;
	CartPage cartpage;
	
	
	@BeforeClass 
	public void beforeTests() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wd = new WebDriverWait(driver, 30);
		mainNavigation = new MainNavigation(driver);
		logInPage = new LogInPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		yourAddressesPage = new YourAddressesPage(driver);
		myPersonalInfoPage = new MyPersonalInfoPage(driver);
		myWishlistPage = new MyWishlistPage(driver);
		womenPage = new WomenPage(driver);
		forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
		firstDressPrinted = new FirstDressPrinted(driver);
		cartpage = new CartPage(driver);
		yourPersonalInfoCreateAccountPage = new YourPersonalInfoCreateAccountPage(driver);
		excelReader = new ExcelReader("data/TestPlan.xlsx");
		homeUrl = "http://automationpractice.com/index.php";
		
	}
	@AfterClass
	public void afterTests () {
		driver.close();
	}

}
