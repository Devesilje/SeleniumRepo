package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingProductToCart extends BaseTests{

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
	@Test (priority = 0)
	public void addOneItem() throws InterruptedException {
		String textForAssertion = excelReader.getStringData("AddingItemsToCart", 12, 3);
		mainNavigation.clickOnWomenTab();
		womenPage.clickOnFirstDress();
		firstDressPrinted.clickOnAddToCartButton();
		Thread.sleep(2000);
		String actualText = firstDressPrinted.textFromQuantity();
		assertEquals(actualText, textForAssertion);
	}
	@Test (priority = 1)
	public void removeItemFromCart() throws InterruptedException{
		String textForAssertion = excelReader.getStringData("AddingItemsToCart", 43, 3);
		mainNavigation.clickOnWomenTab();
		womenPage.clickOnFirstDress();
		firstDressPrinted.clickOnAddToCartButton();
		Thread.sleep(1000);
		firstDressPrinted.clickOnXAddToCart();
		mainNavigation.clickOnCart();
		cartpage.clickTrashIcon();
		Thread.sleep(2000);
		String actualText = mainNavigation.textFromCart();
		assertEquals(actualText, textForAssertion);
	}
	@Test (priority = 2)
	public void changeSizeQuantity() throws InterruptedException {
		String quantity = excelReader.getStringData("AddingItemsToCart", 22, 3);
		String size = excelReader.getStringData("AddingItemsToCart", 23, 3);
		String textForAssertion = excelReader.getStringData("AddingItemsToCart", 26, 3);
		String textForAssertion1 = excelReader.getStringData("AddingItemsToCart", 27, 3);
		mainNavigation.clickOnWomenTab();
		womenPage.clickOnFirstDress();
		firstDressPrinted.insertQuantity(quantity);
		Select drpSize = new Select(firstDressPrinted.getSizeDropDownMenu());
		drpSize.selectByValue(size);
		firstDressPrinted.clickOnAddToCartButton();
		Thread.sleep(2000);
		boolean result = firstDressPrinted.textFromQuantity().equals(textForAssertion)
				&& firstDressPrinted.textFromSizeAtributeLabel().equals(textForAssertion1);
		assertTrue(result);
	}
	@Test(priority = 3)
	public void addMultupleItemsToCart() throws InterruptedException{
		String textForAssertion = excelReader.getStringData("AddingItemsToCart", 60, 3);
		mainNavigation.clickOnWomenTab();
		womenPage.clickOnListOption();
		womenPage.clickOnFirstItemAddToCart();
		womenPage.clickX();
		Thread.sleep(2000);
		womenPage.clickOnSecondItemAddToCart();
		womenPage.clickX();
		Thread.sleep(2000);
		womenPage.clickOnThirdItemAddToCart();
		womenPage.clickX();
		Thread.sleep(2000);
		String actualText = mainNavigation.textFromCart();
		assertEquals(actualText, textForAssertion);
		
	}
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
