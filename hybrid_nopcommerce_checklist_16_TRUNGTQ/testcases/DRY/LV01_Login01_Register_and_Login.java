package DRY;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class LV01_Login01_Register_and_Login {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.geckodriver.driver", "./BrowserDrivers/geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "./BrowserDrivers/chromedriver.exe");
		// driver = new ChromeDriver();
		//comment abcd
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC01_Register_successfully() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='FirstName']"))));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Corona ABC");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Virus BCD");
		Select select;
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("1");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("January");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1990");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Corona virus 19");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test07@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("trungtran9878");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("trungtran9878");
		driver.findElement(By.xpath("//input[@id='register-button']")).click();

		WebElement result = driver.findElement(By.xpath("//div[@class='result']"));
		Assert.assertEquals(result.getText(), "Your registration completed");
	}

	@Test
	public void TC02_Login() {
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test07@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("trungtran9878");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}
}
