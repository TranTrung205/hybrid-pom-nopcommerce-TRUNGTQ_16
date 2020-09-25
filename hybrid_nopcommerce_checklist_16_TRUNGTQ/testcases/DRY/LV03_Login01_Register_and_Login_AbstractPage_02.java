package DRY;

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

public class LV03_Login01_Register_and_Login_AbstractPage_02 extends AbstractPage {
	String projectFolder = System.getProperty("user.dir");
	WebDriver driver;
	WebDriverWait wait;

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
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//label[contains(text(),'Male')]");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Corona BCD");
		sendkeyToElement(driver, "//input[@id='LastName']", "Virus ABC");

		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "January");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");

		sendkeyToElement(driver, "//input[@id='Company']", "Corona virus 20");
		sendkeyToElement(driver, "//input[@id='Email']", "test26092020@gmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "trungtran26092020");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "trungtran9878");
		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "test26092020@gmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "trungtran9878");

		clickToElement(driver, "//input[@class='button-1 login-button']");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), "Corona BCD");
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LasttName']", "value"), "Virus ABC");

		Assert.assertEquals(getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthDay']"), "10");
		Assert.assertEquals(getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthMonth']"), "January");
		Assert.assertEquals(getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthYear']"), "1990");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), "Corona virus 20");
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), "test26092020@gmail.com");

		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));
	}

	@Test
	public void TC03_View_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(isElementSelected(driver, "//a[@class='ico-account']"));
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
