
package pageobjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioBtn() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstNameTextBox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME, firstname);
	}

	public void inputToLastNameTextBox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME, lastname);
	}

	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, RegisterPageUI.DATE_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DATE_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
	}

	public void inputToCompany(String company) {
		waitForElementVisible(driver, RegisterPageUI.COMPANYNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANYNAME_TEXTBOX, company);
	}

	public void inputToEmail(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD, password);
	}

	public void inputToConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
	}

	public void clickToRegisterBtn() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTERED_SUCCESS_MSG);
		return getElementText(driver, RegisterPageUI.REGISTERED_SUCCESS_MSG);

	}

	public void clickLogOutLink() {
		waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);

	}

}