
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementInteraction {

public static void main(String[] args) {

// Set the path to the ChromeDriver 
System.setProperty(
"webdriver.chrome.driver",
"/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver"
);

// Initialize WebDriver 
WebDriver driver = new ChromeDriver();

// Go to a test site
driver.get("https://www.saucedemo.com/");

//Locate elements in different ways and interact with them

// By id
WebElement usernameInput = driver.findElement(By.id("user-name"));
usernameInput.sendKeys("standard_user");

// By name
WebElement passwordInput = driver.findElement(By.id("password"));
passwordInput.sendKeys("secret_sauce");

// By CSS selector
WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
loginButton.click();

// Print the page title after login
System.out.println("After login, page title is: " + driver.getTitle());

//Close the browser
driver.quit();
}
}