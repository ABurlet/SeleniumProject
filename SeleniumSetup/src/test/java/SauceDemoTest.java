import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {

private WebDriver driver;

@BeforeClass
public void setUpClass() {
// Runs once before any tests in this class
System.setProperty(
"webdriver.chrome.driver",
"/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver"
);
}

@BeforeMethod
public void setUp() {
// Runs before each test
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com/");
}

@Test
public void validLogin_shouldGoToProductsPage() {
// Locate elements
WebElement username = driver.findElement(By.id("user-name"));
WebElement password = driver.findElement(By.id("password"));
WebElement loginBtn = driver.findElement(By.id("login-button"));

// Interact with them
username.sendKeys("standard_user");
password.sendKeys("secret_sauce");
loginBtn.click();

// check URL contains "inventory" after login
String currentUrl = driver.getCurrentUrl();
Assert.assertTrue(
currentUrl.contains("inventory"),
"User should be on inventory page after login"
);
}

@AfterMethod
public void tearDown() {
// Runs after each test
if (driver != null) {
driver.quit();
}
}

@AfterClass
public void tearDownClass() {
// Runs one time after all of the tests in this class
System.out.println("All SauceDemo tests finished.");
}
}