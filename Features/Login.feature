Feature: Login 

@Sanity
Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "https://demo.guru99.com/V1/index.php" 
	And User enters Email as "mngr626148" and Password as "AgYhyve" 
	And Click on Login 
	Then Page Title should be "GTPL Bank Home Page" or "GTPL Bank Manager HomePage"
	And close browser 
	
@Regression	
Scenario Outline: Login Data Driven
	Given User Launch Chrome browser 
	When User opens URL "https://demo.guru99.com/V1/index.php" 
	And User enters Email as "<email>" and Password as "<password>" 
	And Click on Login 
	Then Page Title should be "GTPL Bank Home Page" or "GTPL Bank Manager HomePage"
	And close browser
	
	Examples:
			| email | password |
			| mngr626148 | AgYhyve |
			| mngr626147 | Agssyve |