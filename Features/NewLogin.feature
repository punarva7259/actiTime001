
  Feature: Verify login and logout functionalities
  
Scenario Outline: Verify login functionality
Given I launch the chrome to automate the application
And I navigate "<url>" of the application
And I find the login page
When I enter the "<username>" and "<password>" in text field to login 
And click on login button in login page
And I minimize the flyout window
Then I find the home page
When I click on logout button
Then I find login page
And I close the application

Examples:
|url|username|password|
|http://localhost/login.do|admin|manager|