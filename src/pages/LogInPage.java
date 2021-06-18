package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInPage {

	WebDriver driver;
	WebElement emailFieled;
	WebElement passwordFieled;
	WebElement signInButton;
	WebElement invalidEmailLabel;
	WebElement invalidPasswordLabel;
	WebElement emptyEmailFieldsLabel;
	WebElement emptyPasswordFieldLabel;
	WebElement forgotYourPassword;
	WebElement emailCreatingAccountField;
	WebElement createAccountButton;
	WebElement createAccountError;
	
	
	public LogInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getCreateAccountButton() {
		return driver.findElement(By.id("SubmitCreate"));
	}

	public WebElement getEmailCreatingAccountField() {
		return driver.findElement(By.id("email_create"));
	}
	public WebElement getForgotYourPassword() {
		return driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/p[1]/a"));
	}
	public WebElement getEmptyPasswordFieldLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
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
	
	public WebElement getCreateAccountError() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
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
	public void clickOnForgotYourPassword() {
		this.getForgotYourPassword().click();
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
	public int numberOfElements () {
		return driver.findElements(By.cssSelector(".alert.alert-danger")).size();
	}
	public void insertEmailCreatingAccount(String email) {
		this.getEmailCreatingAccountField().sendKeys(email);
	}
	public void clickOnCreateAccountButton() {
		this.getCreateAccountButton().click();
	}
	public String textFromCreateAccountError() {
		return this.getCreateAccountError().getText();
	}
	public int numberOfElementsErrorCreateAccount() {
		return driver.findElements(By.id("create_account_error")).size();
	}
}
