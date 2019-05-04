package appLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseLib.testBase;

public class accountDetailsPage extends testBase {
	
	String FirstNameLoc="//input[@id='account_first_name']";
	String LastNameLoc="//input[@id='account_last_name']";
	String CurrentPasswordLoc="//input[@name='password_current']";
	String NewPasswordLoc="//input[@name='password_1']";
	String ConfirmNewPasswordLoc="//input[@name='password_2']";
	String SaveLoc="//input[@value='Save changes']";
	
	public void changeName(String firstname, String lastname, WebDriver driver){
		driver.findElement(By.xpath(FirstNameLoc)).clear();
		driver.findElement(By.xpath(FirstNameLoc)).sendKeys(firstname);
		driver.findElement(By.xpath(LastNameLoc)).clear();
		driver.findElement(By.xpath(LastNameLoc)).sendKeys(lastname);
		driver.findElement(By.xpath(SaveLoc)).click();
	}
	
	public void changePassword(String firstname, String lastname,String currentpass, String newpass, WebDriver driver){
		String first=driver.findElement(By.xpath(FirstNameLoc)).getText();
		String last=driver.findElement(By.xpath(LastNameLoc)).getText();
		if(first.isEmpty()|| last.isEmpty()){
			System.out.println("Please enter the first and the second name before changing the password");
			driver.findElement(By.xpath(FirstNameLoc)).clear();
			driver.findElement(By.xpath(FirstNameLoc)).sendKeys(firstname);
			driver.findElement(By.xpath(LastNameLoc)).clear();
			driver.findElement(By.xpath(LastNameLoc)).sendKeys(lastname);
		}
		driver.findElement(By.xpath(CurrentPasswordLoc)).sendKeys(currentpass);
		driver.findElement(By.xpath(NewPasswordLoc)).sendKeys(newpass);
		driver.findElement(By.xpath(ConfirmNewPasswordLoc)).sendKeys(newpass);
		driver.findElement(By.xpath(SaveLoc)).click();
		
	}

}
