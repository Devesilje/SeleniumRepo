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
	WebElement secondWishlist;
	WebElement numberOfItemsSecondWishlist;
	
	
	public WebElement getNumberOfItemsSecondWishlist() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[2]/td[2]"));
	}



	public WebElement getSecondWishlist() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[2]/td[1]"));
	}



	public WebElement getNumberOfItemsFirstWishlist() {
		return driver.findElement(By.cssSelector(".bold.align_center"));
	}



	public WebElement getDeleteIcon() {
		return driver.findElement(By.className("icon-remove"));
	}



	public WebElement getFirstWishlist() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a"));
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
	public String textFromSecondWishlist() {
		return this.getSecondWishlist().getText();
	}
	public String textFromNumberIntemsSecondWishlist() {
		return this.getNumberOfItemsSecondWishlist().getText();
	}
	public int numberOfElementsWishlists () {
		return driver.findElements(By.xpath("//*[@id=\"block-history\"]/table")).size();
	}
}
