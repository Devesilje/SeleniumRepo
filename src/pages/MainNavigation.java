package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.VolTypesDocumentImpl;

public class MainNavigation {

	WebDriver driver;
	WebElement signInTab;
	WebElement signOutTab;
	WebElement myAccountTab;
	WebElement womenTab;
	
	public WebElement getWomenTab() {
		return driver.findElement(By.className("sf-with-ul"));
	}

	public WebElement getMyAccountTab() {
		return driver.findElement(By.className("account"));
	}

	public WebElement getSignOutTab() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getSignInTab() {
		return driver.findElement(By.className("login"));
	}

	public MainNavigation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void clickOnSignIn () {
		this.getSignInTab().click();
	}
	public void clickOnSignOut () {
		this.getSignOutTab().click();
	}
	public void clicOnMyAccountTab() {
		this.getMyAccountTab().click();
	}
	public void clickOnWomenTab() {
		this.getWomenTab().click();
	}

}
