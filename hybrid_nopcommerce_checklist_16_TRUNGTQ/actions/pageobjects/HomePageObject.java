package pageobjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
	// Biến toàn cục
	WebDriver driver;

	// Tao constructor (chon HomePageObject > Source > Generate using Fields
	// Hàm khởi tạo - Constructor: khi new class HOMEPAGEOBECT lên thì Constructor
	// sẽ chạy đầu tiên , mục địch để map driver
	// Hàm khởi tạo không có kiểu trả về và cùng tên với tên class

	public HomePageObject(WebDriver driver) {
		// Webdriver driver: là biến cục bộ của hàm này
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCCOUNT_LINK);
	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
	}

	public boolean ismyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCCOUNT_LINK);
	}

	public boolean islogoutLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}

}
