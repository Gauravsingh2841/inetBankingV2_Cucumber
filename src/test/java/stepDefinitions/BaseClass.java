package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.CheckRegisteredUser;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public CheckRegisteredUser checkUser;
	public static Logger logger;
	public Properties configProp;
	
	public static String randomestring()
	{
		// Created for generating random string for Unique email
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}

}
