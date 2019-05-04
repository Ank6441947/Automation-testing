package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import appLib.AddressPage;
import appLib.dashboardPage;
import appLib.logInPage;
import baseLib.testBase;
import utillities.MyDataProvider;

public class addressPageTest extends testBase {
	
	public logInPage login;
	public dashboardPage dashboard;
	public AddressPage addressPage;
	String excelPath="D:\\selenium\\workspace\\BlaBlaCar\\src\\test\\resources\\testdata\\addressPage_BillingAddress.xlsx";
	
	public addressPageTest(){
	super();
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		login= new logInPage();
		addressPage= new AddressPage();
		dashboard=login.logIn(prop.getProperty("userID"), prop.getProperty("password"), driver);
		dashboard.clickOnBillingLink(driver);
				
	}
	
  @Test(dataProvider="updateAddress",priority=1)
  public void UpdateBillingAddressTest(String firstname, String lastname, String phone, String country, String address,String town, String state,String postcode){
	  addressPage.clickOnBillingAddressLink(driver);
	  addressPage.UpdateBillingAddress(firstname, lastname, phone, country, address, town, state, postcode, driver);
	  }
  
  @Test(priority=2)
  public void BillingAddressTextvisibleTest(){
	  Boolean flag=addressPage.BillingAddressTextvisible(driver);
	  Assert.assertTrue(flag);
  }
  
  @Test(priority=3)
  public void ShippingAddressTextvisibleTest(){
	  Boolean flag=addressPage.ShippingAddressTextVisible(driver);
	  Assert.assertTrue(flag);
  }
  
   @DataProvider(name="updateAddress")
 	public Object[][] getDataUpdateAddress() throws  IOException, InterruptedException{
 	Object data[][]=MyDataProvider.getData(excelPath);
 	return data;
 	}

  @AfterMethod
  public void teardown(){
	  driver.quit();
  }
}
