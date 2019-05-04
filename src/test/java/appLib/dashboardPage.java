package appLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseLib.testBase;

public class dashboardPage extends testBase {
	
	String recentOrderlinkLoc="//a[contains(text(),'recent orders')]";
	String billinglinkLoc="//a[contains(text(),'shipping and billing addresses')] ";
	String accountDetailsLinkLoc ="//a[contains(text(),'edit your password and account details')] ";
	String downloadPageLinkLoc="//a[contains(text(),'Downloads')]";
	
	public String validateDashBoardTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	public OrderPage clickOnOrderLink(WebDriver driver){
		driver.findElement(By.xpath(recentOrderlinkLoc)).click();
		return new OrderPage();
	}
	
	public AddressPage clickOnBillingLink(WebDriver driver){
		driver.findElement(By.xpath(billinglinkLoc)).click();
		return new AddressPage();
	}
	
	public accountDetailsPage clickOnAccountDetailsLink(WebDriver driver){
		driver.findElement(By.xpath(accountDetailsLinkLoc)).click();
		return new accountDetailsPage();
	}	
	
	public downloadPage clickOnDownloadPageLink(WebDriver driver){
		driver.findElement(By.xpath(downloadPageLinkLoc)).click();
		return new downloadPage();
	}

}
