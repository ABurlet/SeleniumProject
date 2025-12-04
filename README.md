# SeleniumJavaAutomation



This project demonstrates end-to-end web automation using Selenium WebDriver, Java, TestNG, and Maven.

**It includes:**

-Basic Selenium tests
-Web element interaction
-Data-driven testing using Apache POI and an Excel file
-A TestNG test suite
-A Jenkins CI/CD job that pulls the project from GitHub and runs the tests.

**File/Folder structure**

/src/main/java
BasicAutomation.java
AdvancedAutomation.java
WebElementInteraction.java
DataDrivenTest.java
Main.java

/test/java
TestAutomation.java
SauceDemoTest.java

pom.xml
data.xlsx
homepage.png
README.md


**Components** 
Test Scripts

-TestAutomation.java: TestNG test suite with Wikipedia search and homepage validation
-SauceDemoTest.java: Multiple TestNG tests for SauceDemo site
-DataDrivenTest.java: Data-driven login test using values from Excel

Data-Driven Testing

-data.xlsx is read using Apache POI
-Multiple iterations of the same test executed using values from the spreadsheet

Build and Dependencies

-Handled by Maven with pom.xml
-Includes Selenium, APache POI, TestNG, WebDriverManager, etc.

**How to Run the Tests**

To run it from the terminal, type mvn clean test or mvn test

To run it from VS Code 
-Open project
-Right click any TestNG test class
-Select Run Test

Run with Jenkins

This project contains a Jenkins job that:
-Pulls the code from GitHub
-Executes mvn test
-Displays test results in the Jenkins console output

Jenkins Integration

A Jenkins Freestyle Job was created with the following configuration:
-Source Code Management: Git
-Repository URL: https://github.com/ABurlet/SeleniumProject.git
-Branch: */main
-Build Step: Maven -> clean test

Jenkins successfully built the project and executes all TestNG tests.

**TestNG Reports**

After running the tests, Maven generates TestNG reports under /target/surefire-reports/ which include:
-XML results
-Console output
-Execution totals: passed, failed, or skipped

**Screenshots**

Screenshots include Jenkins configuration, TestNG report, Excel file, passing builds, etc. They are included in the screenshots located in the files in the repo.

**Reports**
Both documents for the Automation Project report and the Jenkins Integration Report are included in the repository.

**Technologies Used**
-Java
-Selenium WebDriver
-TestNG
-Maven
-Apache POI
-Jenkins (Freestyle job)
-GitHub


Amber Burlet
Web Automation with Selenium (Java) 
