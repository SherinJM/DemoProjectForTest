package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

	public static void waitForElement(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean isClicked(WebDriver driver, By element) {
		try {
			waitForElement(driver, element);
			driver.findElement(element).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void javaExecuter(WebDriver driver, By element) {
		WebElement element1 = driver.findElement(element);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", element1);

	}

}
