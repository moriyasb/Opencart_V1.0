package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BasePage;

public class BaseClass {
	
	public  static WebDriver driver; //making webdriver static since we have created object for baseclass
	//for screenshot method, so that time new set of driver will be created as part of obj creation
	//so make this static will help to maintain same driver across this baseclass and in the baseclass obj
	public Logger logger;
	public Properties p;
	//moving here all common methods into BaseClass to achieve reusability
	
	@BeforeClass (groups = {"Sanity", "Regression", "Master"})
	@Parameters({"os","browser"})	
	public void setup(String os, String br) throws IOException {
		
		//Log code
		logger = LogManager.getLogger(this.getClass()); //Log4J code
		
		//File Reader code
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		default:
			System.out.println("Invalid Browser");
			return; //This return will entirely escape from rest of the execution.
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups = {"Sanity", "Regression", "Master"})
	void teardown() {
		 if (driver != null) {
	            driver.quit();
	        }
	}
	
	//creating method for passing random string
			public String randomString() {
				String generatedAlphabet = RandomStringUtils.randomAlphabetic(5);
				return generatedAlphabet;
			}
			
			public String randomNumber() {
				String generatedNumber = RandomStringUtils.randomNumeric(10);
				return generatedNumber;
			}
			
			public String randomAlphaNumber() {
				String generatedAlphabetic = RandomStringUtils.randomAlphabetic(3);
				String generatedNumeric = RandomStringUtils.randomNumeric(3);
				return (generatedAlphabetic+"@"+generatedNumeric);
			}
		
			
			//method for capturing screenshot
			public String captureScreen(String tname) {
				String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
				File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
				//file name for screenshot
				String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
				File targetFile=new File(targetFilePath);
				
				sourceFile.renameTo(targetFile);
				
				//returning path of the file so we can use it in report.
				return targetFilePath;
				
			}

}
