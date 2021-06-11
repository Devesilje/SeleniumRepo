package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
WebDriver driver;
	WebElement myAccountLabel;
	WebElement myAddressesButton;
	

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
	

}
