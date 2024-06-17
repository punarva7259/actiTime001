package StepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddUsersPage;
import PageObjects.LoginPage;

public class BaseClass {
	//initialize the ChromeDriver
   public WebDriver oDriver;
   
	//initialize the Login and AddUser pages
	public LoginPage lp;
	public AddUsersPage up;
	
	//Here we create logger instance
    public Logger logger;
    
    //initialize the Property file
    public Properties configProp;
}
