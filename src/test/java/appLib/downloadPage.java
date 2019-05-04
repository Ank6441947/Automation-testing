package appLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseLib.testBase;

public class downloadPage extends testBase {
	
	
String goshopLoc="//a[@class='woocommerce-Button button']";
	
	public String validateDownloadPageTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	public boolean goshopbuttonPresent(WebDriver driver){
		return driver.findElement(By.xpath(goshopLoc)).isDisplayed();
		
	}
	
	public void clickonGOShopLink(WebDriver driver){
		driver.findElement(By.xpath(goshopLoc)).click();
	}

}
