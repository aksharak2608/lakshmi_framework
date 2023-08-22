package factroies;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.helper;

public class BaseClass {
	public static ExtentHtmlReporter html;
	public static ExtentReports report;
	public static ExtentTest test1;
	public static WebDriver driver;
	
	@BeforeSuite
	public void reports()
	{
		 html= new  ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\SeleniumReport"+helper.datformate()+".html");
			report= new ExtentReports();
		report.attachReporter(html);	
		System.out.println("report initiated");
	}
	
	@AfterMethod
	public void ResultReport(ITestResult result) throws IOException
	{
		System.out.println("Method Executed");
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test1.log(Status.PASS, "Test passed",MediaEntityBuilder.createScreenCaptureFromPath(helper.screenshottake(driver)).build());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test1.log(Status.FAIL, "Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(helper.screenshottake(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test1.log(Status.SKIP, "Test Skiped");
		}
	
	}
@BeforeClass
public void StartSession()
{
	System.out.println("Browser instiated");

	String url=DataProvider.readconfigdata("Url");

	String browser=DataProvider.readconfigdata("Browser");

	driver=BrowserFactory.launchbrowser(url, browser);
}
@AfterClass
public void EndSession()
{
	System.out.println("Browser Closed");
	BrowserFactory.closeBrowser(driver);
	
}

@AfterSuite
public void flush_reports()
{
	System.out.println("report closed");
	report.flush();
}

}
