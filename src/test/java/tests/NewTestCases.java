package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.LoginPage;
import pages.NewUserSignUpPage;

public class NewTestCases extends BaseClass {

	@Test(priority = 0, dataProvider = "signup", dataProviderClass = CustomDataProvider.class)
	public void signUpTest(String userName, String email, String password, String interests, String gender,
			String state, String hobbies) throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.clickSignUp();
		sp = new NewUserSignUpPage(driver);
		sp.enterUserName(userName);
		Thread.sleep(1000);
		sp.enterEmail(email);
		Thread.sleep(1000);
		sp.enterPassword(password);
		Thread.sleep(1000);
		sp.selectInterests(interests);
		Thread.sleep(1000);
		sp.selectGender(gender);
		Thread.sleep(1000);
		sp.selectState(state);
		Thread.sleep(1000);
		sp.selectHobbies(hobbies);
		Thread.sleep(1000);
		sp.clickSignUp();
	}
}
