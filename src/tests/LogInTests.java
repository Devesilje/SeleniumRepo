package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTests{

	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	@Test(priority = 0)
	public void logInValidCredentials() throws InterruptedException {
		mainNavigation.clickOnSignIn();
		String email = excelReader.getStringData("LogIn", 5, 2);
		String password = excelReader.getStringData("LogIn", 6, 2);
		String textForAssertion = excelReader.getStringData("LogIn", 9, 2);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = myAccountPage.textFromMyAccountLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 1)
	public void logInInvalidEmailCredentials()  {
		mainNavigation.clickOnSignIn();
		String email = excelReader.getStringData("LogIn", 5, 3);
		String password = excelReader.getStringData("LogIn", 6, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 10, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidEmailLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 2)
	public void logInInvalidPasswordCredentials() throws InterruptedException {
		mainNavigation.clickOnSignIn();
		String email = excelReader.getStringData("LogIn", 5, 4);
		String password = excelReader.getStringData("LogIn", 6, 4);
		String textForAssertion = excelReader.getStringData("LogIn", 10, 4);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidPasswordLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 3)
	public void logInEmptyCredentials() {
		mainNavigation.clickOnSignIn();
		String textForAssertion = excelReader.getStringData("LogIn", 10, 5);
		logInPage.insertEmail("");
		logInPage.insertPassword("");
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidPasswordLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test (priority = 4)
	public void logOut() throws InterruptedException {
		logInValidCredentials();
		mainNavigation.clickOnSignOut();
		String textForAssertion = excelReader.getStringData("LogOut", 9, 2);
		String actualText = logInPage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	
	@AfterMethod
	public void afterTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
