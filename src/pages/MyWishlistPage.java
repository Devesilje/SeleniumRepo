package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage {

	WebDriver driver;
	WebElement wishlistNameFiled;
	WebElement saveWishlistButton;
	WebElement firstWishlist;
	WebElement deleteIcon;
	WebElement numberOfItemsFirstWishlist;
	
	
	public WebElement getNumberOfItemsFirstWishlist() {
		return driver.findElement(By.cssSelector(".bold.align_center"));
	}



	public WebElement getDeleteIcon() {
		return driver.findElement(By.className("icon-remove"));
	}



	public WebElement getFirstWishlist() {
		return driver.findElement(By.cssSelector(".table.table-bordered"));
	}



	public WebElement getSaveWishlistButton() {
		return driver.findElement(By.id("submitWishlist"));
	}



	public WebElement getWishlistNameFiled() {
		return driver.findElement(By.id("name"));
	}



	public MyWishlistPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void insertWishlistName (String name) {
		this.getWishlistNameFiled().sendKeys(name);
	}
	public void clickOnSaveWishlist() {
		this.getSaveWishlistButton().click();
	
	}
	public String textFromFirstWishlist() {
		return getFirstWishlist().getText();
	}
	public void clickOnDeleteIcon() {
		this.getDeleteIcon().click();
	}
	public String textFromNumberItemsFirstWishlist() {
		return getNumberOfItemsFirstWishlist().getText();
	}
	public WebElement getEnterButton() {
		return driver.findElement(By.id("module-blockwishlist-mywishlist"));

	}
	public void EnterClick() {
		this.getEnterButton().sendKeys(Keys.ENTER);
		
	}
}
