package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	public static WebElement getElement(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(element));
		return wb;
	}

	public static void sendKeys(WebDriver driver, By element, String value) {
		getElement(driver, element).sendKeys(value);
	}

	public static WebElement getMakePost(WebDriver driver) {
		WebElement element = driver.findElement(MAKE_A_POST_BUTTON);
		return element;
	}

	public static void clickMakePostButton(WebDriver driver) {
		getMakePost(driver).click();
	}

	public static WebElement getSavePostButton(WebDriver driver) {
		WebElement element = driver.findElement(POST_BUTTON);
		return element;
	}
	public static void clickSavePostButton(WebDriver driver) {
		getSavePostButton(driver).click();
		getSavePostButton(driver).submit();
	}

	public static WebElement getLogoutButton(WebDriver driver) {
		WebElement element = driver.findElement(LOGOUT_BUTTON);
		return element;
	}

	public static void clickLogoutButton(WebDriver driver) {
		getLogoutButton(driver).click();
	}

	public static WebElement getNaziv(WebDriver driver) {
		WebElement element = driver.findElement(POST_NAME);
		return element;
	}

	public static void clickNaziv(WebDriver driver) {
		getNaziv(driver).click();		
	}

	public static WebElement getBrowseButton(WebDriver driver) {
		WebElement element = driver.findElement(BROWSE_BUTTON);
		return element;
	}

	public static void insertImage(WebDriver driver, String input) {
		driver.findElement(By.id("image")).sendKeys(input);
	}

	
	
	public static WebElement getTravelType(WebDriver driver) {
		WebElement element = driver.findElement(TRAVEL_TYPE);
		return element;
	}

	public static void clickTravelType(WebDriver driver) {
		getTravelType(driver).click();

	}

	public static void setTravelType(WebDriver driver, String input) {
		Select tType = new Select(driver.findElement(TRAVEL_TYPE));
		tType.selectByVisibleText(input);
	}

	public static WebElement getMenuPostButton(WebDriver driver) {
		WebElement element = driver.findElement(MENU_POST_BUTTON);
		return element;
	}

	public static void postMenuButton(WebDriver driver) {
		List<WebElement> menu = driver.findElements(MENU_POST_BUTTON);
		menu.get(0).click();
	}

	public static void editPostButton(WebDriver driver) {
		postMenuButton(driver);
		List<WebElement> edit = driver.findElements(EDIT_POST_BUTTON);
		edit.get(0).click();
	}

	public static void editPostDescription(WebDriver driver, String value) {
		WebElement element = driver.findElement(TRAVEL_DESCRIPTION_CHANGE);
		element.clear();
		element.sendKeys(value);
	}
	public static void clickPostDescription(WebDriver driver) {
		WebElement element = driver.findElement(TRAVEL_DESCRIPTION_CHANGE);
		element.click();
	}

	public static WebElement getPostChangeSave(WebDriver driver) {
		WebElement element = driver.findElement(POST_CHANGE_SAVE);
		return element;
	}

	public static void clickPostChangeSave(WebDriver driver) {
		getPostChangeSave(driver).click();
	}

	public static void deletePostButton(WebDriver driver) {
		postMenuButton(driver);
		List<WebElement> delete = driver.findElements(DELETE_POST_BUTTON);
		delete.get(0).click();
	}

	public static final By MAKE_A_POST_BUTTON = By.id("newPostBtn");
	public static final By LOGOUT_BUTTON = By.id("logoutBtn");
    public static final By POST_NAME = By.name("title");
	public static final By TRAVEL_LOCATION = By.name("location");
	public static final By BROWSE_BUTTON = By.id("image");
	public static final By TRAVEL_TYPE = By.name("transport");
	public static final By TRAVEL_DESCRIPTION = By.xpath("//textarea[@placeholder='Opis']");
	public static final By POST_BUTTON =  By.name("postSubmit");
	public static final By MENU_POST_BUTTON = By.className("fa-ellipsis-v");
	public static final By DELETE_POST_BUTTON = By.className("fa-trash-alt");
	public static final By EDIT_POST_BUTTON = By.className("fa-edit");
	public static final By TRAVEL_DESCRIPTION_CHANGE = By.id("description");
	public static final By POST_CHANGE_SAVE = By.xpath("//div[@class='popupEdit']//input[@name='postSubmit']");
}
