package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	private WebElement element;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	private Select select;
	private int waitingTime = 30;

	// Browser
	protected void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	protected String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	protected void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	protected void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	protected void sendkeysToAlert(WebDriver driver, String keyword) {
		driver.switchTo().alert().sendKeys(keyword);
	}

	protected void sendCredentialToAlert(WebDriver driver, String credential) {
		driver.switchTo().alert().sendKeys(credential);
	}

	protected void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, waitingTime);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}

		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(title))
				break;
		}
	}

	protected void closeAllWindowWithourParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	private By getByXpath(String locator) {
		return By.xpath(locator);
	}

	private WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	private List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();

	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDropDown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		// 1. Click vao the cha de xo ra tat ca item con
		getElement(driver, parentLocator).click();
		// 2. Cho cho tat ca item duoc load ra
		WebDriverWait explicitedWait = new WebDriverWait(driver, waitingTime);
		explicitedWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		// 3. Dua tat ca cac item vao 01 list de kiem tra
		elements = getElements(driver, childItemLocator);
		// 4. Chay qua tat ca cac gia tri dang co trong list
		for (WebElement item : elements) {
			// 5. Kiem tra xem text cua gia co co item nao bang item mong muon khong
			if (item.getText().equals(expectedItem)) {
				// Roll xuong den dung item nay
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				break;
			}
		}
	}

	private void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(locator);
	}

	public String getElementText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
	}

	protected int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	protected void checkToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	protected void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	protected void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	protected void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	protected void clickAndHoldToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}

	protected void dargAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	protected Object executeForBrowser(WebDriver driver, String javascript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javascript);
	}

	protected boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver, String javascript) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location= '" + url + "'");
	}

	protected void highlightToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = getElement(driver, locator).getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttibute(arguments[1], arguments[2])", getElement(driver, locator),
				"style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1000);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", getElement(driver, locator),
				originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	protected void scrollToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('value', '" + attributeRemove + "');",
				getElement(driver, locator));
	}

	protected boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].natualWidth != \"underfined\" && arguments[0].naturalWidth > 0)",
				getElement(driver, locator));
		if (status) {
			return true;
		}
		return false;
	}
	//wait
	protected void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, waitingTime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	protected void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, waitingTime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	protected void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, waitingTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

}