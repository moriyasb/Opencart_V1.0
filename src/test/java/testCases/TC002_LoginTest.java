package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{

	@Test (groups = {"Sanity", "Master"})
	void verify_UserLogin() {
		try
		{
		logger.info("**** TC002_LoginTest started *****");
		HomePage hp = new HomePage(driver);
		logger.info("**** Clicking Myaccount and Login link ******");
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("*** Entering UN and PASS details ****");
		LoginPage lp = new LoginPage(driver);
		lp.inputEmail(p.getProperty("email")); //fetching data from properties file-->invoked from setup method in baseclass
		lp.inputPassword(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("*** validating MyAccountHeading ****");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		Assert.assertTrue(targetPage);
		//other way --> Assert.assertEquals(targetPage, true, "LoginFailed-Failure Message")
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC002_LoginTest ****");
	}
}
