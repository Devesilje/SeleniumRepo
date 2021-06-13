package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bsh.commands.dir;

public class MyAccountPage {
	
WebDriver driver;
	WebElement myAccountLabel;
	WebElement myAddressesButton;
	WebElement myPersonalInfoButton;
	WebElement myWishlistButton;

	public WebElement getMyWishlistButton() {
		return driver.findElement(By.className("icon-heart"));
	}

	public WebElement getMyPersonalInfoButton() {
		return driver.findElement(By.className("icon-user"));
	}

	public WebElement getMyAddressesButton() {
		return driver.findElement(By.className("icon-building"));
	}

	public WebElement getMyAccountLabel() {
		return driver.findElement(By.className("page-heading"));
	}

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public String textFromMyAccountLabel() {
		return this.getMyAccountLabel().getText();
	}
	public void clickOnMyAddressesButton() {
		this.getMyAddressesButton().click();
	}
	public void clickOnMyPersonalInfoButton() {
		this.getMyPersonalInfoButton().click();
	}
	public void clickOnMyWishlistButton() {
		this.getMyWishlistButton().click();
	}

}
