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

public class LV02_Register_and_Login_AbstractPage_01 {
	String projectFolder = System.getProperty("user.dir");
	WebDriver driver;
	WebDriverWait wait;
	AbstractPage abstractPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "./BrowserDrivers/geckodriver.exe");
//		 System.setProperty("webdriver.chrome.driver",
//		 "./BrowserDrivers/chromedriver.exe");
//		 driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		abstractPage = new AbstractPage();

	}

	@Test
	public void TC01_Register_successfully() {
		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		abstractPage.clickToElement(driver, "//label[contains(text(),'Male')]");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", "Corona BCD");
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", "Virus ABC");

		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "January");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");

		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", "Corona virus 20");
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", "test26092020@gmail.com");
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", "trungtran26092020");
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "trungtran9878");
		abstractPage.clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(abstractPage.getElementText(driver, "//div[@class='result']"),
				"Your registration completed");

		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC02_Login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");

		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", "test26092020@gmail.com");
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", "trungtran9878");

		abstractPage.clickToElement(driver, "//input[@class='button-1 login-button']");

		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='FirstName']", "value"),
				"Corona BCD");
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='LasttName']", "value"), "Virus ABC");

		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthDay']"),
				"10");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthMonth']"),
				"January");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthYear']"),
				"1990");

		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Company']", "value"),
				"Corona virus 20");
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Email']", "value"),
				"test26092020@gmail.com");

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
	}

	@Test
	public void TC03_View_My_Account() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//a[@class='ico-account']"));
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
