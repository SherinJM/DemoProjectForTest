package base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import browsermanagement.BrowserFactory;
import configurationManagement.ConfigurationReader;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageCourses;
import pages.NewUserSignUpPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage db;
	public ManageCourses mc;
	public NewUserSignUpPage sp;

	@BeforeClass
	public void browserSetUp() throws Exception {
		System.out.println("B SetUp");
		Reporter.log("Log:Info-Setting up browser...");
		driver = BrowserFactory.startBrowser(ConfigurationReader.getProperty("browser"),
				ConfigurationReader.getProperty("url"));
		Reporter.log("Log:Info-Browser is set up...");
	}

	@AfterClass
	public void tearDown() {

	
			System.out.println("B TearDown");
			Reporter.log("Log:Info-Quitting browser...");
			driver.quit();
			Reporter.log("Log:Info-Browser is quit...");
		

	}
}
