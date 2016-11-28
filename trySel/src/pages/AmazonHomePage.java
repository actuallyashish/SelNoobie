package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
	WebDriver driver;
	
	By homePageHeader = By.id("navbar");
	By homePageLogo = By.xpath(".//*[@id='nav-logo']/a[1]/span[1]");
	By homePageSearchBar = By.xpath(".//*[@id='twotabsearchtextbox']");
	By homePageSearchButton= By.xpath(".//*[@id='nav-search']/form/div[2]/div/input");
	By homePageCatNav= By.xpath(".//*[@id='nav-link-shopall']/span[2]");
	By homePageCategories= By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]");
    public AmazonHomePage(WebDriver driver){
    	this.driver = driver;
    }

  
    //Get the title of Login Page
    public String getHomePageTitle(){
    	return driver.getTitle();
    }
    
    /*try {
        driver.findElement(By.id(id));
    } catch (NoSuchElementException e) {
        return false;
    }
    return true;*/
    
    
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
    	return driver.findElement(homePageCategories);
    }
    
    

}
