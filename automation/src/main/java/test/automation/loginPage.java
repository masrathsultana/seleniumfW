package test.automation;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import test.automation.base.baseClass;

public class loginPage extends baseClass
{
	@FindBy(xpath = "//input[@id='vUsername']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='vPassword']")
	WebElement password;
	
	@FindBy(xpath = "//a[text()='Sign In ']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//img[@src='images/MapVision_logo_150x150.png']")
	WebElement logo;
	
/*	@FindBy(xpath = "//div[@id = 'msg']")
	WebElement errormsg;*/
	
	public loginPage()throws IOException{
		PageFactory.initElements(driver, this);
				}
	public String pagetitle(){
		String k = driver.getTitle();
		return k;
	}
	public boolean verifyLogo(){
		Boolean flag = logo.isDisplayed();
		return flag;
	}
	public void login(String Uname, String Upassword) throws IOException, InterruptedException{
		username.sendKeys(Uname);
		password.sendKeys(Upassword);
		loginbtn.click();		
	}
}
