package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wishlist extends BaseTests {

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
	public void addWishlist() {
		String name = excelReader.getStringData("MyWishlist", 8, 3);
		String textForAssertion = excelReader.getStringData("MyWishlist", 12, 3);
		myAccountPage.clickOnMyWishlistButton();
		myWishlistPage.insertWishlistName(name);
		myWishlistPage.clickOnSaveWishlist();
		String actualText = myWishlistPage.textFromFirstWishlist();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 1)
	public void addItemToWishlist() throws InterruptedException {
		String textForAssertion = excelReader.getStringData("MyWishlist", 26, 3);
		mainNavigation.clickOnWomenTab();
		wd.until(ExpectedConditions.elementToBeClickable(womenPage.getFirstDress()));
		womenPage.hoverFirstDress();
		womenPage.clickOnFirstDress();
		firstDressPrinted.clickAddToWishlist();
		womenPage.clickOnXPopUp();
		mainNavigation.clicOnMyAccountTab();
		myAccountPage.clickOnMyWishlistButton();
		String actualText = myWishlistPage.textFromNumberItemsFirstWishlist();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test(priority = 2)
	public void deleteWishlist() throws InterruptedException {
		myAccountPage.clickOnMyWishlistButton();
		myWishlistPage.clickOnDeleteIcon();
		driver.switchTo().alert().accept();
		myWishlistPage.EnterClick();
		Thread.sleep(2000);
		int present = myWishlistPage.numberOfElementsWishlists();
		boolean expected = false;
		boolean actual;
		if (present > 0) {
			actual = true;
		} else {
			actual = false;
		}
		assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void addMultipleWishlists() {
		addWishlist();
		String name = excelReader.getStringData("MyWishlist", 63, 3);
		String textForAssertion = excelReader.getStringData("MyWishlist", 67, 3);
		String textForAssertion1 = excelReader.getStringData("MyWishlist", 66, 3);
		myWishlistPage.insertWishlistName(name);
		myWishlistPage.clickOnSaveWishlist();
		boolean result = myWishlistPage.textFromFirstWishlist().equals(textForAssertion)
				&& myWishlistPage.textFromSecondWishlist().equals(textForAssertion1);
		assertTrue(result);
	}

	@Test(priority = 4)
	public void addItemToSecondWishlist() throws InterruptedException {
		String textForAssertion = excelReader.getStringData("MyWishlist", 87, 3);
		mainNavigation.clickOnWomenTab();
		Thread.sleep(1000);
		womenPage.clickOnFirstDress();
		firstDressPrinted.clickAddToWishlist();
		womenPage.clickOnXPopUp();
		mainNavigation.clicOnMyAccountTab();
		myAccountPage.clickOnMyWishlistButton();
		String actualText = myWishlistPage.textFromNumberIntemsSecondWishlist();
		assertEquals(actualText, textForAssertion);
	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
