package tests;

import static org.testng.Assert.assertEquals;

import org.apache.batik.anim.dom.SVGStylableElement.PresentationAttributeColorValue;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAddress extends BaseTests {
	
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
	public WebElement getEnterButton() {
		return driver.findElement(By.xpath("/html/body"));

	}
	public void EnterClick() {
		this.getEnterButton().sendKeys(Keys.ENTER);
		
	}
	
	@Test (priority = 0)
	public void addAddressValidInput() {
		String address = excelReader.getStringData("AddAddress", 9, 3);
		String city = excelReader.getStringData("AddAddress", 10, 3);
		String postalCode = excelReader.getStringData("AddAddress", 12, 3);
		//String password = String.valueOf(citacIzExcela.getIntegerData("LogInTests", 5, 2));
		String homePhone = String.valueOf(excelReader.getIntegerData("AddAddress", 14, 3));
		String mobilePhone = String.valueOf(excelReader.getIntegerData("AddAddress", 15, 3));
		String addressFurtherReference = excelReader.getStringData("AddAddress", 16, 3);
		String textForAssertion = excelReader.getStringData("AddAddress", 18, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnAddAddressButton();
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
	@Test (priority = 1)
	public void addAddressEmptyField() {
		String city = excelReader.getStringData("AddAddress", 10, 3);
		String postalCode = excelReader.getStringData("AddAddress", 12, 3);
		String homePhone = String.valueOf(excelReader.getIntegerData("AddAddress", 14, 3));
		String mobilePhone = String.valueOf(excelReader.getIntegerData("AddAddress", 15, 3));
		String addressFurtherReference = excelReader.getStringData("AddAddress", 16, 3);
		String textForAssertion = excelReader.getStringData("AddAddress", 39, 3);
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnAddAddressButton();
		yourAddressesPage.insertCity(city);
		yourAddressesPage.clickOnDropdownMenu();
		yourAddressesPage.clickOnFirstCountry();
		yourAddressesPage.insertPostalCode(postalCode);
		yourAddressesPage.insertHomePhone(homePhone);
		yourAddressesPage.insertMobilePhone(mobilePhone);
		yourAddressesPage.insertFutureReferenceAddress(addressFurtherReference);
		yourAddressesPage.clickOnSaveButton();
		String actualText = yourAddressesPage.textForEmptyUpdateAddressFiled();
		assertEquals(actualText, textForAssertion);

	}
	@Test (priority = 2)
	public void deleteAddress () throws InterruptedException{
		myAccountPage.clickOnMyAddressesButton();
		myAddressesPage.clickOnSecondAddressDeleteButton();
	
		driver.switchTo().alert().accept(); 
		EnterClick();
		int present = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul")).size(); 
		if (present>0) {
			System.out.println("Test Faild");
		} else {
			System.out.println("Test Passed");
		}
	}
	
	
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
