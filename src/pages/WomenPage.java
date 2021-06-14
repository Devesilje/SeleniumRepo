package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenPage {

	WebDriver driver;
	WebElement firstDress;
	WebElement firstDressWishlist;
	WebElement firstTshirtWishlist;
	WebElement xPopUp;
	
	public WebElement getFirstDress() {
		return driver.findElement(By.cssSelector(".replace-2x.img-responsive"));
	}
	public WebElement getxPopUp() {
		return driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
	}

	public WebElement getFirstDressWishlist() {
		return driver.findElement(By.cssSelector(".addToWishlist.wishlistProd_3"));
	}

	public WomenPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void clickOnFirstDressWishList() {
		this.getFirstDressWishlist().click();
	}
	public void clickOnXPopUp() {
		this.getxPopUp().click();
	}
	public void hoverFirstDress() {
		Actions builder = new Actions(driver);
		 WebElement element = driver.findElement(By.cssSelector(".replace-2x.img-responsive"));
		 builder.moveToElement(element).build().perform();
		
	}
	public void  clickOnFirstDress() {
		this.getFirstDress().click();
	}

}
