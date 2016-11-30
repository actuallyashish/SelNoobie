package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class APLoginPage {
	WebDriver driver;
	
	By loginPageEmail = By.xpath(".//*[@id='email']");
	By loginPagePswd = By.xpath(".//*[@id='passwd']");
	By loginPageSubmit = By.xpath(".//*[@id='SubmitLogin']");
	By loginPageForgotPswd= By.xpath(".//*[@id='login_form']/div/p[1]/a");
	By loginPageSignUpEmail= By.xpath(".//*[@id='email_create']");
	By loginPageSignUpBtn= By.xpath(".//*[@id='SubmitCreate']");
	
	
	public APLoginPage(WebDriver driver){
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

    public MyAccountPage loginAsValidUser(String strEmail,String strPasword) throws InterruptedException{

        //Fill user name
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        this.setEmail(strEmail);
        //Thread.sleep(10000);
        //Fill password
        //Thread.sleep(10000);
        this.setPassword(strPasword);
        //Thread.sleep(10000);
        //Click Login button

        this.clickLogin();  
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return new MyAccountPage(driver);

        

    }
    
    public APLoginPage loginAsInvalidUser(String strEmail, String strPasword) {
    	//Fill user name
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        this.setEmail(strEmail);

        //Fill password

        this.setPassword(strPasword);
        this.clickLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new APLoginPage(driver);

    }
    
    public void clickForgotPassword(){

        driver.findElement(loginPageForgotPswd).click();
        //return new ForgotPasswordPage(driver);
}
    
    public String getMessage(){

        return driver.getPageSource();
        

        //return new AmazonHomePage(driver);
}

}
