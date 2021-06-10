package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {
	

	WebElement updateButton;
	WebDriver driver;
	WebElement myAddressField;

	public WebElement getUpdateButton() {
		return driver.findElement(By.cssSelector(".btn.btn-default.button.button-small"));
	}
	public void clickOnUpdateButton() {
		this.getUpdateButton().click();
	}
	public WebElement getMyAddressField() {
		return driver.findElement(By.id("alias"));
	}
	public void insertAddress (String address) {
		this.getMyAddressField().clear();
		this.getMyAddressField().sendKeys(address);
	}
}
