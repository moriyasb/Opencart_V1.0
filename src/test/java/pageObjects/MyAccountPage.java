package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	//constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	//locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccountheading;
	
	@FindBy(linkText = "Logout")
	WebElement btnLogout;
	
	//Action methods
	public boolean isMyAccountPageExist() {
		try //Adding try catch here because if is displayed is false then this will error or throw 
		//exception so to handle the scenario we add try/catch.
		{
			return(myaccountheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void logout() {
		btnLogout.click();
	}
}
