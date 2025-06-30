Feature: Customers

Background: Below are common steps for every scenario for Customers
	Given User Launch Chrome browser 
	When User opens URL "https://demo.guru99.com/V1/index.php" 
	And User enters Email as "mngr626148" and Password as "AgYhyve" 
	And Click on Login 
	Then Page Title should be "GTPL Bank Home Page" or "GTPL Bank Manager HomePage"

@Sanity
Scenario: Add a new customer
  When User click on New Customer Menu Item
  Then User can view Add new customer page
  When User enter customer info
  And click on submit button
  Then User can view error message "This page isn’t working"
  And close browser

@Regression  
Scenario: Check Already Registered Customer
	When User click on Selenium dropdown
	And User selects Login option from the Selenium dropdown
	Then Page Title should be "Login Page"
	When User enter his/her correct login credentials
	And click on Sign in button
	Then User can view success message "Successfully Logged in..."
	And close browser
	

  
