package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class APLoginPageError {
WebDriver driver;
	
	By loginErrorMsg = By.xpath(".//*[@id='center_column']/div[1]/p");
	By signupErrorMsg=By.id("create_account_error");
	 public APLoginPageError(WebDriver driver){
    	this.driver = driver;
    } 

  
    //Get the title of Home Page
    public WebElement loginError(){
    	return driver.findElement(loginErrorMsg);
    }
    
    public WebElement signUpError(){
    	return driver.findElement(signupErrorMsg);
    }
}
