package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wishlist extends BaseTests{

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
		
	}/*
	
	
	@Test(priority = 0)
	public void addWishlist () {
		String name = excelReader.getStringData("MyWishlist", 10, 3);
		String textForAssertion = excelReader.getStringData("MyWishlist", 14, 3);
		myAccountPage.clickOnMyWishlistButton();
		myWishlistPage.insertWishlistName(name);
		myWishlistPage.clickOnSaveWishlist();
		String actualText = myWishlistPage.textFromFirstWishlist();
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test(priority = 0)
	public void addItemToWishlist () throws InterruptedException{
		String textForAssertion = excelReader.getStringData("MyWishlist", 31, 3);
		mainNavigation.clickOnWomenTab();
		womenPage.hoverFirstDress();
		womenPage.clickOnFirstDressWishList();
		womenPage.clickOnXPopUp();
		mainNavigation.clicOnMyAccountTab();
		myAccountPage.clickOnMyWishlistButton();
		String actualText = myWishlistPage.textFromNumberItemsFirstWishlist();
		assertEquals(actualText, textForAssertion);
	}*/
	@Test (priority = 1)
	public void deleteWishlist () throws InterruptedException{
		myAccountPage.clickOnMyWishlistButton();
		myWishlistPage.clickOnDeleteIcon();
		driver.switchTo().alert().accept();
		myWishlistPage.EnterClick();
		Thread.sleep(2000);
	
		int present = driver.findElements(By.className("first_item")).size();
		boolean expected = false;
		boolean actual;

		if (present>0) {
			actual = true;
		} else {
			actual = false;
		}
		assertEquals(actual, expected);}
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
