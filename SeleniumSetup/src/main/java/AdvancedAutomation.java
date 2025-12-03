import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvancedAutomation {

public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver",
"/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver");

WebDriver driver = new ChromeDriver();

try {
// Implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Go to Selenium 
driver.get("https://www.selenium.dev/selenium/web/web-form.html");

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//Dropdown and select
WebElement selectElement =
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));
Select dropdown = new Select(selectElement);
dropdown.selectByVisibleText("Option 2"); // adjust text if needed

// Checkbox 
WebElement checkbox = driver.findElement(By.id("my-check-1")); // or my-check-2
if (!checkbox.isSelected()) {
checkbox.click();
}

// Radio button 
WebElement radio = driver.findElement(By.id("my-radio-1"));
if (!radio.isSelected()) {
radio.click();
}

// Handle alert popup
((JavascriptExecutor) driver).executeScript("alert('Hello from Selenium!');");
Alert alert = wait.until(ExpectedConditions.alertIsPresent());
System.out.println("Alert text: " + alert.getText());
alert.accept();

//Switch between windows and tabs
String originalWindow = driver.getWindowHandle();

//Open a new tab
WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
newTab.get("https://www.example.com/");
System.out.println("New tab title: " + newTab.getTitle());

// Switch back to the original window
driver.switchTo().window(originalWindow);
System.out.println("Back to original page title: " + driver.getTitle());

System.out.println("AdvancedAutomation completed.");

} finally {
driver.quit();
}
}
}