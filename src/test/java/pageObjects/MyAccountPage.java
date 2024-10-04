package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	//constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	//locator
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']") WebElement msgHeading;
	@FindBy(linkText="Logout")WebElement logoutlnk;
	//action method
	public boolean isMyAccountPageExists()
	{
		try {
			return msgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
public void clicklogout()
{
	logoutlnk.click();}
}
