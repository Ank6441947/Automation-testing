package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appLib.AddressPage;
import appLib.OrderPage;
import appLib.accountDetailsPage;
import appLib.dashboardPage;
import appLib.logInPage;
import baseLib.testBase;

public class dashBoardPageTest extends testBase {
	
	public logInPage login;
	public dashboardPage dashboard;
	public OrderPage order;
	public AddressPage address;
	public accountDetailsPage accountDetails;
	
	public dashBoardPageTest(){
	super();
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		login= new logInPage();
		dashboard=login.logIn(prop.getProperty("userID"), prop.getProperty("password"), driver);
				
	}
	
	@Test (priority= 1)
	public void dashboardTitleTest(){
		String title=dashboard.validateDashBoardTitle(driver);
		Assert.assertEquals(title, "My Account – Automation Practice Site");
	}
	
	@Test(priority= 2)
	public void orderLinkTest(){
		order=dashboard.clickOnOrderLink(driver);
	}
	
	
	@Test(priority=3)
	public void BillingLinkTest(){
		address=dashboard.clickOnBillingLink(driver);
	}	
	
	@Test(priority=4)
	public void accountDetailsLinkTest(){
		accountDetails=dashboard.clickOnAccountDetailsLink(driver);
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
