package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.HelperClass;

public class DashboardPage {

	public WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	By btn1_Cart = By.xpath("//button[contains(text(),'Add')]");
	

	public void cartAddition() {
		HelperClass.waitForElement(driver, btn1_Cart);
		driver.findElement(btn1_Cart).click();
	}

}
