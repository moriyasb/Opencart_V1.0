package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	 WebDriver driver;
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//Instead of adding this in every pageobject class, we are denoting a separate basepage class 
		//and adding this constructor, so we can invoke for every PageObject Classes
	}
}
