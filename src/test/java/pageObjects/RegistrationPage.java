package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	@FindBy(name="firstname")WebElement firstName;
	@FindBy(name="lastname")WebElement lastName;
	@FindBy(name="email")WebElement txtEmail;
	@FindBy(name="telephone")WebElement telephone;
	@FindBy(name="password")WebElement password;
	@FindBy(name="confirm")WebElement confirm_password;
	
	@FindBy(name="agree")WebElement checkbox;
	@FindBy(xpath="//input[@value='Continue']")WebElement continue_btn;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")WebElement confirm_msg;
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPhoneNum(String pnum)
	{
		telephone.sendKeys(pnum);
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void setConfirmPwd(String pwd)
	{
		confirm_password.sendKeys(pwd);
	}
	public void clickCheckBox()
	{
		checkbox.click();
	}
	public void clickContinue()
	{
		//continue_btn.click();
		//continue_btn.submit();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()", continue_btn);
		//Actions act=new Actions(driver);
		//act.moveToElement(continue_btn).click().perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(continue_btn)).click();
 
		//continue_btn.sendKeys(Keys.RETURN);
	}
	public String confirm()
	{
		try {
			return confirm_msg.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	


}
