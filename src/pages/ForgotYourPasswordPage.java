package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotYourPasswordPage {
	

	WebElement forgotYourPasswordLabel;
	WebDriver driver;
	WebElement email;
	WebElement retrievePasswordButton;

	public WebElement getRetrievePasswordButton() {
		return driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.className("form-control"));
	}

	public WebElement getForgotYourPasswordLabel() {
		return driver.findElement(By.className("page-subheading"));
	}

}
