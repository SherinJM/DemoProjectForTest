package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageCourses;
import utilities.HelperClass;

public class TestCases extends BaseClass {

	@Test(priority = 0, dataProvider = "loginDataSet", dataProviderClass = CustomDataProvider.class)
	public void loginTest(String userName, String password) throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		lp.enterUsername(userName);
		lp.enterPassword(password);
		lp.clickSignIn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		By textValue = By.xpath("//h1[contains(text(),'Learn')]");
		HelperClass.waitForElement(driver, textValue);
		String value = driver.findElement(textValue).getText();
		Assert.assertEquals(value, "Learn Automation Courses");
		Thread.sleep(5000);
	}

	@Test(priority = 1, dependsOnMethods = "loginTest")
	public void dashboardTest() {
		System.out.println(Thread.currentThread().getId());
		db = new DashboardPage(driver);
		db.cartAddition();
		By btn2_Cart = By.xpath("//span[@class='count']");
		HelperClass.waitForElement(driver, btn2_Cart);
		String value = driver.findElement(btn2_Cart).getText();
		int count = Integer.parseInt(value);
		Assert.assertEquals(count, 1);
	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void manageCategoryTest() throws Exception {
		System.out.println(Thread.currentThread().getId());
		mc = new ManageCourses(driver);
		mc.clickManage();
		mc.clickManageCategories();
		Thread.sleep(5000);
		mc.addNewCategory();

	}

}
