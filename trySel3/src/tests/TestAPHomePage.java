package tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;


import pages.APHomePage;
import setup.TestSetUp;

public class TestAPHomePage{
	

	WebDriver driver;
	//String url;
	APHomePage objHomePage; 
	TestSetUp objSetUp=new TestSetUp(this.getClass());
	//TestSetUp objSetUp;
	
	//static Logger log=Logger.getLogger(TestAPHomePage.class);
  
  @Test
  public void testHomePage(){

      //Create Home Page object
	  objHomePage = new APHomePage(driver);
	  

  //Verify page title
	  try{
	  String actualTitle = objHomePage.getHomePageTitle();
	  String expectedTitle = "My Store";
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
		  Reporter.log("Error in home page search button");
		  Reporter.log(e.getMessage());
		  
	  }
	   
	  
	  //cat nav
	  try{
	   WebElement catNav =objHomePage.getHomePageCatNav();
	   assertEquals(true, catNav.isDisplayed());
	   
	   Reporter.log("cat nav done");
	   }
	  catch (AssertionError e){
		  
		  Reporter.log("Error in home page cat nav");
		  Reporter.log(e.getMessage());
	  }
	   
	   //categories
	 /* if(flag==true){
		  try{
			  Actions act=new Actions(driver);
			  act.moveToElement(objHomePage.getHomePageCatNav()).build().perform();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			  WebElement categories =objHomePage.getHomePageSubCategories();
			  assertEquals(true, categories.isDisplayed());
			  Reporter.log("categories done");
		  }
		  catch (AssertionError e){
			  Reporter.log("Error in home page categories");
			  Reporter.log(e.getMessage());
		  }
	  } */
	   
	  
	  
  
  }
  
  
  @BeforeTest
  public void setUp() {
	  /*BasicConfigurator.configure();
	  ConsoleAppender ca=new ConsoleAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN));
	  log.addAppender(ca);
	  /*driver = new FirefoxDriver();
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  url = "http://www.automationpractice.com";
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
	  //objSetUp=new TestSetUp();
	  //objSetUp=new TestSetUp(this.getClass());
	  driver=objSetUp.setTest();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }

}
