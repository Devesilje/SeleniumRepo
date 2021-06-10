package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
WebDriver driver;
	WebElement myAccountLabel;
	WebElement myAddressesButton;
	WebElement updateButton;
	
	

	public WebElement getUpdateButton() {
		return driver.findElement(By.cssSelector(".btn.btn-default.button.button-small"));
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
	public void clickOnMyAddresses() {
		this.getMyAddressesButton().click();
	}
	public void clickOnUpdateButton() {
		this.getUpdateButton().click();
	}

}
