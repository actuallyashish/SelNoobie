package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonHomePage {
	WebDriver driver;
	//Actions act=new Actions(driver);
	
	By homePageHeader = By.id("navbar");
	By homePageLogo = By.xpath(".//*[@id='nav-logo']/a[1]/span[1]");
	By homePageSearchBar = By.xpath(".//*[@id='twotabsearchtextbox']");
	By homePageSearchButton= By.xpath(".//*[@id='nav-search']/form/div[2]/div/input");
	By homePageCatNav= By.xpath(".//*[@id='nav-link-shopall']/span[2]");
	By homePageCategories= By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]");
    By homePageSignIn=By.xpath(".//*[@id='nav-link-yourAccount']/span[1]");
    By homePageSignOut=By.xpath(".//*[@id='nav-item-signout']/span");
	
	public AmazonHomePage(WebDriver driver){
    	this.driver = driver;
    }

  
    //Get the title of Home Page
    public String getHomePageTitle(){
    	return driver.getTitle();
    }
    
    
    
    
    //Get the User name from Home Page
    public WebElement getHomePageHeader(){
    	return driver.findElement(homePageHeader);
    }
    
    
    public WebElement getHomePageLogo(){
    	return driver.findElement(homePageLogo);
    }
    
    
    public WebElement getHomePageSearchBar(){
    	return driver.findElement(homePageSearchBar);
    }
    
    
    public WebElement getHomePageSearchButton(){
    	return driver.findElement(homePageSearchButton);
    }
    
    
    public WebElement getHomePageCatNav(){
    	return driver.findElement(homePageCatNav);
    }
    
    public WebElement getHomePageCategories(){
    	  Actions act=new Actions(driver);
		  act.moveToElement(getHomePageCatNav()).build().perform();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  return driver.findElement(homePageCategories);
    }
    
    
    public WebElement getHomePageSignIn(){
    	return driver.findElement(homePageSignIn);
    }
    
    public WebElement getHomePageSignOut(){
    	Actions act1=new Actions(driver);
    	act1.moveToElement(getHomePageSignIn()).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	return driver.findElement(homePageSignOut);
    }
    
    

}
