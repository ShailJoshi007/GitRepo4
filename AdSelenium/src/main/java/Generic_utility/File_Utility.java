package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	public String getStringKeyAndValue(String key) throws Throwable{
		
	//	FileInputStream fis1 = new FileInputStream("src/test/resources/VTigerProp.properties");
		FileInputStream fis1 = new FileInputStream("src/test/resources/CommonData.properties");
		//https://demo.vtiger.com/vtigercrm/index.php
		System.out.println("1");	
		Properties pro = new Properties();
		pro.load(fis1);
		String value = pro.getProperty(key);
		return value;
	}
}
