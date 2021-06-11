package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInAndLogOutTests extends BaseTests{

	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignIn();
	}
	@Test(priority = 0)
	public void logInCorrectEmailPassword()  {
		String email = excelReader.getStringData("LogIn", 9, 3);
		String password = excelReader.getStringData("LogIn", 10, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 14, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = myAccountPage.textFromMyAccountLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 1)
	public void logInIncorrectEmail()  {
		String email = excelReader.getStringData("LogIn", 25, 3);
		String password = excelReader.getStringData("LogIn", 26, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 30, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidEmailLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 2)
	public void logInIncorrectPassword() {
		String email = excelReader.getStringData("LogIn", 42, 3);
		String password = excelReader.getStringData("LogIn", 43, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 47, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidPasswordLabel();
		assertEquals(actualText, textForAssertion);
	} 
	@Test(priority = 3)
	public void logInIncorrectPasswordSpace()  {
		String email = excelReader.getStringData("LogIn", 42, 4);
		String password = excelReader.getStringData("LogIn", 43, 4);
		String textForAssertion = excelReader.getStringData("LogIn", 47, 4);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidPasswordLabel();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 4)
	public void logInEmptyEmailField() {
		String password = excelReader.getStringData("LogIn", 62, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 66, 3);
		logInPage.insertEmail("");
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromEmptyEmailFieldLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 5)
	public void logInEmptyPasswordField() {
		String email = excelReader.getStringData("LogIn", 61, 4);
		String textForAssertion = excelReader.getStringData("LogIn", 66, 4);
		logInPage.insertEmail(email);
		logInPage.insertPassword("");
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromEmptyPasswordFieldLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test (priority = 6)
	public void logOutOnSignOutButton() {
		logInCorrectEmailPassword();
		mainNavigation.clickOnSignOut();
		String textForAssertion = excelReader.getStringData("LogOut", 14, 3);
		String actualText = logInPage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	@Test (priority = 7)
	public void logOutOnBackButton() {
		logInCorrectEmailPassword();
		driver.navigate().back();
		String textForAssertion = excelReader.getStringData("LogOut", 30, 3);
		String actualText = logInPage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	
	@AfterMethod
	public void afterTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
