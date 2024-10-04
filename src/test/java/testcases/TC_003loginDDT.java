package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003loginDDT extends BaseClass{
	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("****TC003_loginDDT started******");
		  try {     //homepage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				//loginpage
				LoginPage lp=new LoginPage(driver);
				lp.setEmail("email");
				lp.setPwd("pwd");
				lp.clickLoginBtn();
				//Myaccountpage
				MyAccountPage map=new MyAccountPage(driver);
				boolean targetpage = map.isMyAccountPageExists();
			
				//valid data-login success-test pass-logout
				//valid data-login fail-test fail
				if(exp.equalsIgnoreCase("valid"))
				{
					if(targetpage==true)
					{
						map.clicklogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				//Invalid data-login success-test fail-logout
				//Invalid data-login fail-test pass
				
				if(exp.equalsIgnoreCase("invalid"))
				{
					if(targetpage==true)
					{
						map.clicklogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				
						}
		  }
		  catch(Exception e)
		  {
			  Assert.fail();
		  }
		  logger.info("*****TC003_loginDDT finished****");
	}

}
