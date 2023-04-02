package pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.HelperClass;

public class ManageCourses {

	public WebDriver driver;
	Actions act;

	public ManageCourses(WebDriver driver) {
		this.driver = driver;
	}

	By hover_element = By.xpath("//span[contains(text(),'Manage')]");
	By ele_ManageCategories = By.xpath("//a[contains(text(),'Manage Categories')]");
	By btn_AddNewCategory = By.xpath("//button[contains(text(),'Add New Category ')]");

	public void clickManage() {
		HelperClass.waitForElement(driver, hover_element);
		act = new Actions(driver);
		act.moveToElement(driver.findElement(hover_element)).build().perform();
	}

	public void clickManageCategories() {
		HelperClass.waitForElement(driver, ele_ManageCategories);
		act.moveToElement(driver.findElement(ele_ManageCategories)).build().perform();
		driver.findElement(ele_ManageCategories).click();
	}

	public void addNewCategory() throws Exception {

		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());

		for (String name : handles) {
			String curUrl = driver.switchTo().window(name).getCurrentUrl();
			if (curUrl.contains("manage")) {
				driver.switchTo().window(name);
				break;
			}
		}
		HelperClass.waitForElement(driver, btn_AddNewCategory);
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		driver.switchTo().alert().sendKeys("NewTest");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}

}
