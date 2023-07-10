package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Excel_Utility {
	
	/**
	 * This method is used to fetch data from excelsheet
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String SheetName, int rowNum,int cellNum) throws Throwable
	{
		//Step 1: Set the path
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDataWrite1.xlsx");
		//FileInputStream fis = new FileInputStream("TestDataWrite1.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		//Step 3: get the control to the sheet
		Sheet sh = book.getSheet(SheetName);
		//Step 4: get the control to the row
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);		
		String value = cel.getStringCellValue();
		return value;
	
	}
	

	
	/**
	 * This method is used to fetch data from excelsheet using DataFormatter
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelDataUsingDataFormatter(String SheetName, int rowNum,int cellNum) throws Throwable
	{
		//Step 1: Set the path
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();		
		String value = format.formatCellValue( book.getSheet(SheetName).getRow(rowNum).getCell(cellNum));		
		return value;
	
	}
	
	public void setExcelData(List<WebElement> allLinks,String SheetName) throws Throwable
	{
		//Step 1: Set the path
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		System.out.println(allLinks.size());
		Sheet sh = book.getSheet(SheetName);
		for(int i = 0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());			
			Row row = sh.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getText());
			
		}
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
        book.write(fos);
        book.close();
	
	}
	
	public Object[][] fetchMultipleData(String sheetName) throws Throwable, IOException
	{

		//Step 1: Set the path
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestDataWrite1.xlsx");
		//FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Desktop\\FlipkartDta.xlsx");
		FileInputStream fis = new FileInputStream("/Users/shail/Documents/TestDataWrite1.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		System.out.println(sheetName);
		//Step 3: get the control to the sheet
		Sheet sh = book.getSheet(sheetName);
		
		
		//Step 4: get the control to the row
		System.out.println(sh.getLastRowNum());
		
		int lastRow=sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		
		//obj[0][1]= "trainee";	
		//begin from here
		
		for(int i=0;i<lastRow;i++)
		{
		
			//Row row = sh.getRow(i);
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
					System.out.println(obj[i][j]);
			}
							
		}
		return obj;
	
	}
}
