package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInfoPage {

	WebDriver driver;
	WebElement firstNameField;
	WebElement lasteNameFiled;
	WebElement dayDropDownMenu;
	WebElement monthDropDownMenu;
	WebElement yearDropDownMenu;
	WebElement saveButton;
	WebElement passwordField;
	WebElement emailFiled;
	WebElement successUpdate;
	WebElement invalidPasswordMessage;
	WebElement errorMessage;
	WebElement invalidFirstLastname;
	WebElement emptyFirstNameMessage;
	

	
	public WebElement getEmptyFirstNameMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
	}
	public WebElement getInvalidFirstLastname() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
	}
	public WebElement getSuccessUpdate() {
		return driver.findElement(By.cssSelector(".alert.alert-success"));
	}
	public WebElement getErrorMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
	}
	


	public WebElement getInvalidPasswordMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
	}


	public WebElement getEmailFiled() {
		return driver.findElement(By.id("email"));
	}


	public MyPersonalInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}


	public WebElement getLasteNameFiled() {
		return driver.findElement(By.id("lastname"));
	}


	public WebElement getDayDropDownMenu() {
		return driver.findElement(By.id("days"));
	}


	public WebElement getMonthDropDownMenu() {
		return driver.findElement(By.id("months"));
	}


	public WebElement getYearDropDownMenu() {
		return driver.findElement(By.id("years"));
	}


	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}


	public WebElement getPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}
	
	public void insertFirstName(String name) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(name);
	}
	public void insertLastName (String lastname) {
		this.getLasteNameFiled().clear();
		this.getLasteNameFiled().sendKeys(lastname);
	}
	public void insertEmail(String email) {
		this.getEmailFiled().clear();
		this.getEmailFiled().sendKeys(email);
	}
	public void clickOnDayButton() {
		this.getDayDropDownMenu().click();
	}
	public void clickOnMonthButton() {
		this.getMonthDropDownMenu().click();
	}
	public void clickOnYearButton() {
		this.getYearDropDownMenu().click();
	}
	public void insertPassword (String password) {
		this.getPasswordField().sendKeys(password);
	}
	public void clickOnSaveButton() {
		this.getSaveButton().click();
	}
	public String textForSuccessUpdate() {
		return this.getSuccessUpdate().getText();
	}
	public String textInvalidPasswordMessage() {
		return this.getInvalidPasswordMessage().getText();
	}
	public String textInvalidFirstLastname() {
		return this.getInvalidFirstLastname().getText();
	}
	public int numberOfElementsErrorMessage () {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li")).size();
	}
	public String textErrorMessage() {
		return this.getErrorMessage().getText();
	}

}
