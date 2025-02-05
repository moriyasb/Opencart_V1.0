package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups = {"Datadriven", "Master"})
	//mentioning additional
	//parameter dataProviderClass since DP is created outside of this class and outside of package.
	void verify_LoginDDT(String email, String password, String exp)
	//passing above 3 parameters since dp method returns those 3 data in the array format. 
	//this is because dp method fetched those 3 data from excel and loaded already into array.
	{
	try
	{
		logger.info("***** TC003_LoginDDT started *****");
		
		HomePage hp = new HomePage(driver);
		logger.info("***** Clicking My Account and Login button *****");
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("***** Passing User credentials *****");
		LoginPage lp = new LoginPage(driver);
		lp.inputEmail(email);
		lp.inputPassword(password);
		lp.clickLogin();
		
		logger.info("***** Validating User Creds is valid/not valid *****");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExist();
		
		//Four type of scenarios used for this test case validation. 
		//User Creds - valid / Login success --> Test Pass
		//User Creds - valid / Login failed -->  Test Fail
		//User Creds - invalid / Login success --> Test Fail
		//User Creds - invalid / Login failed --> Test Pass
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				macc.logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				macc.logout();
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
		logger.info("***** TC003_LoginDDT completed *****");
	}
}
