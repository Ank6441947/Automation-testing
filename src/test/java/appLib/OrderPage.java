package appLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseLib.testBase;

public class OrderPage extends testBase {
	
	String goshopLoc="//a[@class='woocommerce-Button button']";
	
	public String validateOrderPageTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	public boolean goshopbuttonPresent(WebDriver driver){
		return driver.findElement(By.xpath(goshopLoc)).isDisplayed();
		
	}
	
	public void clickonGOShopLink(WebDriver driver){
		driver.findElement(By.xpath(goshopLoc)).click();
	}
	
	public void ShopBook(WebDriver driver, String BookName) throws InterruptedException{
		
			List<WebElement> Booklist=driver.findElements(By.xpath("//ul[@class='products masonry-done']//li//a//h3"));
			for(int j=0;j<Booklist.size();j++){
				
				if(Booklist.get(j).getText().equalsIgnoreCase(BookName)){
					driver.findElement(By.xpath("//ul[@class='products masonry-done']//li//a//h3[contains(text(),'"+BookName+"')]//"
							+ "parent::a[@class='woocommerce-LoopProduct-link']//following-sibling::a[contains(text(),'Add to basket')]")).click();
					break;
				}	
		}
	}

}
