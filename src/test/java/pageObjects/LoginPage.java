package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	//locator
	@FindBy(id="input-email") WebElement txtemail;
	@FindBy(id="input-password") WebElement txtpwd;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	//action methods
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void setPwd(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	public void clickLoginBtn()
	{
		loginbtn.click();
	}

}
