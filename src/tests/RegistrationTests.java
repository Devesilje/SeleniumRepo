package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests{

	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignIn();
	}
	@Test(priority = 0)
	public void createAccountValidInputData() {
		String email = excelReader.getStringData("Registration", 7, 3);
		String firstname = excelReader.getStringData("Registration", 9, 3);
		String lastname = excelReader.getStringData("Registration", 10, 3);
		String password = excelReader.getStringData("Registration", 11, 3);
		String address = excelReader.getStringData("Registration", 13, 3);
		String city = excelReader.getStringData("Registration", 14, 3);
		String state = excelReader.getStringData("Registration", 15, 3);
		String postalCode = excelReader.getStringData("Registration", 16, 3);
		String homePhone = excelReader.getStringData("Registration", 18, 3);
		String mobilPhone = excelReader.getStringData("Registration", 18, 3);
		String addressForReferece = excelReader.getStringData("Registration", 19, 3);
		String textForAssertion = excelReader.getStringData("Registration", 23, 3);
		logInPage.insertEmailCreatingAccount(email);
		logInPage.clickOnCreateAccountButton();
		yourPersonalInfoCreateAccountPage.insertFirstname(firstname);
		yourPersonalInfoCreateAccountPage.insertLastname(lastname);
		yourPersonalInfoCreateAccountPage.insertPassword(password);
		yourPersonalInfoCreateAccountPage.insertAddress(address);
		yourPersonalInfoCreateAccountPage.insertCity(city);
		yourPersonalInfoCreateAccountPage.clickOnDropdownMenu();
		Select drpState = new Select(yourPersonalInfoCreateAccountPage.getStateDropdownMenu());
		drpState.selectByValue(state);
		yourPersonalInfoCreateAccountPage.insertPostalCode(postalCode);
		yourPersonalInfoCreateAccountPage.insertHomePhone(homePhone);
		yourPersonalInfoCreateAccountPage.insertMobilePhone(mobilPhone);
		yourPersonalInfoCreateAccountPage.insertFutureReferenceAddress(addressForReferece);
		yourPersonalInfoCreateAccountPage.clickOnRegisterButton();
		String actualText = myAccountPage.textFromMyAccountLabel();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 1)
	public void createAccountSameEmail() throws InterruptedException {
		String email = excelReader.getStringData("Registration", 31, 3);
		String textForAssertion = excelReader.getStringData("Registration", 35, 3);
		logInPage.insertEmailCreatingAccount(email);
		logInPage.clickOnCreateAccountButton();
		Thread.sleep(1000);
		String actualText = logInPage.textFromCreateAccountError();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 2)
	public void createAccountInvalidEmail() throws InterruptedException {
		String email = excelReader.getStringData("Registration", 43, 4);
		String textForAssertion = excelReader.getStringData("Registration", 47, 4);
		logInPage.insertEmailCreatingAccount(email);
		logInPage.clickOnCreateAccountButton();
		Thread.sleep(2000);
		int present = logInPage.numberOfElementsErrorCreateAccount();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = logInPage.textFromCreateAccountError();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}
	}
	@Test(priority = 3)
	public void createAccountInvalidPersonalInputData() {
		String email = excelReader.getStringData("Registration", 57, 3);
		String firstname = excelReader.getStringData("Registration", 59, 3);
		String lastname = excelReader.getStringData("Registration", 60, 3);
		String password = excelReader.getStringData("Registration", 62, 3);
		String address = excelReader.getStringData("Registration", 63, 3);
		String city = excelReader.getStringData("Registration", 64, 3);
		//String state = excelReader.getStringData("Registration", 65, 3);
		String postalCode = excelReader.getStringData("Registration", 66, 3);
		String homePhone = excelReader.getStringData("Registration", 68, 3);
		String mobilPhone = excelReader.getStringData("Registration", 69, 3);
		String addressForReferece = excelReader.getStringData("Registration", 70, 3);
		String textForAssertion = excelReader.getStringData("Registration", 73, 3);
		logInPage.insertEmailCreatingAccount(email);
		logInPage.clickOnCreateAccountButton();
		yourPersonalInfoCreateAccountPage.insertFirstname(firstname);
		yourPersonalInfoCreateAccountPage.insertLastname(lastname);
		yourPersonalInfoCreateAccountPage.insertPassword(password);
		yourPersonalInfoCreateAccountPage.insertAddress(address);
		yourPersonalInfoCreateAccountPage.insertCity(city);
		yourPersonalInfoCreateAccountPage.insertPostalCode(postalCode);
		yourPersonalInfoCreateAccountPage.insertHomePhone(homePhone);
		yourPersonalInfoCreateAccountPage.insertMobilePhone(mobilPhone);
		yourPersonalInfoCreateAccountPage.insertFutureReferenceAddress(addressForReferece);
		yourPersonalInfoCreateAccountPage.clickOnRegisterButton();
		String actualText = yourPersonalInfoCreateAccountPage.textFromErrorMessage();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 4)
	public void createAccountInvalidPersonalInputDataSpace() throws InterruptedException{
		String email = excelReader.getStringData("Registration", 57, 4);
		String firstname = excelReader.getStringData("Registration", 59, 4);
		String lastname = excelReader.getStringData("Registration", 60, 4);
		String password = excelReader.getStringData("Registration", 62, 4);
		String address = excelReader.getStringData("Registration", 63, 4);
		String city = excelReader.getStringData("Registration", 64, 4);
		String state = excelReader.getStringData("Registration", 65, 4);
		String postalCode = excelReader.getStringData("Registration", 66, 4);
		String homePhone = excelReader.getStringData("Registration", 68, 4);
		String mobilPhone = excelReader.getStringData("Registration", 69, 4);
		String addressForReferece = excelReader.getStringData("Registration", 70, 4);
		String textForAssertion = excelReader.getStringData("Registration", 73, 3);
		logInPage.insertEmailCreatingAccount(email);
		logInPage.clickOnCreateAccountButton();
		yourPersonalInfoCreateAccountPage.insertFirstname(firstname);
		yourPersonalInfoCreateAccountPage.insertLastname(lastname);
		yourPersonalInfoCreateAccountPage.insertPassword(password);
		yourPersonalInfoCreateAccountPage.insertAddress(address);
		yourPersonalInfoCreateAccountPage.insertCity(city);
		yourPersonalInfoCreateAccountPage.clickOnDropdownMenu();
		Select drpState = new Select(yourPersonalInfoCreateAccountPage.getStateDropdownMenu());
		drpState.selectByValue(state);
		yourPersonalInfoCreateAccountPage.clickOnDropdownMenu();
		yourPersonalInfoCreateAccountPage.insertPostalCode(postalCode);
		yourPersonalInfoCreateAccountPage.insertHomePhone(homePhone);
		yourPersonalInfoCreateAccountPage.insertMobilePhone(mobilPhone);
		yourPersonalInfoCreateAccountPage.insertFutureReferenceAddress(addressForReferece);
		yourPersonalInfoCreateAccountPage.clickOnRegisterButton();
		Thread.sleep(2000);
		int present = yourPersonalInfoCreateAccountPage.numberOfErrorElements();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = yourPersonalInfoCreateAccountPage.textFromErrorMessage();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}
	}
		@Test(priority = 5)
		public void createAccountEmptyEmailField() throws InterruptedException {
			String textForAssertion = excelReader.getStringData("Registration", 99, 3);
			logInPage.clickOnCreateAccountButton();
			Thread.sleep(2000);
			String actualText = logInPage.textFromCreateAccountError();
	
			assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 6)
	public void createAccountEmptyPersonalFields() throws InterruptedException {
		String email = excelReader.getStringData("Registration", 83, 4);
		String textForAssertion = excelReader.getStringData("Registration", 99, 4);
		logInPage.insertEmailCreatingAccount(email);
		logInPage.clickOnCreateAccountButton();
		yourPersonalInfoCreateAccountPage.clickOnRegisterButton();
		Thread.sleep(2000);
		String actualText = logInPage.textFromCreateAccountError();
		assertEquals(actualText, textForAssertion);
	}
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
