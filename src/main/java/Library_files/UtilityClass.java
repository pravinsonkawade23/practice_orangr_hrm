package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass 
{
	//to fetch data from property file
	
	@Test
	public static String getdatafromPF(String key) throws IOException
	{
		//reach to property file
		FileInputStream file= new FileInputStream("C:\\Users\\pravin\\eclipse-workspace\\MAVEN\\property_file1.properties");
		
		//create object of properties class
		Properties prop= new Properties();
		
		//open property file
		prop.load(file);
		
		//to fetch data from property file
		String value1=prop.getProperty(key);
		
		return value1;
		
	}
	
	//to fetch data from excel file
	
	@Test
	public static String getdatafromExcel(int rowindex, int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\pravin\\eclipse-workspace\\MAVEN\\Test_data\\parameterization.xlsx");
		
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet6");
		String value2 =sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value2;
	}
	
	//to capture screenshot
	
	@Test
	public static void captureScreenshot(WebDriver driver, int TestCaseID) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		
		//create object of file class
		File destination= new File("C:\\Users\\pravin\\eclipse-workspace\\MAVEN\\Screenshot\\" +TestCaseID+".jpg");
		
		//to move screenshot to destination folder
		FileHandler.copy(source, destination);
		
	}
	
	
}
