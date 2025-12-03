import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenTest {

public static void main(String[] args) {
// Set path to ChromeDriver
System.setProperty(
"webdriver.chrome.driver",
"/Users/amberburlet/Downloads/chromedriver-mac-arm64/chromedriver"
);

WebDriver driver = new ChromeDriver();

// Build full path to data.xlsx in the project root
String projectDir = System.getProperty("user.dir");
String excelPath = projectDir + File.separator + "data.xlsx";

System.out.println("Project directory: " + projectDir);
System.out.println("Looking for Excel file at: " + excelPath);

FileInputStream fis = null;
Workbook workbook = null;

try {
// Open the Excel file
fis = new FileInputStream(excelPath);
workbook = new XSSFWorkbook(fis);
Sheet sheet = workbook.getSheetAt(0); // first sheet

//Loop through each row and search each term
for (Row row : sheet) {
Cell cell = row.getCell(0); // first column
if (cell == null) continue;

String searchTerm = cell.getStringCellValue();
if (searchTerm == null || searchTerm.isBlank()) continue;

System.out.println("-----");
System.out.println("Searching for: " + searchTerm);

//Go to Wikipedia home page
driver.get("https://www.wikipedia.org/");

// Find search box and search
WebElement searchBox = driver.findElement(By.id("searchInput"));
searchBox.clear();
searchBox.sendKeys(searchTerm);
searchBox.submit();

// Print the results page title
String title = driver.getTitle();
System.out.println("Result page title: " + title);
}

} catch (IOException e) {
System.out.println("Problem reading Excel file!");
e.printStackTrace();
} finally {
// Close resources and browser
try {
if (workbook != null) workbook.close();
if (fis != null) fis.close();
} catch (IOException ignored) {}

driver.quit();
}
}
}