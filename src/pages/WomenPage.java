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
	WebElement listOption;
	WebElement firstItemAddToCartButton;
	WebElement secondItemAddToCartButton;
	WebElement thirdItemAddToCartButton;
	WebElement firstItemXIcon;
	
	public WebElement getListOption() {
		return driver.findElement(By.xpath("//*[@id=\"list\"]/a/i"));
	}
	public WebElement getFirstDress() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a"));
	}
	public WebElement getxPopUp() {
		return driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
	}

	public WebElement getFirstItemAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[2]/a[1]/span"));
	}
	public WebElement getSecondItemAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div/div[3]/div/div[2]/a[1]/span"));
	}
	public WebElement getThirdItemAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div/div[3]/div/div[2]/a[1]/span"));
	}
	public WebElement getFirstItemXIcon() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
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
	public void clickOnListOption() {
		this.getListOption().click();
	}
	public void clickOnFirstItemAddToCart() {
		this.getFirstItemAddToCartButton().click();
	}
	public void clickOnSecondItemAddToCart() {
		this.getSecondItemAddToCartButton().click();
	}
	public void clickOnThirdItemAddToCart() {
		this.getThirdItemAddToCartButton().click();
	}
	public void clickX () {
		this.getFirstItemXIcon().click();
	}

}
