package factroies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	public static WebDriver launchbrowser(String url, String browser)
	{
		System.out.println("Browser instiated"+browser);
		WebDriver driver = null;
		ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		  //check the chrome driver ds
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\selenium setup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
	driver.get(url);
driver.manage().window().maximize();
	
	}
	
	else if(browser.equalsIgnoreCase("firefox"))
	{

		System.setProperty("webdriver.chrome.driver",
				"D:\\training\\chromedriver-win64_116\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
driver.get(url);
driver.manage().window().maximize();
	
		
	}
		return driver;
}
public static void closeBrowser(WebDriver driver) {
driver.close();
	
}
}