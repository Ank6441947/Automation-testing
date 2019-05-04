package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import appLib.accountDetailsPage;
import appLib.dashboardPage;
import appLib.logInPage;
import baseLib.testBase;
import utillities.MyDataProvider;

public class accountDetailsPagetest  extends testBase {
	
	public logInPage login;
	public dashboardPage dashboard;
	public accountDetailsPage accountDetails;
	String excelPath="D:\\selenium\\workspace\\BlaBlaCar\\src\\test\\resources\\testdata\\accountdetails_changename.xlsx";
	String excelPath2="D:\\selenium\\workspace\\BlaBlaCar\\src\\test\\resources\\testdata\\accountdetails_changepassword.xlsx";
	
	public accountDetailsPagetest(){
	super();
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		login= new logInPage();
		accountDetails= new accountDetailsPage();
		dashboard=login.logIn(prop.getProperty("userID"), prop.getProperty("password"), driver);
		dashboard.clickOnAccountDetailsLink(driver);		
	}
	
  @Test(dataProvider="namechange",priority=1)
  public void addnameTest(String firstname, String lastname){
	  accountDetails.changeName(firstname, lastname, driver);  
  }
  
  @Test(dataProvider="passwordchange", priority=10)
  public void passwordChangeTest(String currentpass, String newpass){
	  accountDetails.changePassword(prop.getProperty("firstname"),prop.getProperty("lastname"), currentpass, newpass, driver);
  }
  
  @DataProvider(name="namechange")
 	public Object[][] getDatanamechange() throws  IOException, InterruptedException{
 	Object data[][]=MyDataProvider.getData(excelPath);
 	return data;
 	}
  
  @DataProvider(name="passwordchange")
 	public Object[][] getDatapasswordchange() throws  IOException, InterruptedException{
 	Object data[][]=MyDataProvider.getData(excelPath2);
 	return data;
 	}
   
  @AfterMethod
  public void teardown(){
	  driver.quit();
  }
  
  
}

