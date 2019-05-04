package appLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseLib.testBase;

public class AddressPage extends testBase {
	
	String BillingAddressEditBtn="//div[@class='u-column1 col-1 woocommerce-Address']//a[@class='edit'][contains(text(),'Edit')] ";
	String ShippingaddressEditBtn="//div[@class='u-column2 col-2 woocommerce-Address']//a[@class='edit'][contains(text(),'Edit')] ";
	String BillingAddressTextLoc="//h3[contains(text(),'Billing Address')]";
	String ShippingAddressTextLoc="//h3[contains(text(),'Shipping Address')]";
	
	public void UpdateBillingAddress(String firstname,String lastname,String phone,String country, String address,String town, String state,String postcode,WebDriver driver){
		driver.findElement(By.xpath("//input[@name='billing_first_name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='billing_last_name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='billing_phone']")).sendKeys(phone);
		List<WebElement> count=driver.findElements(By.xpath("//ul[@class='select2-results']//li//div//span"));
		for(int i=0;i<count.size();i++)
		 {
			 if(count.get(i).getText().equalsIgnoreCase(country))
			 {
				 count.get(i).click();
				 break;
			 }
		 }
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys(town);
		
		for(int i=0;i<count.size();i++)
		 {
			 if(count.get(i).getText().equalsIgnoreCase(state))
			 {
				 count.get(i).click();
				 break;
			 }
		 }
		driver.findElement(By.xpath("//input[contains(@name,'billing_postcode')]")).sendKeys(postcode);
		driver.findElement(By.xpath("//input[contains(@value,'Save Address')]")).click();
	}
	
	public void UpdateShippingAddress(WebDriver driver){
		
	}
	
	public boolean BillingAddressTextvisible(WebDriver driver){
		return driver.findElement(By.xpath(BillingAddressTextLoc)).isDisplayed();
	}
	
	public boolean ShippingAddressTextVisible(WebDriver driver){
		return driver.findElement(By.xpath(ShippingAddressTextLoc)).isDisplayed();
	}
	
	public void clickOnBillingAddressLink(WebDriver driver){
		driver.findElement(By.xpath(BillingAddressEditBtn)).click();
	}
	
  public void clickOnShippingAddressLink(WebDriver driver ){
		driver.findElement(By.xpath(ShippingaddressEditBtn)).click();
	}

}
