package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// It's used to testing registration and login functionality of the site

public class RegLogPage {

	public static void openPage(WebDriver driver, String address) {
		driver.get(address);
	}

	public static void navigateTo(WebDriver driver, String address) {
		driver.navigate().to(address);
	}

	public static WebElement getElement(WebDriver driver, By element) {
		WebElement wb = driver.findElement(element);
		return wb;
	}

	public static void sendKeys(WebDriver driver, By element, String data) {
		getElement(driver, element).sendKeys(data);
		;
	}

	public static WebElement getLogIn(WebDriver driver) {
		WebElement element = driver.findElement(LOG_IN_BUTTON);
		return element;
	}

	public static WebElement getLogIn2(WebDriver driver) {
		WebElement element = driver.findElement(LOG_IN_BUTTON2);
		return element;
	}

	public static void clickLogIn(WebDriver driver) {
		getLogIn(driver).click();
	}

	public static void clickLogIn2(WebDriver driver) {
		getLogIn2(driver).click();
	}

	public static WebElement getRegister(WebDriver driver) {
		WebElement element = driver.findElement(REGISTER_BUTTON);
		return element;
	}

	public static void clickRegister(WebDriver driver) {
		getRegister(driver).click();
	}

	public static final By USER_NAME = By.xpath("//input[@placeholder='username']");
	public static final By PASSWORD = By.xpath("//input[@placeholder='password']");
	public static final By LOG_IN_BUTTON = By.xpath("//input[@value='Log in']");
	public static final By FIRST_NAME_REG = By.xpath("//input[@name='firstname']");
	public static final By LAST_NAME_REG = By.xpath("//input[@name='lastname']");
	public static final By USER_NAME_REG = By.xpath("//form[@action='processregister.php']//input[@name='username']");
	public static final By EMAIL_REG = By.xpath("//input[@name='email']");
	public static final By PASSWORD_REG = By.xpath("//form[@action='processregister.php']//input[@name='password']");
	public static final By REGISTER_BUTTON = By.xpath("//input[@id='blue_btn']");

	public static final By USER_NAME2 = By.name("username");
	public static final By PASSWORD2 = By.name("password");
	public static final By LOG_IN_BUTTON2 = By.name("login");
	public static final By FIRST_NAME_REG2 = By.name("firstname");
	public static final By LAST_NAME_REG2 = By.name("lastname");
	public static final By USER_NAME_REG2 = By.xpath("//html/body/div[3]/div[2]/form/input[3]");
	public static final By EMAIL_REG2 = By.name("email");
	public static final By PASSWORD_REG2 = By.xpath("//html/body/div[3]/div[2]/form/input[5]");
	public static final By REGISTER_BUTTON2 = By.xpath("//input[@id='blue_btn']");

}
