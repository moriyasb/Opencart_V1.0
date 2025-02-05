package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testCases.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_UserAccountRegistration extends BaseClass{
	
	
	//keeping only @Test method in Test Cases
	@Test (groups = {"Regression", "Master"})
	void verify_account_registration() {
		try
		{
		logger.info("***** TC001_UserAccountRegistration started *****");
		HomePage hp = new HomePage(driver);//passing driver for constructor @ homepage pageobject class
		
		logger.info("***** Clicking MyAccount option *****");
		hp.clickMyAccount();
		
		logger.info("***** Clicking Register option *****");
		hp.clickRegister();
		
		logger.info("***** Filling up all registration details *****");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName("ABC");
		regpage.setLastName("CDE");
		regpage.setEmail(randomString()+"@gmail.com");//randomstring user defn.mtds created in baseclass
		regpage.setPhone(randomNumber());
		String pass = randomAlphaNumber();
		regpage.setPassword(pass);
		regpage.setcfnpassword(pass);
		regpage.checkAgree();
		regpage.clickContinue();
		String cnfmsg=regpage.getConfirmationMsg();
		
		logger.info("***** Validating Success Message *****");
		if(cnfmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else{
			logger.error("*** Test Failed ***");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		}
		//catch will be executed and fail the test case
		//if previous step assertion is failed (else block).
		//If validation code is like Assert.assertEquals(cnfmsg, "Your Account Has Been Created!")
		//instead of if else, then test case is failed and rest of the steps (catch block) is not 
		//executed since its a hard assert.
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("***** TC001_UserAccountRegistration completed *****");

	}
	
	
}
