package tests;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class EditPersonalInfoTests extends BaseTests{
	
	@BeforeMethod
	public void beforeTest() {
	
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignIn();
		String email = excelReader.getStringData("LogIn", 7, 3);
		String password = excelReader.getStringData("LogIn", 8, 3);
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.clickOnSignIn();
	}
	@Test (priority = 0)
	public void updatePersonalInfoValidInput() {
		String firstname = excelReader.getStringData("UpdatePersonalInfo", 8, 3);
		String lastname = excelReader.getStringData("UpdatePersonalInfo", 9, 3);
		String day = excelReader.getStringData("UpdatePersonalInfo", 11, 3);
		String month = excelReader.getStringData("UpdatePersonalInfo", 12, 3);
		String year = excelReader.getStringData("UpdatePersonalInfo", 13, 3);
		String password = excelReader.getStringData("UpdatePersonalInfo", 14, 3);
		String textForAssertion = excelReader.getStringData("UpdatePersonalInfo", 18, 3);
		myAccountPage.clickOnMyPersonalInfoButton();
	    myPersonalInfoPage.insertFirstName(firstname);
		myPersonalInfoPage.insertLastName(lastname);
		myPersonalInfoPage.clickOnDayButton();
		Select drpDay = new Select(myPersonalInfoPage.getDayDropDownMenu());
		drpDay.selectByValue(day);
		myPersonalInfoPage.clickOnMonthButton();
		Select drpMonth = new Select(myPersonalInfoPage.getMonthDropDownMenu());
		drpMonth.selectByValue(month);
		myPersonalInfoPage.clickOnYearButton();
		Select drpYear = new Select(myPersonalInfoPage.getYearDropDownMenu());
		drpYear.selectByValue(year);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickOnSaveButton();
		String actualText = myPersonalInfoPage.textForSuccessUpdate();
	    assertEquals(actualText, textForAssertion);
		
	} 
	@Test (priority = 1)
	public void updatePersonalInfoInccorectPassword() {
		String firstname = excelReader.getStringData("UpdatePersonalInfo", 27, 3);
		String lastname = excelReader.getStringData("UpdatePersonalInfo", 28, 3);
		String day = excelReader.getStringData("UpdatePersonalInfo", 30, 3);
		String month = excelReader.getStringData("UpdatePersonalInfo", 31, 3);
		String year = excelReader.getStringData("UpdatePersonalInfo", 32, 3);
		String password = excelReader.getStringData("UpdatePersonalInfo", 33, 3);
		String textForAssertion = excelReader.getStringData("UpdatePersonalInfo", 37, 3);
		
		myAccountPage.clickOnMyPersonalInfoButton();
	    myPersonalInfoPage.insertFirstName(firstname);
		myPersonalInfoPage.insertLastName(lastname);
		myPersonalInfoPage.clickOnDayButton();
		Select drpDay = new Select(myPersonalInfoPage.getDayDropDownMenu());
		drpDay.selectByValue(day);
		myPersonalInfoPage.clickOnMonthButton();
		Select drpMonth = new Select(myPersonalInfoPage.getMonthDropDownMenu());
		drpMonth.selectByValue(month);
		myPersonalInfoPage.clickOnYearButton();
		Select drpYear = new Select(myPersonalInfoPage.getYearDropDownMenu());
		drpYear.selectByValue(year);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickOnSaveButton();
		String actualText = myPersonalInfoPage.textInvalidPasswordMessage();
	    assertEquals(actualText, textForAssertion);
		
	} 
	@Test (priority = 2)
	public void updatePersonalInfoInvalidDate() {
		
		String firstname = excelReader.getStringData("UpdatePersonalInfo", 27, 4);
		String lastname = excelReader.getStringData("UpdatePersonalInfo", 28, 4);
		String day = excelReader.getStringData("UpdatePersonalInfo", 30, 4);
		String month = excelReader.getStringData("UpdatePersonalInfo", 31, 4);
		String year = excelReader.getStringData("UpdatePersonalInfo", 32, 4);
		String password = excelReader.getStringData("UpdatePersonalInfo", 33, 4);
		String textForAssertion = excelReader.getStringData("UpdatePersonalInfo", 37, 4);
		myAccountPage.clickOnMyPersonalInfoButton();
	    myPersonalInfoPage.insertFirstName(firstname);
		myPersonalInfoPage.insertLastName(lastname);
		myPersonalInfoPage.clickOnDayButton();
		Select drpDay = new Select(myPersonalInfoPage.getDayDropDownMenu());
		drpDay.selectByValue(day);
		myPersonalInfoPage.clickOnMonthButton();
		Select drpMonth = new Select(myPersonalInfoPage.getMonthDropDownMenu());
		drpMonth.selectByValue(month);
		myPersonalInfoPage.clickOnYearButton();
		Select drpYear = new Select(myPersonalInfoPage.getYearDropDownMenu());
		drpYear.selectByValue(year);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickOnSaveButton();
		int present = myPersonalInfoPage.numberOfElementsErrorMessage();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = myPersonalInfoPage.textErrorMessage();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}
		
	}
	@Test (priority = 3)
	public void updatePersonalInfoInvalidFirstLastName() {
		
		String firstname = excelReader.getStringData("UpdatePersonalInfo", 26, 5);
		String lastname = excelReader.getStringData("UpdatePersonalInfo", 27, 5);
		String day = excelReader.getStringData("UpdatePersonalInfo", 30, 5);
		String month = excelReader.getStringData("UpdatePersonalInfo", 31, 5);
		String year = excelReader.getStringData("UpdatePersonalInfo", 32, 5);
		String password = excelReader.getStringData("UpdatePersonalInfo", 33, 5);
		String textForAssertion = excelReader.getStringData("UpdatePersonalInfo", 37, 5);
		myAccountPage.clickOnMyPersonalInfoButton();
	    myPersonalInfoPage.insertFirstName(firstname);
		myPersonalInfoPage.insertLastName(lastname);
		myPersonalInfoPage.clickOnDayButton();
		Select drpDay = new Select(myPersonalInfoPage.getDayDropDownMenu());
		drpDay.selectByValue(day);
		myPersonalInfoPage.clickOnMonthButton();
		Select drpMonth = new Select(myPersonalInfoPage.getMonthDropDownMenu());
		drpMonth.selectByValue(month);
		myPersonalInfoPage.clickOnYearButton();
		Select drpYear = new Select(myPersonalInfoPage.getYearDropDownMenu());
		drpYear.selectByValue(year);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickOnSaveButton();
		String actualText = myPersonalInfoPage.textInvalidFirstLastname();
	    assertEquals(actualText, textForAssertion);

	}
	@Test (priority = 4)
	public void updatePersonalInfoInvalidFirstLastNameSpace() {
		
		String firstname = excelReader.getStringData("UpdatePersonalInfo", 27, 6);
		String lastname = excelReader.getStringData("UpdatePersonalInfo", 28, 6);
		String day = excelReader.getStringData("UpdatePersonalInfo", 30, 6);
		String month = excelReader.getStringData("UpdatePersonalInfo", 31, 6);
		String year = excelReader.getStringData("UpdatePersonalInfo", 32, 6);
		String password = excelReader.getStringData("UpdatePersonalInfo", 33, 6);
		String textForAssertion = excelReader.getStringData("UpdatePersonalInfo", 37, 6);
		myAccountPage.clickOnMyPersonalInfoButton();
	    myPersonalInfoPage.insertFirstName(firstname);
		myPersonalInfoPage.insertLastName(lastname);
		myPersonalInfoPage.clickOnDayButton();
		Select drpDay = new Select(myPersonalInfoPage.getDayDropDownMenu());
		drpDay.selectByValue(day);
		myPersonalInfoPage.clickOnMonthButton();
		Select drpMonth = new Select(myPersonalInfoPage.getMonthDropDownMenu());
		drpMonth.selectByValue(month);
		myPersonalInfoPage.clickOnYearButton();
		Select drpYear = new Select(myPersonalInfoPage.getYearDropDownMenu());
		drpYear.selectByValue(year);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickOnSaveButton();
		int present = myPersonalInfoPage.numberOfElementsErrorMessage();
		boolean expected = true;
		boolean actual;
		if (present > 0) {
			String actualText = myPersonalInfoPage.textErrorMessage();
			assertEquals(actualText, textForAssertion);
		} else {
			actual = false;
			assertEquals(actual, expected);
		}
	}
	@Test (priority = 3)
	public void updatePersonalInfoEmptyFirstname() {
		
		String password = excelReader.getStringData("UpdatePersonalInfo", 51, 3);
		String textForAssertion = excelReader.getStringData("UpdatePersonalInfo", 55, 3);
		myAccountPage.clickOnMyPersonalInfoButton();
	    myPersonalInfoPage.getFirstNameField().clear();
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickOnSaveButton();
		String actualText = myPersonalInfoPage.textInvalidFirstLastname();
	    assertEquals(actualText, textForAssertion);

	}
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
	}
}
