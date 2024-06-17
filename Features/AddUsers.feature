Feature: User Module test scripts
 
 @sanity
   Scenario: Verify create and delete user functionality1(Using Data table)
    Given User navigates the URL "http://localhost/login.do"
    Then User perform login with valid credentials userName as "admin" and Password as "manager"
    And User verify login is successful "Enter Time-Track"
    Then User creates new user in the actiTime
      | User_FirstName| User_LastName | User_Email    | User_UserName | User_Password | User_RetypePassword  |
      | Nikhil        | Chakravarthy  | Nikhil@sg.com | Nikhiluser1   | Mercury1      | Mercury1             |
      | punith        | awaji         | punith@sg.com | punithuser2   | Mercury1      | Mercury1             |
    Then verify user create is sucessfull  
    Then verify user is deleted successful
    And User logouts from the application
    
 @regression
  Scenario Outline: AddUsers Datt driven
    Given User navigates the URL "http://localhost/login.do"
    Then User perform login with valid credentials userName as "admin" and Password as "manager"
    And User verify login is successful "Enter Time-Track"
    Then User creates new user in the actiTime "<User_FirstName>" a "<User_LastName>" b "<User_Email>" c "<User_UserName>" d "<User_Password>" e "<User_RetypePassword>"
    Then verify user create is sucessfull  
    Then verify user is deleted successful
    And User logouts from the application
    
  Examples: 
  | User_FirstName| User_LastName | User_Email    | User_UserName | User_Password | User_RetypePassword  |
  | Nikhil        | Chakravarthy  | Nikhil@sg.com | Nikhiluser1   | Mercury1      | Mercury1             |
  | punith        | awaji         | punith@sg.com | punithuser2   | Mercury1      | Mercury1             |
  
  