package dataprovider;

import org.testng.annotations.DataProvider;

import excelhandler.ExcelReader;

public class CustomDataProvider {

	@DataProvider(name = "loginDataSet")
	public static Object[][] getData() {

		Object arr[][] = ExcelReader.getDataFromSheet("login");
		return arr;
	}
	
	@DataProvider(name = "signup")
	public static Object[][] getSignUpData() {

		Object arr[][] = ExcelReader.getDataFromSheet("signup");
		return arr;
	}

}
