package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LogInAndLogOutTests extends BaseTests {

	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignIn();
	}
	
	@Test(priority = 0)
	public void logInCorrectEmailPassword() {
		String email = excelReader.getStringData("LogIn", 7, 3);
		String password = excelReader.getStringData("LogIn", 8, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 12, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = myAccountPage.textFromMyAccountLabel();
		AssertJUnit.assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 1)
	public void logInIncorrectEmail() {
		String email = excelReader.getStringData("LogIn", 20, 3);
		String password = excelReader.getStringData("LogIn", 21, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 25, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidEmailLabel();
		AssertJUnit.assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 2)
	public void logInIncorrectPassword() {
		String email = excelReader.getStringData("LogIn", 20, 4);
		String password = excelReader.getStringData("LogIn", 21, 4);
		String textForAssertion = excelReader.getStringData("LogIn", 25, 4);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromInvalidPasswordLabel();
		AssertJUnit.assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 3)
	public void logInIncorrectPasswordSpace() {
		String email = excelReader.getStringData("LogIn", 20, 5);
		String password = excelReader.getStringData("LogIn", 21, 5);
		String textForAssertion = excelReader.getStringData("LogIn", 25, 5);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		int present = logInPage.numberOfElements();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = logInPage.textFromInvalidPasswordLabel();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}
	}

	@Test(priority = 4)
	public void logInEmptyEmailField() {
		String password = excelReader.getStringData("LogIn", 36, 3);
		String textForAssertion = excelReader.getStringData("LogIn", 40, 3);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromEmptyEmailFieldLabel();
		AssertJUnit.assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 5)
	public void logInEmptyPasswordField() {
		String email = excelReader.getStringData("LogIn", 35, 4);
		String textForAssertion = excelReader.getStringData("LogIn", 40, 4);
		logInPage.insertEmail(email);
		logInPage.insertPassword("");
		logInPage.clickOnSignIn();
		String actualText = logInPage.textFromEmptyPasswordFieldLabel();
		AssertJUnit.assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 6)
	public void logOutOnSignOutButton() {
		String textForAssertion = excelReader.getStringData("LogOut", 10, 3);
		logInCorrectEmailPassword();
		mainNavigation.clickOnSignOut();
		String actualText = logInPage.textFromSignInButton();
		AssertJUnit.assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 7)
	public void logOutOnBackButton() {
		String textForAssertion = excelReader.getStringData("LogOut", 21, 3);
		logInCorrectEmailPassword();
		driver.navigate().back();
		String actualText = logInPage.textFromSignInButton();
		AssertJUnit.assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 8)
	public void forgotYourPassword() throws InterruptedException{
		String textForAssertion = excelReader.getStringData("LogIn", 51, 3);
		logInPage.clickOnForgotYourPassword();
		Thread.sleep(2000);
		String actualText = forgotYourPasswordPage.textFromForgotYourPasswordLabel();
		AssertJUnit.assertEquals(textForAssertion, actualText);
	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
