import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAutomation {

public static void main(String[] args) {
//Set path to ChromeDriver
System.setProperty("webdriver.chrome.driver",
"/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver");

//Initialize WebDriver
WebDriver driver = new ChromeDriver();

try {
// Go to Wikipedia
driver.get("https://www.wikipedia.org/");

// Locating the search box in different ways 

//By id
WebElement searchInputById = driver.findElement(By.id("searchInput"));

//By name
WebElement searchInputByName = driver.findElement(By.name("search"));

//By CSS selector
WebElement searchInputByCss = driver.findElement(By.cssSelector("input#searchInput"));

//By Xpath
WebElement searchInputByXpath = driver.findElement(By.xpath("//input[@id='searchInput']"));

//Uses one of those to actually type into
WebElement searchBox = searchInputById;

//Enters search and submits
searchBox.sendKeys("Selenium WebDriver");
searchBox.submit(); // presses Enter for us

//Prints the title of the results page
String resultsTitle = driver.getTitle();
System.out.println("Results page title is: " + resultsTitle);

} finally {

//Closes the browser
driver.quit();
}
}
}