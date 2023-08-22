package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {

	
	public static WebDriver LaunchBrowser(String url, WebDriver driver)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\suhar\\OneDrive\\Desktop\\batch sep2022\\chromedriver\\chromedriver.exe");
		
		driver= new ChromeDriver(); 
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	public static String screenshottake(WebDriver driver)
	{
		String path = null;
		try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
     
	 path=System.getProperty("user.dir")+"\\screenshots\\"+helper.datformate()+".png";
		File dest =new File(System.getProperty("user.dir")+"\\screenshots\\"+helper.datformate()+".png");
		
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	public static WebDriver waitforElementandenter(WebDriver driver, By ele, String input)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60000));
	
	wait.until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(input);;
	return driver;
		
	}
	
	

	public static WebDriver waitforElementandClick(WebDriver driver, By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60000));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(ele)).click();
	return driver;
		
	}
	public static String datformate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();        
		  String d= dtf.format(now);
		  return d;
	}
	
}
