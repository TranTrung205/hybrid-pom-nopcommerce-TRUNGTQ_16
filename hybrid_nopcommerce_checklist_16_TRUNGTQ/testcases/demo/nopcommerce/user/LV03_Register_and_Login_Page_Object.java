package demo.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageobjects.CustomerInfoPageObject;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.RegisterPageObject;

public class LV03_Register_and_Login_Page_Object extends AbstractPage {
	String projectFolder = System.getProperty("user.dir");
	WebDriver driver;
	WebDriverWait wait;
	HomePageObject homepage;
	LoginPageObject loginpage;
	RegisterPageObject registerpage;
	CustomerInfoPageObject customerinfopage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "./BrowserDrivers/geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "./BrowserDrivers/chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC01_Register_successfully() {
		homepage = new HomePageObject();
		homepage.clickToRegisterLink();

		registerpage = new RegisterPageObject();
		registerpage.clickToGenderMaleRadioBtn();
		clickToElement(driver, "//label[contains(text(),'Male')]");

		registerpage.inputToFirstNameTextBox(firstName);
		sendkeyToElement(driver, "//input[@id='FirstName']", "Corona BCD");
		registerpage.inputToLastNameTextBox(LastName);
		sendkeyToElement(driver, "//input[@id='LastName']", "Virus ABC");

		registerpage.selectDayDropdown("10");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		registerpage.selectMonthDropdown("January");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "January");
		registerpage.selectYearDropdown("1990");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");

		registerpage.inputToCompany("Corona virus 20");
		sendkeyToElement(driver, "//input[@id='Company']", "Corona virus 20");
		registerpage.inputToEmail("test26092020@gmail.com");
		sendkeyToElement(driver, "//input[@id='Email']", "test26092020@gmail.com");
		registerpage.inputToPassword("trungtran26092020");
		sendkeyToElement(driver, "//input[@id='Password']", "trungtran26092020");
		registerpage.inputToConfirmPassword("trungtran9878");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "trungtran9878");
		registerpage.clickToRegisterBtn();
		clickToElement(driver, "//input[@id='register-button']");

		registerpage.getRegisterSuccessMessage();
		Assert.assertEquals(registerpage.getRegisterSuccessMessage(), "Your registration completed");

		registerpage.clickLogOutLink();
		clickToElement(driver, "//a[@class='ico-logout']");

		homepage = new HomePageObject();
	}

	@Test
	public void TC02_Login() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject();
		clickToElement(driver, "//a[@class='ico-login']");

		loginpage.inputToEmailTextbox("test27092020@gmail.com");
		sendkeyToElement(driver, "//input[@id='Email']", "test26092020@gmail.com");
		loginpage.inputToEmailTextbox("trungtran9878");
		sendkeyToElement(driver, "//input[@id='Password']", "trungtran9878");

		loginpage.clickToLoginButton();
		clickToElement(driver, "//input[@class='button-1 login-button']");

		homepage = new HomePageObject();
		Assert.assertTrue(homepage.ismyAccountLinkDisplayed());
		Assert.assertTrue(homepage.islogoutLinkDisplayed());

	}

	@Test
	public void TC03_View_My_Account() {
		homepage.clickToMyAccountLink();
		customerinfopage = new CustomerInfoPageObject();
		clickToElement(driver, "//a[@class='ico-account']");

		customerinfopage.isGenderMailRadioButtonSelected();
		Assert.assertTrue(customerinfopage.isGenderMailRadioButtonSelected());
		
		customerinfopage.getFirstNameTextBoxValue();
		Assert.assertEquals(customerinfopage.getFirstNameTextBoxValue(), "Corona BCD");
		customerinfopage.getLastNameTextBoxValue();
		Assert.assertEquals(customerinfopage.getLastNameTextBoxValue(), "Virus ABC");

		customerinfopage.getSelectedTextInDayDropdown()
		Assert.assertEquals(getFirstSelectedTextInDayDropDown, "10");
		Assert.assertEquals(getFirstSelectedTextInMonthDropDown, "January");
		Assert.assertEquals(getFirstSelectedTextInYearDropDown, "1990");

		Assert.assertEquals(customerinfopage.getEmailTextboxValue(), "Corona virus 20");
		Assert.assertEquals(customerinfopage.getCompanyTextboxValue(), "test26092020@gmail.com");

		Assert.assertTrue(customerinfopage.isNewsletterCheckboxSelected());
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
