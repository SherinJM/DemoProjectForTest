package configurationManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationReader {

	public static String getProperty(String key) throws Exception {

		File file = new File(".//Config//Config.properties");
		FileInputStream fis;
		Properties pro;

		fis = new FileInputStream(file);
		pro = new Properties();
		pro.load(fis);
		String keyValue = pro.getProperty(key);

		return keyValue;

	}

}
