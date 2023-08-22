package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Login;
public class loginTest {
	public static WebDriver driver;
	
	public static WebDriver launchbrowser()
	{

		System.setProperty("webdriver.chrome.driver",
				"D:\\training\\chromedriver-win64_116\\chromedriver-win64\\chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	   options.addArguments("--remote-allow-origins=*");
	    //  options.addArguments("--disable-dev-shm-usage");
	driver= new ChromeDriver(options);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
driver.manage().window().maximize();
	return driver;
	
	
	}
	
	@Test
	public void first_loginTest() throws InterruptedException
	{
		WebDriver driver=loginTest.launchbrowser();
				
		Thread.sleep(3000);	
					Login log= new Login(driver);
		//driver=log.Login_application(driver, "Admin", "admin123");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index]");
	}

}
