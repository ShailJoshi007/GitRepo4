package Practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.Excel_Utility;

public class DataProviderEx3 {
	@Test(dataProvider="getData")
	public void bookTickets(String src, String dest)
	{
		System.out.println("Book Ticket from source"+src+ "to destination"+dest);
	}
	
@DataProvider
	public Object[][] getData() throws Throwable
	{
	Excel_Utility elib = new Excel_Utility();		
	 Object[][] value = elib.fetchMultipleData("DataProvider");
		//	String ProductName = elib.fetchMultipleData();
		return value;
		
	}

}
