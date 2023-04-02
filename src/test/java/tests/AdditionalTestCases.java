package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class AdditionalTestCases extends BaseClass {

	@Test
	public void validateBrokenLinks() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		lp.brokenLinks();
	}

	@Test
	public void validateCountOfButtons() throws Exception {
		System.out.println(Thread.currentThread().getId());
		lp = new LoginPage(driver);
		int no = lp.countOfButtons();
		Assert.assertEquals(12, no, "Size is not matching");
	}

	@Test
	public void validateSample() throws Exception {
		System.out.println(Thread.currentThread().getId());
		System.out.println("Sample");
		System.out.println(driver.getCurrentUrl());

	}

}
