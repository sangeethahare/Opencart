package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void Verify_Login()
	{try {
		logger.info("**** started TC_002 logintest****");
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		//loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("pwd"));
		lp.clickLoginBtn();
		//Myaccountpage
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage = map.isMyAccountPageExists();
		Assert.assertTrue(targetpage);
		}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("**** finished TC_002 logintest****");
	}

}
