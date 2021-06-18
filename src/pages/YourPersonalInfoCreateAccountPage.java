package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class YourPersonalInfoCreateAccountPage {

	WebDriver driver;
	WebElement futureReferenceAddressField;
	WebElement registerButton;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement emailField;
	WebElement passwordField;
	WebElement addressField;
	WebElement cityField;
	WebElement stateDropdownMenu;
	WebElement firstCountry;
	WebElement homePhoneFieled;
	WebElement mobilePhoneField;
	WebElement zipPostalCode;
	WebElement errorMessage;
	WebElement emptyFiledsLabel;
	
	public WebElement getEmptyFiledsLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div"));
	}
	public WebElement getFirstNameField() {
		return driver.findElement(By.id("customer_firstname"));
	}
	public WebElement getLastNameField() {
		return driver.findElement(By.id("customer_lastname"));
	}
	public WebElement getEmailField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}
	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}
	public WebElement getZipPostalCode() {
		return driver.findElement(By.id("postcode"));
	}
	public WebElement getStateDropdownMenu() {
		return driver.findElement(By.id("id_state"));
	}
	public WebElement getMobilePhoneField() {
		return driver.findElement(By.id("phone_mobile"));
	}
	public WebElement getHomePhoneField() {
		return driver.findElement(By.id("phone"));
	}
	public WebElement getFutureReferenceAddressField() {
		return driver.findElement(By.id("alias"));
	}
	public WebElement getRegisterButton() {
		return driver.findElement(By.id("submitAccount"));
	}

	public WebElement getFirstCountry() {
		return driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]"));
	}

	
	public WebElement getErrorMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
	}

	public YourPersonalInfoCreateAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void insertFutureReferenceAddress (String address) {
		this.getFutureReferenceAddressField().clear();
		this.getFutureReferenceAddressField().sendKeys(address);
	}
	public void insertFirstname(String name) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(name);
	}
	public void insertLastname(String name) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(name);
	}
	public void insertEmail(String name) {
		this.getEmailField().clear();
		this.getEmailField().sendKeys(name);
	}
	public void insertPassword(String password) {
		this.getPasswordField().clear();
		this.getPasswordField().sendKeys(password);
	}
	public void insertAddress(String address) {
		this.getAddressField().clear();
		this.getAddressField().sendKeys(address);
	}
	public void insertCity(String city) {
		this.getCityField().clear();
		this.getCityField().sendKeys(city);
	}
	public void insertPostalCode(String postalCode) {
		this.getZipPostalCode().clear();
		this.getZipPostalCode().sendKeys(postalCode);
	}
	public void insertHomePhone(String homePhone) {
		this.getHomePhoneField().clear();
		this.getHomePhoneField().sendKeys(homePhone);
	}
	public void insertMobilePhone(String mobilePhone) {
		this.getMobilePhoneField().clear();
		this.getMobilePhoneField().sendKeys(mobilePhone);
	}
	public void clickOnRegisterButton() {
		this.getRegisterButton().click();
	}
	
	public void clickOnDropdownMenu() {
		this.getStateDropdownMenu().click();
	}
	public void clickOnFirstCountry() {
		this.getFirstCountry().click();
	}
	
	public int numberOfElements () {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li")).size();
	}
	public int numberOfErrorElements() {
		return driver.findElements(By.xpath("//*[@id=\\\"center_column\\\"]/div/div")).size();
	}
	
	public String textFromEmptyFiledsLabel() {
		return getEmptyFiledsLabel().getText();
	}
	public int numberOfErrorAdd() {
		return driver.findElements(By.cssSelector(".alert.alert-danger")).size();
		
	}
	public String textFromErrorMessage() {
		return this.getErrorMessage().getText();
	}
	

}
