                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	//constructor to invoke basepage constructor for initiating pagefactory
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(id="input-email")
	WebElement setEmail;
	
	@FindBy(id="input-password")
	WebElement setPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;

	//Action methods
	public void inputEmail(String email) {
		setEmail.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		setPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
