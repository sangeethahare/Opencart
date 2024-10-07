package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC_001AccountRegisterTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","master"})	
	public void verify_Acc_Register()
	{
		logger.info("Verifing Account RegisterTestcase ...");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage rg=new RegistrationPage(driver);
		rg.setFirstName(randomString().toUpperCase());
		rg.setLastName(randomString().toUpperCase());
		rg.setEmail(randomString()+"@gmail.com");
		rg.setPhoneNum(randomNumber());
		String password=randomAlphaNumeric();
		rg.setPassword(password);
		rg.setConfirmPwd(password);
		rg.clickCheckBox();
		rg.clickContinue();
		logger.info("loginbutton clicked....");
		String confirm_msg = rg.confirm();
		Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("testing finished..");
}
	
}
