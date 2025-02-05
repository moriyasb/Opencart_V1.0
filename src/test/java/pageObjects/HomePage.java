package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//Each Page Object Class having below 3 items 
	//1) Constructor
	public HomePage(WebDriver driver)
	{
		super(driver); //passing driver to the BasePage parent and invoking the constructor using super keyword
		//Inheritance concept-reusability
	}
	
	//2) Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")
	WebElement lnklogin;
	
	//3) Action Methods
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnklogin.click();
	}
}
