package baseLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBase {
	
	public Properties prop;
	public WebDriver driver;
	
	public testBase(){
		try{
			
			prop= new Properties();
			FileInputStream io= new FileInputStream("D:\\selenium\\workspace\\BlaBlaCar\\src\\test\\resources\\configuration\\config.properties");
			prop.load(io);
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialisation(){
		String browserName= prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\software\\chromedriver_win32_B45\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\software\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
