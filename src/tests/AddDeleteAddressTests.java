package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddDeleteAddressTests extends BaseTests {

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
	public void addAddressValidInput() {
		String firstName = excelReader.getStringData("AddAddress", 11, 3);
		String lastName = excelReader.getStringData("AddAddress", 12, 3);
		String address = excelReader.getStringData("AddAddress", 13, 3);
		String city = excelReader.getStringData("AddAddress", 14, 3);
		String postalCode = excelReader.getStringData("AddAddress", 16, 3);
		String homePhone = String.valueOf(excelReader.getIntegerData("AddAddress", 18, 3));
		String mobilePhone = String.valueOf(excelReader.getIntegerData("AddAddress", 19, 3));
		String addressFurtherReference = excelReader.getStringData("AddAddress", 20, 3);
		String textForAssertion = excelReader.getStringData("AddAddress", 22, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnAddAddressButton();
		yourAddressesPage.insertFirstname(firstName);
		yourAddressesPage.insertLastname(lastName);
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertCity(city);
		yourAddressesPage.clickOnDropdownMenu();
		yourAddressesPage.clickOnFirstCountry();
		yourAddressesPage.insertPostalCode(postalCode);
		yourAddressesPage.insertHomePhone(homePhone);
		yourAddressesPage.insertMobilePhone(mobilePhone);
		yourAddressesPage.insertFutureReferenceAddress(addressFurtherReference);
		yourAddressesPage.clickOnSaveButton();
		String actualText = myAddressesPage.textFromSecondAddressDeleteButton();
		assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 1)
	public void addAddressEmptyFields() {
		String textForAssertion = excelReader.getStringData("AddAddress", 47, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnAddAddressButton();
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textForEmptyUpdateAddressFiled();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 2)
	public void deleteAddress() throws InterruptedException {
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnSecondAddressDeleteButton();
		driver.switchTo().alert().accept();
		myAddressesPage.EnterClick();
		int present = myAddressesPage.numberOfElementsDeleting();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			actual = false;
		} else {
			actual = true;
		}
		assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void addAddressValidInputSpecialCharacters() {
		String firstName = excelReader.getStringData("AddAddress", 61, 3);
		String lastName = excelReader.getStringData("AddAddress", 62, 3);
		String address = excelReader.getStringData("AddAddress", 63, 3);
		String city = excelReader.getStringData("AddAddress", 64, 3);
		String postalCode = excelReader.getStringData("AddAddress", 66, 3);
		String homePhone = excelReader.getStringData("AddAddress", 68, 3);
		String mobilePhone = excelReader.getStringData("AddAddress", 69, 3);
		String addressFurtherReference = excelReader.getStringData("AddAddress", 70, 3);
		String textForAssertion = excelReader.getStringData("AddAddress", 73, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnAddAddressButton();
		yourAddressesPage.insertFirstname(firstName);
		yourAddressesPage.insertLastname(lastName);
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertCity(city);
		yourAddressesPage.clickOnDropdownMenu();
		yourAddressesPage.clickOnFirstCountry();
		yourAddressesPage.insertPostalCode(postalCode);
		yourAddressesPage.insertHomePhone(homePhone);
		yourAddressesPage.insertMobilePhone(mobilePhone);
		yourAddressesPage.insertFutureReferenceAddress(addressFurtherReference);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textErrorMessage();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 4)
	public void addAddressValidInputSpace() {
		String firstName = excelReader.getStringData("AddAddress", 61, 4);
		String lastName = excelReader.getStringData("AddAddress", 62, 4);
		String address = excelReader.getStringData("AddAddress", 63, 4);
		String city = excelReader.getStringData("AddAddress", 64, 4);
		String postalCode = excelReader.getStringData("AddAddress", 66, 4);
		String homePhone = excelReader.getStringData("AddAddress", 68, 4);
		String mobilePhone = excelReader.getStringData("AddAddress", 69, 4);
		String addressFurtherReference = excelReader.getStringData("AddAddress", 70, 4);
		String textForAssertion = excelReader.getStringData("AddAddress", 73, 4);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnAddAddressButton();
		yourAddressesPage.insertFirstname(firstName);
		yourAddressesPage.insertLastname(lastName);
		yourAddressesPage.insertAddress(address);
		yourAddressesPage.insertCity(city);
		yourAddressesPage.clickOnDropdownMenu();
		yourAddressesPage.clickOnFirstCountry();
		yourAddressesPage.insertPostalCode(postalCode);
		yourAddressesPage.insertHomePhone(homePhone);
		yourAddressesPage.insertMobilePhone(mobilePhone);
		yourAddressesPage.insertFutureReferenceAddress(addressFurtherReference);
		yourAddressesPage.clickOnSaveButton();
		int present = yourAddressesPage.numberOfErrorAdd();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = yourAddressesPage.textErrorMessage();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}

	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
