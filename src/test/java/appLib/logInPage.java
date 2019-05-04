package appLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseLib.testBase;

public class logInPage extends testBase {
	
	String UserNameLoc= "//input[@name='username']";
	String PasswordLoc="//input[@id='password']";
	String LoginLoc="//input[@value='Login']";
 
	public dashboardPage logIn(String name, String password, WebDriver driver ){
		
		driver.findElement(By.xpath(UserNameLoc)).sendKeys(name);
		driver.findElement(By.xpath(PasswordLoc)).sendKeys(password);
		driver.findElement(By.xpath(LoginLoc)).click();
		
		return new dashboardPage();
	}
	public boolean validateATsiteimage(WebDriver driver){
		 return driver.findElement(By.xpath("//img[@title='Automation Practice Site']")).isDisplayed();
	}
	
	public String validateLoginPageTitle(WebDriver driver){
		 return driver.getTitle();
		
	}

}
