package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage {

	WebDriver driver;
	WebElement updateAddressField;
	WebElement saveButton;
	WebElement emptyFieldLabel;
	WebElement addressField;
	WebElement cityField;
	WebElement stateDropdownMenu;
	WebElement firstCountry;
	WebElement homePhoneFieled;
	WebElement mobilePhoneField;
	WebElement zipPostalCode;
	

	public WebElement getZipPostalCode() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getMobilePhoneField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getHomePhoneField() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getFirstCountry() {
		return driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]"));
	}

	public WebElement getStateDropdownMenu() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public YourAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getEmptyFiledLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	public WebElement getUpdateAddressField() {
		return driver.findElement(By.id("alias"));
	}
	public void insertAddressForUpdate (String address) {
		this.getUpdateAddressField().clear();
		this.getUpdateAddressField().sendKeys(address);
	}
	public void insertAddress(String address) {
		this.getAddressField().clear();
		this.getAddressField().sendKeys(address);
	}
	public void insertCity(String city) {
		this.getCityField().clear();
		this.getCityField().sendKeys(city);
	}
	public void clickOnSaveButton() {
		this.getSaveButton().click();
	}
	public void clearUpdateAddressField() {
		this.getUpdateAddressField().clear();
	}
	public String textForEmptyUpdateAddressFiled() {
		return this.getEmptyFiledLabel().getText();
	}
	public void clickOnDropdownMenu() {
		this.getStateDropdownMenu().click();
	}
	public void clickOnFirstCountry() {
		this.getFirstCountry().click();
	}
	
}