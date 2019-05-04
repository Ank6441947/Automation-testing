package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appLib.OrderPage;
import appLib.dashboardPage;
import appLib.logInPage;
import baseLib.testBase;

public class orderPageTest extends testBase {
	
	public logInPage login;
	public dashboardPage dashboard;
	public OrderPage orderPage;
	
	public orderPageTest(){
	super();
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		login= new logInPage();
		dashboard= new dashboardPage();
		orderPage= new OrderPage();
		login.logIn(prop.getProperty("userID"), prop.getProperty("password"), driver);
		dashboard.clickOnOrderLink(driver);
				
	}
	
  @Test(priority=3)
  public void validateOrderPageTitleTest(){
	  String title=orderPage.validateOrderPageTitle(driver);
	  Assert.assertEquals(title,"My Account – Automation Practice Site");
  }
  
  @Test(priority=2)
  public void goshopbuttonPresentTest(){
	  Boolean flag=orderPage.goshopbuttonPresent(driver);
	  Assert.assertTrue(flag);
  }
  
  @Test(priority=1)
  public void ShopTest() throws InterruptedException{
	  orderPage.clickonGOShopLink(driver);
	  Thread.sleep(1000);
	  orderPage.ShopBook(driver, prop.getProperty("BookName"));
	 
  }
  
  
  @AfterMethod
  public void teardown(){
	  driver.quit();
  }

}
