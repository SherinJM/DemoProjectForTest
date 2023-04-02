package pages;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.HelperClass;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By txt_userName = By.xpath("//input[@placeholder='Enter Email']");
	By txt_password = By.xpath("//input[@placeholder='Enter Password']");
	By btn_SignIn = By.xpath("//button[contains(text(),'Sign in')]");
	By lnk_SignUp = By.xpath("//a[contains(text(),'New user? Signup')]");
	By lnks = By.tagName("a");

	public void enterUsername(String userName) {
		HelperClass.waitForElement(driver, txt_userName);
		driver.findElement(txt_userName).sendKeys(userName);
	}

	public void enterPassword(String password) {
		HelperClass.waitForElement(driver, txt_password);
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickSignIn() {
		HelperClass.waitForElement(driver, btn_SignIn);
		driver.findElement(btn_SignIn).click();
	}

	public void clickSignUp() {
		HelperClass.waitForElement(driver, lnk_SignUp);
		driver.findElement(lnk_SignUp).click();
	}

	public int countOfButtons() {
		List<WebElement> list = driver.findElements(lnks);
		int size = list.size();
		return size;
	}

	public void brokenLinks() throws Exception {
		
		List<WebElement> links = driver.findElements(lnks);
		for (WebElement lnk : links) {
			String href = lnk.getAttribute("href");
			URL url = new URL(href);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(href + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(href + " - " + httpURLConnection.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		}
	}

}
