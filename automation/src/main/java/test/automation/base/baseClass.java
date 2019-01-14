package test.automation.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class baseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;
    public ExtentReports report;
    public ExtentTest Logger;

    public baseClass() throws IOException{
		try{
		prop = new Properties();
		file=  new FileInputStream("D://workspace//automation//config.properties");
		prop.load(file);
		}
	catch(FileNotFoundException e){
		System.out.println(e);
			}
	}
	public static void initilize(){
		String browser= prop.getProperty("Browser");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("IE")){
		
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
				
			String url1 = prop.getProperty("url");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url1);
		}
	}



