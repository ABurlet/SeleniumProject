import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

public class BasicSeleniumTest {

public static void main(String[] args) throws IOException {

System.setProperty(
"webdriver.chrome.driver", "/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver"
);

//Initialize the browser driver 
WebDriver driver = new ChromeDriver();

try {
//maximize window
driver.manage().window().maximize();

// go to Wikipedia 
driver.get("https://www.wikipedia.org/");

// Validate that the title contains "Wikipedia"
String title = driver.getTitle();
if (title.contains("Wikipedia")) {
System.out.println("Title validation PASSED: " + title);
} else {
System.out.println("Title validation FAILED. Actual title: " + title);
}

//screenshot the homepage
File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

// Save as homepage.png in project root
File destFile = new File("homepage.png");
FileHandler.copy(srcFile, destFile);

System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());

} finally {
//Close the browser
driver.quit();
}
}
}