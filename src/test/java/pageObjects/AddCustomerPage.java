package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Using different approach here, first capturing locators of all the required elements on the Add Customer page
	By btnAddCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
	By txtCustomerName = By.name("name");
	By rdGender = By.name("rad1");
	By txtdob = By.name("dob");
	By txtaddress = By.name("addr");
	By txtcity = By.name("city");
	By txtstate = By.name("state");
	By txtpinno = By.name("pinno");
	By txttelephoneno = By.name("telephoneno");
	By txtemailid = By.name("emailid");
	By btnSubmit = By.name("sub");
	
	// Actions Methods
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickAddNewCustomer() {
		ldriver.findElement(btnAddCustomer).click();
			
	}

	public void custName(String cname) {
		ldriver.findElement(txtCustomerName).sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		ldriver.findElement(rdGender).click();
	}

	public void custdob(String mm,String dd,String yy) {
		ldriver.findElement(txtdob).sendKeys(mm);
		ldriver.findElement(txtdob).sendKeys(dd);
		ldriver.findElement(txtdob).sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		ldriver.findElement(txtaddress).sendKeys(caddress);
	}

	public void custcity(String ccity) {
		ldriver.findElement(txtcity).sendKeys(ccity);
	}

	public void custstate(String cstate) {
		ldriver.findElement(txtstate).sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		ldriver.findElement(txtpinno).sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		ldriver.findElement(txttelephoneno).sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		ldriver.findElement(txtemailid).sendKeys(cemailid);
	}
	
	public void custsubmit() {
		ldriver.findElement(btnSubmit).click();
	}

}
