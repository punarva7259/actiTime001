package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
        
        
public class LoginPage {
	     public WebDriver oDriver;  
	     
	      public LoginPage(WebDriver rDriver)
	      {
	    	  oDriver=rDriver;
	      }
		     By UserName = By.xpath("//input[@id='username']");
		     By Password = By.xpath("//input[@name='pwd']");
		     By Login_Button = By.xpath("//a[@id='loginButton']");
		     By LoginLogo_Img = By.xpath("//img[contains(@src, 'timer.png')]");
		     By PageHeder=By.xpath("//td[@class='pagetitle']");
		     By ShortCut_Button=By.xpath("//div[@id='gettingStartedShortcutsMenuCloseId']");
             By Logout_Button=By.xpath("//a[@id='logoutLink']");

//Action Methods
 
   public void setUserName(String uname)
   {
	  oDriver.findElement(UserName).sendKeys(uname); 
   }
   public void setPassword(String pword)
   {
	   oDriver.findElement(Password).sendKeys(pword);
   }
   public void clickLogin()
   {
	   oDriver.findElement(Login_Button).click();
   }
   
   public void clicklogout()
   {
	   oDriver.findElement(Logout_Button).click();
   }
   
  
}
