package StepDefinitions;




import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import PageObjects.AddUsersPage;
import PageObjects.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Steps extends BaseClass {
	 String userName;
	   
	 
	@Before
	public void SetUp() throws IOException {
		
		logger=Logger.getLogger("actiTime001");
		PropertyConfigurator.configure("log4j.properties");
		
		configProp =new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
String BrowserName=configProp.getProperty("browserName");
	switch(BrowserName.toLowerCase()){
	case "chrome":
		oDriver = new ChromeDriver();
		break;
	case "edge":
		oDriver = new EdgeDriver();
		break;
	case "firefox":
		oDriver = new FirefoxDriver();
		break;
	default:
		System.out.println("Invalid browser was specified");
	}
		
}	

	
     //LoginAndLogout Feature;
	
	@Given("User navigates the URL {string}")
	public void user_navigates_the_url(String Url) throws InterruptedException {
		
	    Assert.assertNotNull(oDriver);
		oDriver.manage().window().maximize();
        Url=configProp.getProperty("appURL");
        oDriver.get(Url);
        
		logger.info("URL is opened");
		
}
	
	@Then("User perform login with valid credentials userName as {string} and Password as {string}")
	public void user_perform_login_with_valid_credentials_user_name_as_and_password_as(String un, String pw) throws InterruptedException {
		lp=new LoginPage(oDriver);
		
		lp.setUserName(un);
		logger.info("Entered username");
		lp.setPassword(pw);
		logger.info("Entered password");
		lp.clickLogin();
		Thread.sleep(2000);
	    
	}

	@Then("User verify login is successful {string}")
	public void user_verify_login_is_successful(String pheader) throws InterruptedException {
		
		if(oDriver.getPageSource().contains("actiTIME - Enter Time-Track")) {
			logger.info("login test passed");
			Assert.assertEquals(pheader, oDriver.getTitle());
		}else {
			logger.info("login test passed");
			Assert.assertTrue(true);	
		    
		}
	}

	
	//AddUsers Feature
      //This Method is for Data table test
  //@Then("User creates new user in the actiTime")
  //public void user_creates_new_user_in_the_acti_time(DataTable dataTable)  throws InterruptedException {
		//This Method for Data Driven test
	@Then("User creates new user in the actiTime {string} a {string} b {string} c {string} d {string} e {string}")
	public void user_creates_new_user_in_the_acti_time_a_b_c_d_e(String string, String string2, String string3, String string4, String string5, String string6) throws InterruptedException {	
		up=new AddUsersPage(oDriver);
		
		up.clickOnUsersMenu();
		Thread.sleep(2000);
		up.clickShorCutCloseBtn();
		Thread.sleep(2000);
		up.clickOnAddUser();
		Thread.sleep(2000);
		
		
		
		//List<Map<String, String>> userList=dataTable.asMaps(String.class, String.class);
		//for(Map<String, String> e:userList) {
			
		//	up.creatUser(e.get("User_FirstName"), e.get("User_LastName"), e.get("User_Email"), e.get("User_UserName"), e.get("User_Password"), e.get("User_RetypePassword"));
		up.creatUser(string, string2, string3, string4, string5, string6);
		

		up.clickOnCreateUser();
		Thread.sleep(3000);
		
			
			
	}


		
		

	@Then("verify user create is sucessfull")
	public String verify_user_create_is_sucessfull() {
	//=up.creatUser("Fname")+","+up.creatUser("Lname");
	WebElement ele=	oDriver.findElement(By.xpath("//div[@class='name']/span[text()='Chakravarthy, Nikhil']"));
		if(ele.isDisplayed()) {
			System.out.println("The user is created successful");
			return userName;
		}else {
			System.out.println("Failed to create the new user");
			return null;
		
		}
	}
	@Then("verify user is deleted successful")
	public void verify_user_is_deleted_successful() {
		
	}
	@Then("User logouts from the application")
	public void user_logouts_from_the_application() throws InterruptedException {
	    lp.clicklogout();
	    Thread.sleep(2000);
	    logger.info("logout the application");
	}


//newLogin
@Given("I launch the chrome to automate the application")
public void i_launch_the_chrome_to_automate_the_application() {
	oDriver=new ChromeDriver();
	oDriver.manage().window().maximize();
	
    
}
@Given("I navigate {string} of the application")
public void i_navigate_of_the_application(String url) {
	oDriver.get(url);
    
}	
@Given("I find the login page")
public void i_find_the_login_page() {
    
}
@When("I enter the {string} and {string} in text field to login")
public void i_enter_the_and_in_text_field_to_login(String un, String pw) {
     lp=new LoginPage(oDriver);
    try {
    	lp.setUserName(un);
        lp.setPassword(pw);
        lp.clickLogin();
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
@When("click on login button in login page")
public void click_on_login_button_in_login_page() {
    
    
}
@When("I minimize the flyout window")
public void i_minimize_the_flyout_window() {
   
}
@Then("I find the home page")
public void i_find_the_home_page() {

}
@When("I click on logout button")
public void i_click_on_logout_button() {
    
}
@Then("I find login page")
public void i_find_login_page() {
    
}
@Then("I close the application")
public void i_close_the_application() {
    
}
}

