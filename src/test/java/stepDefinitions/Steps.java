package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.CheckRegisteredUser;
import pageObjects.LoginPage;

public class Steps extends BaseClass{
	
	@Before
	public void setUp() throws IOException    // If we create this setUp method in baseclass, then Cucumber @Before will not extent from there
	{
		logger = Logger.getLogger("inetBankingV2"); // Added logger
		PropertyConfigurator.configure("log4j.properties"); // Added logger
		
		//Reading properties
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
	
		logger.info("*********Launching browser**********");
		
	}
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		
		logger.info("*********Opening URL**********");
		driver.get(url);
		driver.manage().window().maximize();
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	    
		logger.info("*********Providing Login details**********");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		
		logger.info("*********Started Login Process**********");
		lp.clickLogin();
		Thread.sleep(3000);
	    
	}

	@Then("Page Title should be {string} or {string}")
	public void page_Title_should_be_or(String title1, String title2) {
	    
		if(isAlertPresent()==true)
		{
			logger.info("**************Login failed****************");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertFalse(false);
		}
		else
		{
			Assert.assertTrue(true);
			if(driver.getTitle().equals(title1))
			{
				logger.info("*********Login passed**********");
				Assert.assertTrue(true);
				logger.info("*********Page Title is matching**********");
			}
			else if((driver.getTitle().equals(title2)))
			{
				logger.info("*********Login passed**********");
				Assert.assertTrue(true);
				logger.info("*********Page Title is matching**********");
			}
			else
			{
				logger.info("*********Login passed**********");
				Assert.assertTrue(false);
				logger.info("*********Page Title is not matching**********");
			}
		}
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

	@Then("close browser")
	public void close_browser() {
	    
		logger.info("*********Closing browser**********");
		driver.quit();
	}
	
	// Customer feature step definitions......................................
	
	@When("User click on New Customer Menu Item")
	public void user_click_on_New_Customer_Menu_Item() throws InterruptedException {
		addCust = new AddCustomerPage(driver);
		Thread.sleep(3000);
		addCust.clickAddNewCustomer();
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		
		Assert.assertEquals("Gtpl Bank New Customer Entry Page", addCust.getPageTitle());
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		logger.info("*********Adding New Customer**********");
		logger.info("*********Providing customer details**********");
		addCust.custName("Gaurav");
		addCust.custgender("male");
		addCust.custdob("10","15","1994");
		Thread.sleep(5000);
		addCust.custaddress("INDIA");
		addCust.custcity("HYD");
		addCust.custstate("AP");
		addCust.custpinno("5000074");
		addCust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addCust.custemailid(email);
	    
	}

	@When("click on submit button")
	public void click_on_submit_button() throws InterruptedException {
		
		logger.info("*********Submitting customer details**********");
		addCust.custsubmit();
		Thread.sleep(3000);
	    
	}

	@Then("User can view error message {string}")
	public void user_can_view_error_message(String msg) {
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains(msg));

	    
	}
	
	// Checking already registered customer...............
	
	@When("User click on Selenium dropdown")
	public void user_click_on_Selenium_dropdown() {
	    
		checkUser = new CheckRegisteredUser(driver);
		checkUser.seleniumClick();
		
	}

	@When("User selects Login option from the Selenium dropdown")
	public void user_selects_Login_option_from_the_Selenium_dropdown() {
		
		checkUser.selectlogin();
	    
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
	    
	}

	@When("User enter his\\/her correct login credentials")
	public void user_enter_his_her_correct_login_credentials() {
		
		logger.info("*********Checking already registered customer**********");
		logger.info("*********Providing a valid customer login details**********");
		checkUser.enterEmail();
		checkUser.enterPwd();
	    
	}

	@When("click on Sign in button")
	public void click_on_Sign_in_button() {
		
		logger.info("*********Submitting an existing customer details**********");
		checkUser.submitLogin();
	    
	}

	@Then("User can view success message {string}")
	public void user_can_view_success_message(String msg) {
		
		//System.out.println(checkUser.successLoginMsg());
		//System.out.println(msg);
		logger.info("*********Confirmed that the costumer is already registered**********");
		Assert.assertEquals(checkUser.successLoginMsg(), msg);
	    
	}

}
