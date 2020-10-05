package demo.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	String email = "test0510202001@gmail.com";
	String password = "trungtran9878";
	String firstname = "Corona HAHA";
	String lastname = "Virus HAHA";
	String day = "10";
	String month = "January";
	String year = "1990";
	String company = "Corona virus 20";

	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", projectFolder + "./BrowserDrivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", projectFolder + "./BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC01_Register_successfully() {
		homepage = new HomePageObject(driver);
		homepage.clickToRegisterLink();
		registerpage = new RegisterPageObject(driver);
		registerpage.clickToGenderMaleRadioBtn();
		registerpage.inputToFirstNameTextBox(firstname);
		registerpage.inputToLastNameTextBox(lastname);
		registerpage.selectDayDropdown(day);
		registerpage.selectMonthDropdown(month);
		registerpage.selectYearDropdown(year);
		registerpage.inputToCompany(company);
		registerpage.inputToEmail(email);
		registerpage.inputToPassword(password);
		registerpage.inputToConfirmPassword(password);
		registerpage.clickToRegisterBtn();
		registerpage.getRegisterSuccessMessage();
		Assert.assertEquals(registerpage.getRegisterSuccessMessage(), "Your registration completed");
		registerpage.clickLogOutLink();
		homepage = new HomePageObject(driver);
	}

	@Test
	public void TC02_Login() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject(driver);
		loginpage.inputToEmailTextbox(email);
		loginpage.inputToPasswordTextbox(password);
		loginpage.clickToLoginButton();
		homepage = new HomePageObject(driver);
		Assert.assertTrue(homepage.ismyAccountLinkDisplayed());
		Assert.assertTrue(homepage.islogoutLinkDisplayed());
	}

	@Test
	public void TC03_View_My_Account() {
		homepage.clickToMyAccountLink();
		customerinfopage = new CustomerInfoPageObject(driver);
		customerinfopage.isGenderMailRadioButtonSelected();
		Assert.assertTrue(customerinfopage.isGenderMailRadioButtonSelected());
		customerinfopage.getFirstNameTextBoxValue();
		Assert.assertEquals(customerinfopage.getFirstNameTextBoxValue(), firstname);
		customerinfopage.getLastNameTextBoxValue();
		Assert.assertEquals(customerinfopage.getLastNameTextBoxValue(), lastname);
		Assert.assertEquals(customerinfopage.getFirstSelectedTextInDayDropDown(), day);
		Assert.assertEquals(customerinfopage.getFirstSelectedTextInMonthDropDown(), month);
		Assert.assertEquals(customerinfopage.getFirstSelectedTextInYearDropDown(), year);
		Assert.assertEquals(customerinfopage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerinfopage.getCompanyTextboxValue(), company);
		Assert.assertTrue(customerinfopage.isNewsletterCheckboxSelected());
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
