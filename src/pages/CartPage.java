package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;
	WebElement trashIcon;
	
	public WebElement getTrashIcon() {
		return driver.findElement(By.className("cart_quantity_delete"));
	}
	
	public void clickTrashIcon () {
		this.getTrashIcon().click();
	}

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
