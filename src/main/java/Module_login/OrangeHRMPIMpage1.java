package Module_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPIMpage1 
{
	//POM 2
	
	//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']") private WebElement Username;
	
	@FindBy(xpath = "//a[text()='Logout']") private WebElement LogoutBtn;
	
	
	//2. Initialize within a constructor with access level public using pagefactory
	
	public OrangeHRMPIMpage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//3. Utilize within a method with access level public
	
	public String getUsername()
	{
		String ActResult =Username.getText();
		
		return ActResult;
	}
	
	public void clickonUsername()
	{
		Username.click();
	}
	
	public void clickonLogoutbtn()
	{
		LogoutBtn.click();
	}
	
	
	
}
