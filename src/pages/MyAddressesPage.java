package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyAddressesPage {
	

	WebElement updateButton;
	WebDriver driver;
	WebElement firstAddressLabel;
	WebElement secondAddressLabel;
	WebElement firstAddressDeleteButton;
	WebElement secondAddressDeleteButton;
	WebElement addAddressButton;
	
	
	public WebElement getAddAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span"));
	}
	public WebElement getFirstAddressDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[1]/ul/li[9]/a[2]/span"));
	}
	public WebElement getSecondAddressDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]/span"));
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}
	public WebElement getFirstAddressLabel() {
		return driver.findElement(By.className("page-subheading"));}
	
	public String textFromFirstAddress() {
		return this.getFirstAddressLabel().getText();
	}
	public void clickOnUpdateButton() {
		this.getUpdateButton().click();
	}
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getSecondAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}
	public String textFromSecondAddress() {
	return getSecondAddressLabel().getText();
	}
	public void clickOnAddAddressButton() {
		this.getAddAddressButton().click();
	}
	public String textFromSecondAddressDeleteButton() {
		return this.getSecondAddressDeleteButton().getText();
	}
	public void clickOnSecondAddressDeleteButton() {
		getSecondAddressDeleteButton().click();
	}
}
