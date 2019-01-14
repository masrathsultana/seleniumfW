package test.automation;

import java.io.File;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.automation.base.Utilitycla;
import test.automation.base.baseClass;
import test.automation.base.excelReadData;
public class LoginTest extends baseClass
{
	loginPage loginpage;
	
	public LoginTest() throws IOException {
		super(); 
			}
	
	@BeforeMethod
	public void setup() throws IOException{
		initilize();
		loginpage = new loginPage();
	}
	
	@Test(priority = 0, enabled = false)
	public void titleTest(){
	String pageTitle = loginpage.pagetitle();
	Assert.assertEquals(pageTitle, "MapVision Enterprise / Leading Edge Control Panel");
	}
	
	@Test(priority = 1, enabled = false)
	public void logoTest(){
	boolean flag1 = loginpage.verifyLogo();
		Assert.assertTrue(flag1);
	}
	@DataProvider
	public Object[][] getDataExcel() throws Exception{
	Object data[][] = excelReadData.getTestData("test");
	return data;
	
	}
	@Test(dataProvider ="getDataExcel", priority =2)
	public void loginTest(String UserName, String Password) throws Exception {
		loginpage.login(UserName,Password);
		} 
	@AfterMethod
	public void tearDown(){
				driver.quit();
	}
	
	 }