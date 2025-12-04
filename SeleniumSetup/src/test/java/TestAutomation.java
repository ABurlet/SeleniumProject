import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAutomation {

private WebDriver driver;
private WebDriverWait wait;

@BeforeMethod
public void setUp() {
System.setProperty("webdriver.chrome.driver",
"/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver");

driver = new ChromeDriver();
wait = new WebDriverWait(driver, Duration.ofSeconds(10));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
public void wikipediaSearchTest() {
driver.get("https://www.wikipedia.org/");

WebElement searchBox = wait.until(
ExpectedConditions.visibilityOfElementLocated(By.id("searchInput"))
);

searchBox.sendKeys("Selenium WebDriver");
searchBox.submit();

String title = driver.getTitle();
System.out.println("Results page title: " + title);

// simple assertion check
if (title == null|| title.isBlank()) {
throw new AssertionError("Results title should not be blank");
}
}

@AfterMethod
public void tearDown() {
if (driver != null) {
driver.quit();
}
}
}
