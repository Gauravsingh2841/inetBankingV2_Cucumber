package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class CheckRegisteredUser {
	
	public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public CheckRegisteredUser(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.XPATH, using ="//div/ul/li[1]/a[@class='dropdown-toggle']")
	@CacheLookup
	WebElement seleniumDropDown;
	
	@FindBy(how = How.XPATH, using ="//li/ul/li[11]")
	@CacheLookup
	WebElement loginOption;
	
	@FindBy(how = How.ID, using ="email")
	@CacheLookup
	WebElement txtEmailLogin;
	
	@FindBy(how = How.ID, using ="passwd")
	@CacheLookup
	WebElement txtPwdLogin;
	
	@FindBy(how = How.ID, using ="SubmitLogin")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using ="//div/h3")
	@CacheLookup
	WebElement successLoginIn;
	
	public void seleniumClick()
	{
		waitHelper.WaitForElement(seleniumDropDown, 10);
		seleniumDropDown.click();
	}
	
	public void selectlogin()
	{
		waitHelper.WaitForElement(loginOption, 10);
		loginOption.click();
	}
	
	public void enterEmail()
	{
		txtEmailLogin.sendKeys("mngr626148");
	}
	
	public void enterPwd()
	{
		txtPwdLogin.sendKeys("AgYhyve");
	}
	
	public void submitLogin()
	{
		submitBtn.click();
	}
	
	public String successLoginMsg()
	{
		waitHelper.WaitForElement(successLoginIn, 5);
		return successLoginIn.getText();
	}

}
