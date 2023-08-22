package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.helper;

public class Login {
	
By username=By.xpath("//input[@name='username']");
By password=By.xpath("//input[@name='password']");
By submit=By.xpath("//button");
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebDriver enterusername(String uname)
	{
		
		helper.waitforElementandenter(driver, username, uname);
		return driver;
		
	}
	public WebDriver enterpassword(String passcode)
	{
		
		helper.waitforElementandenter(driver, password, passcode);
		return driver;
		
	}
	public WebDriver submit()
	{
		
		helper.waitforElementandClick(driver, submit);
		return driver;
		
	}
	
	public void checkurl_login(String acturl )
	{
		
		Assert.assertEquals(acturl,driver.getCurrentUrl());
	}
	
}
