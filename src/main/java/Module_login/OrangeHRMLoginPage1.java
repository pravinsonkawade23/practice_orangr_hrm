package Module_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage1 
{
	//POM 1
	
	//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation  
	@FindBy(xpath = "//input[@name='username']") private WebElement UN;
	@FindBy(xpath = "//input[@name='password']") private WebElement PSW;
	@FindBy(xpath = "//button[text()=' Login ']")private WebElement LoginBtn;
	
	//2. Initialize within a constructor with access level public using pagefactory
	
	public OrangeHRMLoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3. Utilize within a method with access level public
	
	public void EnterUsername(String Username)
	{
		UN.sendKeys(Username);
	}
	
	public void EnterPassword(String Password)
	{
		PSW.sendKeys(Password);
	}
	
	public void ClickLoginbtn()
	{
		LoginBtn.click();
	}
	
	

}
