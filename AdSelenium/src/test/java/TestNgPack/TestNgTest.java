package TestNgPack;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.File_Utility;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestNgTest extends BaseClass{

	@Test
	public void createContact() throws Throwable
	{
		
		File_Utility flib = new File_Utility();
		System.out.println("Contact Created");
		//String URL = flib.getStringKeyAndValue("url");
		//System.out.println(URL);
		//driver.get(URL);
	}
	
	public void createModified()
	{
		System.out.println("Contact Modified");
	}

	public void createDeleted()
	{
		System.out.println("Contact Deleted");
	}

}
