package pageobjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMailRadioButtonSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextBoxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME, "value");
	}

	public String getLastNameTextBoxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME);
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME, "value");
	}

	public String getFirstSelectedTextInDayDropDown() {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, CustomerInfoPageUI.DATE_DROPDOWN);
	}

	public String getFirstSelectedTextInMonthDropDown() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getFirstSelectedTextInYearDropDown() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANYNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANYNAME_TEXTBOX, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

}
