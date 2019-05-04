package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appLib.dashboardPage;
import appLib.downloadPage;
import appLib.logInPage;
import baseLib.testBase;

public class downloadPageTest extends testBase {
		
		public logInPage login;
		public dashboardPage dashboard;
		public downloadPage downloadPage;
		
		public downloadPageTest(){
		super();
		}
		
		@BeforeMethod
		public void setup(){
			initialisation();
			login= new logInPage();
			dashboard= new dashboardPage();
			downloadPage= new downloadPage();
			login.logIn(prop.getProperty("userID"), prop.getProperty("password"), driver);
			dashboard.clickOnDownloadPageLink(driver);
					
		}
		
	  @Test(priority=1)
	  public void validateDownloadPageTitleTest(){
		  String title=downloadPage.validateDownloadPageTitle(driver);
		  Assert.assertEquals(title,"My Account – Automation Practice Site");
	  }
	  
	  @Test(priority=2)
	  public void goshopbuttonPresentTest(){
		  Boolean flag=downloadPage.goshopbuttonPresent(driver);
		  Assert.assertTrue(flag);
	  }
	  
	  
	  @AfterMethod
	  public void teardown(){
		  driver.quit();
	  }

}
