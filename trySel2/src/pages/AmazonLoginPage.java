package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AmazonLoginPage {
	WebDriver driver;
	
	By loginPageEmail = By.xpath(".//*[@id='ap_email']");
	By loginPagePswd = By.xpath(".//*[@id='ap_password']");
	By loginPageSubmit = By.xpath(".//*[@id='signInSubmit']");
	By loginPageForgotPswd= By.xpath(".//*[@id='auth-fpp-link-bottom']");
	By loginPageSignUp= By.xpath(".//*[@id='createAccountSubmit']");
	
	
	public AmazonLoginPage(WebDriver driver){
    	this.driver = driver;
    }
	
	 //Get the title of Login Page
    public String getLoginPageTitle(){
    	return driver.getTitle();
    }
	
	public void setEmail(String strUserEmail){

        driver.findElement(loginPageEmail).sendKeys(strUserEmail);

    }
	
	//Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(loginPagePswd).sendKeys(strPassword);

    }
    
    //Click on login button

    public void clickLogin(){

            driver.findElement(loginPageSubmit).click();
            //return new AmazonHomePage(driver);
    }
    
    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return
     * @throws InterruptedException 

     */

    public AmazonHomePage loginToAmazonAsValidUser(String strEmail,String strPasword) throws InterruptedException{

        //Fill user name
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        this.setEmail(strEmail);
        Thread.sleep(10000);
        //Fill password
        Thread.sleep(10000);
        this.setPassword(strPasword);
        Thread.sleep(10000);
        //Click Login button

        this.clickLogin();  
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return new AmazonHomePage(driver);

        

    }
    
    public AmazonLoginPage loginToAmazonAsInvalidUser(String strEmail, String strPasword) {
    	//Fill user name

        this.setEmail(strEmail);

        //Fill password

        this.setPassword(strPasword);
        this.clickLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;

    }}
