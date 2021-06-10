package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.VolTypesDocumentImpl;

public class MainNavigation {

	WebDriver driver;
	WebElement signInButton;
	WebElement signOutButton;
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}

	public MainNavigation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickOnSignIn () {
		this.getSignInButton().click();
	}
	public void clickOnSignOut () {
		this.getSignOutButton().click();
	}

}
