package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	WebDriver driver;
	WebElement emailFiled;
	WebElement passwordFiled;
	WebElement signInButton;
	WebElement invalidEmailLabel;
	WebElement invalidPasswordLabel;
	WebElement emptyEmailFieldsLabel;
	WebElement emptyPasswordFieldLabel;
	WebElement forgotYourPassword;
	
	
	public WebElement getForgotYourPassword() {
		return driver.findElement(By.cssSelector(".lost_password.form-group"));
	}
	public WebElement getEmptyPasswordFieldLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	public LogInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getEmailFiled() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordFiled() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public void clickOnSignIn () {
		this.getSignInButton().click();
	}
	public void insertEmail (String email) {
		this.getEmailFiled().clear();
		this.getEmailFiled().sendKeys(email);
	}
	public void insertPassword (String password) {
		this.getPasswordFiled().clear();
		this.getPasswordFiled().sendKeys(password);
	}
	public WebElement getEmptyEmailFieldLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public WebElement getInvalidPasswordLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public WebElement getInvalidEmailLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	public String textFromInvalidEmailLabel() {
		return this.getInvalidEmailLabel().getText();
	}
	public String textFromInvalidPasswordLabel() {
		return this.getInvalidPasswordLabel().getText();
	}
	public String textFromEmptyEmailFieldLabel() {
		return this.getEmptyEmailFieldLabel().getText();
	}
	public String textFromSignInButton() {
		return this.getSignInButton().getText();
	}
	public String textFromEmptyPasswordFieldLabel() {
		return this.getEmptyPasswordFieldLabel().getText();
	}
}
