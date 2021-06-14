package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstDressPrinted {

	WebDriver driver;
	WebElement addToWishlist;
	
	
	public FirstDressPrinted(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public WebElement getAddToWishlist() {
		return driver.findElement(By.id("wishlist_button"));
	}
	public void clickAddToWishlist() {
		this.getAddToWishlist().click();
	}

}
