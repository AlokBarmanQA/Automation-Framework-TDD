package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesReader {
	
	static Properties prop;
	public static String getPropertyValueByKey(String key) {
		// load property file
		prop = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/properties/data.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		// read data
		String propertyValue = prop.get(key).toString();
		
		if(StringUtils.isEmpty(propertyValue)) {
			try {
				throw new Exception("Value is not specified for: " + key + " in Properties file");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return propertyValue;
	}

}
