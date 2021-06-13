package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UpdateAddress extends BaseTests{
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
		String address = excelReader.getStringData("UpdateAddress", 12, 3);
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 13, 3);
		String textForAssertion1 = excelReader.getStringData("UpdateAddress", 17, 3);
		String textForAssertion2 = excelReader.getStringData("UpdateAddress", 18, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		String actualText1 = myAddressesPage.textFromFirstAddress();
		assertEquals(actualText1, textForAssertion1);
		String actualText2 = myAddressesPage.textFromSecondAddress();
		assertEquals(actualText2, textForAssertion2);
	} 
	@Test(priority = 1)
	public void updateAddressValidInputDifferentReferenceAddress() {
		String address = excelReader.getStringData("UpdateAddress", 12, 4);
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 13, 4);
		String textForAssertion1 = excelReader.getStringData("UpdateAddress", 17, 4);
		String textForAssertion2 = excelReader.getStringData("UpdateAddress", 18, 4);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		String actualText1 = myAddressesPage.textFromFirstAddress();
		assertEquals(actualText1, textForAssertion1);
		String actualText2 = myAddressesPage.textFromSecondAddress();
		assertEquals(actualText2, textForAssertion2);
	}
	
	@Test(priority = 2)
	public void updateAddressInvalidInputSpecialCharacters() {
		String address = excelReader.getStringData("UpdateAddress", 30, 3);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 35, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textInvalidAddress();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 3)
	public void updateAddressInvalidInputSpace() {
		String address = excelReader.getStringData("UpdateAddress", 30, 5);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 35, 5);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textInvalidAddress();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 4)
	public void updateAddressEmptyField() {
		String textForAssertion = excelReader.getStringData("UpdateAddress", 53, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.getAddressField().clear();
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textForEmptyUpdateAddressFiled();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 5)
	public void updateAddressFurtherReferencesInvalidInputSpecialCharacters() {
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 66, 3);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 70, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textFromNavigationElement();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 6)
	public void updateAddressFurtherReferencesInvalidInputSpaceCharacters() {
		String futureReferenceAddress = excelReader.getStringData("UpdateAddress", 66, 5);
		String textForAssertion = excelReader.getStringData("UpdateAddress", 70, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnUpdateButton();
		yourAddressesPage.insertFutureReferenceAddress(futureReferenceAddress);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textFromNavigationElement();
		assertEquals(actualText, textForAssertion);
	}
	@Test(priority = 7)
	public void updateAddressFurtherReferencesEmptyField() {
		String textForAssertion = excelReader.getStringData("UpdateAddress", 89, 3);
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
