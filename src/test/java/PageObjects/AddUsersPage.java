package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AddUsersPage {
	   public WebDriver oDriver;
	   String userName;
	      
	    
		public AddUsersPage(WebDriver rDriver)
	      {
	    	 oDriver=rDriver; 
	      }
	     By UsersMenu =By.xpath("//div[text()='USERS']");
	     By AddUserButton = By.xpath("//div[text()='Add User']");
	     By ShortcutClose_Button = By.xpath("//div[@id='gettingStartedShortcutsMenuCloseId']");
	     By FirstName = By.xpath("//input[@name='firstName']");
	     By LastName = By.xpath("//input[@name='lastName']");
	     By EnterEmail = By.xpath("//input[@name='email']");
	     By UsersUserName  = By.xpath("//input[@name='username']");
	     By UsersPassword = By.xpath("//input[@name='password']");
	     By RetypePassword = By.xpath("//input[@name='passwordCopy']");
	     By CreateUserButton = By.xpath("//span[text()='Create User']");
	     String UserNameLink = "//div[@class='name']/span[text()='%s']";
	     By DeleteUserButton = By.xpath("//button[contains(text(), 'Delete User')]");
	     By SaveChangesButton = By.xpath("//span[text()='Save Changes']");
		public Object creatUser;
	
      //Action methods
	     
	     public void clickOnUsersMenu() {
	    	 oDriver.findElement(UsersMenu).click();
	     }
	     public void clickShorCutCloseBtn() {
	    	 oDriver.findElement(ShortcutClose_Button).click();
	     }
	     public void clickOnAddUser() {
	    	 oDriver.findElement(AddUserButton).click();
	     }
         public void creatUser(String Fname, String Lname, String email, String uName, String pWord, String rePword ) {
        	 oDriver.findElement(FirstName).sendKeys(Fname);
        	 oDriver.findElement(LastName).sendKeys(Lname);
        	 oDriver.findElement(EnterEmail).sendKeys(email);
        	 oDriver.findElement(UsersUserName).sendKeys(uName);
        	 oDriver.findElement(UsersPassword).sendKeys(pWord);
        	 oDriver.findElement(RetypePassword).sendKeys(rePword);
       
        	  
 			}
         public void clickOnCreateUser() {
        	 oDriver.findElement(CreateUserButton).click();
         }
         public void clickOnDeleteUser() {
        	 oDriver.findElement(DeleteUserButton).click();
        
		}
}


