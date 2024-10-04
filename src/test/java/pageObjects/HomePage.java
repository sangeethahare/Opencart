package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public WebDriver driver;
	//constructor
	public  HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locator
	@FindBy(xpath="//span[normalize-space()='My Account']")WebElement MyAcc;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")WebElement Register;
	@FindBy(linkText="Login") WebElement login;
	//Actions
	public void clickMyAccount()
	{
	
		MyAcc.click();
	}
	public void clickRegister()
	{
	
		Register.click();
	}
public void clickLogin()
{
	login.click();}
}
