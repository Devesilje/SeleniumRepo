package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	

	WebElement updateButton;
	WebDriver driver;
	WebElement updateAddressLabel;
	WebElement firstAddressDeleteButton;
	WebElement secondAddressDeleteButton;
	
	public WebElement getFirstAddressDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[1]/ul/li[9]/a[2]/span"));
	}
	public WebElement getSecondAddressDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]/span"));
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}
	public WebElement getUpdateAddressLabel() {
		return driver.findElement(By.className("page-subheading"));}
	
	public String textFromUpdatedAddress() {
		return this.getUpdateAddressLabel().getText();
	}
	public void clickOnUpdateButton() {
		this.getUpdateButton().click();
	}
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
}
