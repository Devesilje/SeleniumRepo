package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage {

	WebDriver driver;
	WebElement futureReferenceAddressField;
	WebElement saveButton;
	WebElement emptyReferenceAddressFieldLabel;
	WebElement addressField;
	WebElement cityField;
	WebElement stateDropdownMenu;
	WebElement firstCountry;
	WebElement homePhoneFieled;
	WebElement mobilePhoneField;
	WebElement zipPostalCode;
	WebElement invalidAddressLabel;
	WebElement emptyAddressFieldLabel;
	WebElement errorMessage;
	WebElement navigationElement;
	

	public WebElement getNavigationElement() {
		return driver.findElement(By.className("navigation_page"));
	}
	public WebElement getErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/p[1]"));
	}
	public WebElement getEmptyAddressFieldLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
	}
	public WebElement getZipPostalCode() {
		return driver.findElement(By.id("postcode"));
	}
	public WebElement getInvalidAddressLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
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
	
	public WebElement getReferenceAddressEmptyFiledLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	public WebElement getFutureReferenceAddressField() {
		return driver.findElement(By.id("alias"));
	}
	public void insertFutureReferenceAddress (String address) {
		this.getFutureReferenceAddressField().clear();
		this.getFutureReferenceAddressField().sendKeys(address);
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
	public void clickOnSaveButton() {
		this.getSaveButton().click();
	}
	public void clearUpdateAddressField() {
		this.getFutureReferenceAddressField().clear();
	}
	public String textForEmptyUpdateAddressFiled() {
		return this.getReferenceAddressEmptyFiledLabel().getText();
	}
	public void clickOnDropdownMenu() {
		this.getStateDropdownMenu().click();
	}
	public void clickOnFirstCountry() {
		this.getFirstCountry().click();
	}
	public String textInvalidAddress() {
		return getInvalidAddressLabel().getText();
	}
	public String emptyAddressFieldLabel() {
		return getEmptyAddressFieldLabel().getText();
	}
	public String textErrorMessage() {
		return getErrorMessage().getText();
	}
	public String textFromNavigationElement() {
		return getNavigationElement().getText();
	}
	public String textFromEmptyReferenceAddressField() {
		return getReferenceAddressEmptyFiledLabel().getText();
	}
	
}