Feature: Test automation for login and logout functionality

 
  Scenario: Verify user perform login and logout functionality in actiTime
    Given User navigates the URL "http://localhost/login.do"
    Then User perform login with valid credentials userName as "admin" and Password as "manager"
    And User verify login is successful "Enter Time-Track"
    Then User logouts from the application
    
  Scenario Outline: Login Data Driven
    Given User navigates the URL "http://localhost/login.do"
    Then User perform login with valid credentials userName as "<userName>" and Password as "<password>"
    And User verify login is successful "Enter Time-Track"
    Then User logouts from the application 
    
    Examples: 
    |userName|password|
    |admin|manager|
    |admin|manager12345|  