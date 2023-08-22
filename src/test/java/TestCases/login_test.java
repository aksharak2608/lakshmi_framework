package TestCases;

import org.testng.annotations.Test;

import Pages.Login;
import factroies.BaseClass;
import factroies.DataProvider;

public class login_test extends BaseClass {
	@Test
	public void test()
	{
		
		test1=report.createTest("login","logincrm");
		Login login_obj=new Login(driver);
		System.out.println(DataProvider.readexceldata("test1", 0, 0));
		login_obj.enterusername(DataProvider.readexceldata("test1", 0, 0));
		login_obj.enterpassword(DataProvider.readexceldata("test1", 0, 1));
		login_obj.submit();
		String acturl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		login_obj.checkurl_login(acturl);
	}
	

}
