package tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.AmazonHomePage;
import pages.AmazonLoginPage;

public class TestAmazonLoginPage {
	WebDriver driver;
	String url;
	AmazonHomePage objHomePage; 
	AmazonLoginPage objLoginPage;
	boolean flag;
	static Logger log=Logger.getLogger(TestAmazonHomePage.class);
  
	
	
	
  @Test
  public void testHomePage() throws InterruptedException {
	  objLoginPage = new AmazonLoginPage(driver);
	  
	//Verify page title
	  try{
	  String actualTitle = objLoginPage.getLoginPageTitle();
	  String expectedTitle = "Amazon Sign In";
	  assertEquals(actualTitle, expectedTitle);
	  Reporter.log("title done");
	  }
	  catch (AssertionError e){
		  Reporter.log("Error in home page title");
		  Reporter.log(e.getMessage());
	  }
	  
	  
	  //login to application

	   objHomePage = objLoginPage.loginToAmazonAsValidUser("ashisht020@gmail.com", "as278620");
	   Reporter.log("Sign in valid");

	    // go the next page

	    //objHomePage = new AmazonHomePage(driver);

	    //Verify home page
	    try{
	    	WebElement signOut=objHomePage.getHomePageSignOut();
	    	assertEquals(true, signOut.isDisplayed());
	    }
	    catch (AssertionError e){
			  Reporter.log("Error in login");
			  Reporter.log(e.getMessage());
		  }
	    
	    objLoginPage = objLoginPage.loginToAmazonAsInvalidUser("mgr123", "mgr!23");
	    Reporter.log("Sign in Invalid");
	    
	    }
	  
	  
  
 
  
  
  @BeforeTest
  public void setUp() {
	  BasicConfigurator.configure();
	  ConsoleAppender ca=new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN));
	  log.addAppender(ca);
	  //System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  url = "https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin";
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //objHomePage.getHomePageSignIn().click();
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
