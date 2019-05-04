package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appLib.dashboardPage;
import appLib.logInPage;
import baseLib.testBase;

public class logInPageTest extends testBase {
	
	public logInPage login;
	public dashboardPage dashboard;
	
	public  logInPageTest(){
	super();
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		login= new logInPage();
				
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=login.validateLoginPageTitle(driver);
		Assert.assertEquals(title,"My Account – Automation Practice Site");
		
	}
	
	@Test(priority=2)
	public void logoImagetest(){
		boolean flag=login.validateATsiteimage(driver);
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void logintotheAccount(){
		dashboard=login.logIn(prop.getProperty("userID"), prop.getProperty("password"), driver);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
