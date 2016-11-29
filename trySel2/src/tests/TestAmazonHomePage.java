package tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.AmazonHomePage;

public class TestAmazonHomePage{
	WebDriver driver;
	String url;
	AmazonHomePage objHomePage; 
	boolean flag;
	static Logger log=Logger.getLogger(TestAmazonHomePage.class);
  
  @Test
  public void testHomePage(){

      //Create Home Page object
	  objHomePage = new AmazonHomePage(driver);
	  

  //Verify page title
	  try{
	  String actualTitle = objHomePage.getHomePageTitle();
	  String expectedTitle = "Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	  assertEquals(actualTitle, expectedTitle);
	  Reporter.log("title done");
	  }
	  catch (AssertionError e){
		  Reporter.log("Error in home page title");
		  Reporter.log(e.getMessage());
	  }

  //header
	  try{
	   WebElement header =objHomePage.getHomePageHeader();
	   assertEquals(true, header.isDisplayed());
	   Reporter.log("header done");
	  }
	  catch (AssertionError e){
		  Reporter.log("Error in home page header");
		  Reporter.log(e.getMessage());
	  }

	   
	 //logo
	  try{
	   WebElement logo =objHomePage.getHomePageLogo();
	   assertEquals(true, logo.isDisplayed());
	   Reporter.log("logo done");
	  }
	  catch (AssertionError e){
		  Reporter.log("Error in home page logo");
		  Reporter.log(e.getMessage());
	  }
	 
	  
	 //search bar
	  try{
	   WebElement searchbar =objHomePage.getHomePageSearchBar();
	   assertEquals(true, searchbar.isDisplayed());
	   Reporter.log("search bar done");
	  }
	  catch (AssertionError e){
		  Reporter.log("Error in home page search bar");
		  Reporter.log(e.getMessage());
		  
	  }
	  
	  
	  //search button
	  try{
	   WebElement searchbutton =objHomePage.getHomePageSearchButton();
	   assertEquals(true, searchbutton.isDisplayed());
	   Reporter.log("search button done");
	  }
	  catch (AssertionError e){
		  Reporter.log("Error in home page search bar");
		  Reporter.log(e.getMessage());
		  
	  }
	   
	  
	  //cat nav
	  try{
	   WebElement catNav =objHomePage.getHomePageCatNav();
	   assertEquals(true, catNav.isDisplayed());
	   flag=true;
	   Reporter.log("cat nav done");
	   }
	  catch (AssertionError e){
		  flag=false;
		  Reporter.log("Error in home page cat nav");
		  Reporter.log(e.getMessage());
	  }
	   
	   //categories
	  if(flag==true){
		  try{
			 /* Actions act=new Actions(driver);
			  act.moveToElement(objHomePage.getHomePageCatNav()).build().perform();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
			  WebElement categories =objHomePage.getHomePageCategories();
			  assertEquals(true, categories.isDisplayed());
			  Reporter.log("categories done");
		  }
		  catch (AssertionError e){
			  Reporter.log("Error in home page categories");
			  Reporter.log(e.getMessage());
		  }
	  }
	   
	  
  
  }
  
  
  @BeforeTest
  public void setUp() {
	  BasicConfigurator.configure();
	  ConsoleAppender ca=new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN));
	  log.addAppender(ca);
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  url = "http://www.amazon.in";
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
