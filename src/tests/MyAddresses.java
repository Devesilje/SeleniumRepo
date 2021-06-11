package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAddresses extends BaseTests{
	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignIn();
		String email = excelReader.getStringData("LogIn", 9, 3);
		String password = excelReader.getStringData("LogIn", 10, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
	}
	@Test(priority = 0)
	public void updateAddressValidInput() {
		String address = excelReader.getStringData("Address", 12, 3);
		String textForAssertion = excelReader.getStringData("Address", 16, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddressForUpdate(address);
		yourAddressesPage.clickOnSaveButton();
		String actualText = myAddressesPage.textFromUpdatedAddress();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 1)
	public void updateAddressInvalidInputSpecialCharacters() {
		String address = excelReader.getStringData("Address", 28, 3);
		String textForAssertion = excelReader.getStringData("Address", 16, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddressForUpdate(address);
		yourAddressesPage.clickOnSaveButton();
		String actualText = myAddressesPage.textFromUpdatedAddress();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 2)
	public void updateAddressInvalidInputSpace() {
		String address = excelReader.getStringData("Address", 28, 5);
		String textForAssertion = excelReader.getStringData("Address", 16, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddressForUpdate(address);
		yourAddressesPage.clickOnSaveButton();
		String actualText = myAddressesPage.textFromUpdatedAddress();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 3)
	public void updateAddressEmptyField() {
		String textForAssertion = excelReader.getStringData("Address", 48, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.clearUpdateAddressField();
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textForEmptyUpdateAddressFiled();
		assertEquals(actualText, textForAssertion);
	}
	
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
