package Login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.Base_class;
import Library_files.UtilityClass;
import Module_login.OrangeHRMLoginPage1;
import Module_login.OrangeHRMPIMpage1;

public class OrangeHRM_TestNG_TestClass extends Base_class
{
	//extended base class
	//browser is initialized
	
	//creating objects of POM classes
	OrangeHRMLoginPage1 Login1;
	OrangeHRMPIMpage1 PIMPage1;
	
	int TestCaseID;
	
	@BeforeClass
	public void openbrowser() throws InterruptedException
	{
		InitializeBrowser();    //method from base class
		
		//creating object of both POM classes
		Login1=new OrangeHRMLoginPage1(driver);
		
		PIMPage1= new OrangeHRMPIMpage1(driver);
				
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		Login1.EnterUsername(UtilityClass.getdatafromPF("UN"));
		Login1.EnterPassword(UtilityClass.getdatafromPF("PSW"));
		Login1.ClickLoginbtn();
	}
	
	@Test
	public void verifyUsername() throws EncryptedDocumentException, IOException
	{
		TestCaseID=100;
		String actualUsername =PIMPage1.getUsername();
		String expectedUsername=UtilityClass.getdatafromExcel(0, 2);
		
		Assert.assertEquals(actualUsername, expectedUsername);  //verifying testcase
	}
	
	@Test
	public void verifyTitle() throws EncryptedDocumentException, IOException
	{
		TestCaseID=200;
		String actualTttle= driver.getTitle();
		System.out.println(actualTttle);
		String expectedTitle= UtilityClass.getdatafromExcel(1, 0);
		
		Assert.assertEquals(actualTttle, expectedTitle); // verifying testcase
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException //ITestResult is an interface gives result as pass or fail
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TestCaseID);
		}
		
		PIMPage1.clickonUsername();
		PIMPage1.clickonLogoutbtn();
		
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	

}
