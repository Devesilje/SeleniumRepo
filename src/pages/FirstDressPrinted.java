package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstDressPrinted {

	WebDriver driver;
	WebElement addToWishlist;
	WebElement quantity;
	WebElement addToCartButton;
	WebElement quantityField;
	WebElement xIconAddToCart;
	WebElement sizeDropDownMenu;
	WebElement sizeAtributeLabel;
	

	public WebElement getSizeAtributeLabel() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart_product_attributes\"]"));
	}


	public WebElement getSizeDropDownMenu() {
		return driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
	}


	public WebElement getxIconAddToCart() {
		return driver.findElement(By.className("cross"));
	}


	public WebElement getQuantityField() {
		return driver.findElement(By.id("quantity_wanted"));
	}


	public WebElement getAddToCart() {
		return driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
	}


	public WebElement getQuantity() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart_product_quantity\"]"));
	}


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
	public String textFromQuantity() {
		return this.getQuantity().getText();
	}
	public void clickOnAddToCartButton() {
		this.getAddToCart().click();
	}
	public void insertQuantity (String number) {
		this.getQuantityField().clear();
		this.getQuantityField().sendKeys(number);
	}
	public void clickOnXAddToCart () {
		this.getxIconAddToCart().click();
	}
	public String textFromSizeAtributeLabel() {
		return this.getSizeAtributeLabel().getText();
	}
}
