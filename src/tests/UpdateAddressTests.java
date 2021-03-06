package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateAddressTests extends BaseTests {
	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignIn();
		String email = excelReader.getStringData("LogIn", 7, 3);
		String password = excelReader.getStringData("LogIn", 8, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
	}

	@Test(priority = 0)
	public void updateAddressValidInput() {
		String address = excelReader.getStringData("UpdateAddress", 9, 3);
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 10, 3);
		String textForAssertion1 = excelReader.getStringData("UpdateAddress", 14, 3);
		String textForAssertion2 = excelReader.getStringData("UpdateAddress", 15, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		boolean result = myAddressesPage.textFromFirstAddress().equals(textForAssertion1)
				&& myAddressesPage.textFromSecondAddress().equals(textForAssertion2);
		assertTrue(result);
	}

	@Test(priority = 1)
	public void updateAddressValidInputDifferentReferenceAddress() {
		String address = excelReader.getStringData("UpdateAddress", 9, 4);
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 10, 4);
		String textForAssertion1 = excelReader.getStringData("UpdateAddress", 14, 4);
		String textForAssertion2 = excelReader.getStringData("UpdateAddress", 15, 4);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		boolean result = myAddressesPage.textFromFirstAddress().equals(textForAssertion1)
				&& myAddressesPage.textFromSecondAddress().equals(textForAssertion2);
		assertTrue(result);
	}

	@Test(priority = 2)
	public void updateAddressInvalidInputSpecialCharacters() {
		String address = excelReader.getStringData("UpdateAddress", 24, 3);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 29, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textInvalidAddress();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 3)
	public void updateAddressesInvalidInputSpace() {
		String address = excelReader.getStringData("UpdateAddress", 24, 5);
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 25, 5);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 29, 5);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		int present = yourAddressesPage.numberOfElements();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = yourAddressesPage.textInvalidAddress();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}

	}

	@Test(priority = 4)
	public void updateAddressFurtherReferencesInvalidInputSpecialCharacters() {
		String address = excelReader.getStringData("UpdateAddress", 24, 6);
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 25, 6);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 29, 6);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		int present = yourAddressesPage.numberOfElements();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = yourAddressesPage.textInvalidAddress();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}
	}

	@Test(priority = 5)
	public void updateAddressEmptyField() {
		String textForAssertion = excelReader.getStringData("UpdateAddress", 47, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.getAddressField().clear();
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textForEmptyUpdateAddressFiled();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 6)
	public void updateAddressFurtherReferencesEmptyField() {
		String textForAssertion = excelReader.getStringData("UpdateAddress", 47, 4);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.getFutureReferenceAddressField().clear();
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textFromEmptyReferenceAddressField();
		assertEquals(actualText, textForAssertion);
	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
