package Library_files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_class 
{
	//Initialize browser
	
	public WebDriver driver;  //declared it as global and public as we can call it in any class
	
	public void InitializeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pravin\\eclipse-workspace\\MAVEN\\Browser\\chromedriver.exe");
		driver= new ChromeDriver();
		
		Thread.sleep(3000);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}
