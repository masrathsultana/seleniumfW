package test.automation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import test.automation.base.baseClass;

public class serviceRequestTest extends baseClass {
loginPage loginpage;
serviceRequestPage servicerequestpage;
	
	public serviceRequestTest() throws IOException {
		super(); 
			}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException{
		initilize();
		loginpage = new loginPage(); 
		loginpage.login("demouser","Abc@12345");
		servicerequestpage = new serviceRequestPage();
	}
	@Test
	public void titleTest()
	{
		String tit = servicerequestpage.verifyTitle();
        Assert.assertEquals(tit, "MapVision Enterprise / Leading Edge Control Panel");
	}	
	@Test
	public void clickSRTest() throws InterruptedException
	{
		servicerequestpage.searchSRID();
	}
	@Test
	public void AdvSearch()
	{
		servicerequestpage.AdvSearch();
	}
	
	@AfterMethod
	public void tearDown(){
				driver.quit();
}
}
