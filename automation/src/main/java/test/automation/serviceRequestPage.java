package test.automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import test.automation.base.baseClass;

public class serviceRequestPage extends baseClass{
	
	@FindBy(xpath = "//img[@src = 'images/menu-ico.png']")
	WebElement Navigation;
	
	@FindBy(xpath = "//span[@title='Service Requests']//following-sibling::span[2]")
	WebElement srdropdown;
	
	@FindBy(xpath = "//a[@title='Service Requests']//child::span")
	WebElement ServiceRequest;
	
	@FindBy(xpath = "//input[@id = 'Keyword']")
	WebElement SearchSRIDTextbox;
	
	@FindBy(xpath = "//input[@id = 'Keyword']")
	WebElement SearchButton;
	
	@FindBy(xpath = "//a[@id = 'anchor_adv_search']")
	WebElement AdvSearchDrpdwn;
	
	@FindBy(xpath = "//select[@id = 'iSRTId']")
	WebElement SRTypeDropdown;
	
	@FindBy(xpath = "//input[@id = 'run_query']")
	WebElement AdvSearch;
	
		public serviceRequestPage() throws IOException {
			PageFactory.initElements(driver, this);
			}
		public String verifyTitle(){
			String title =driver.getTitle();
			return title;
		}
		
		public void searchSRID() throws InterruptedException{
		WebElement element = driver.findElement(By.xpath("//img[@src = 'images/menu-ico.png']"));
	    Actions action = new Actions(driver);
	    action.moveToElement(element).build().perform();
		srdropdown.click();
		ServiceRequest.click();
		SearchSRIDTextbox.sendKeys("1137");
		SearchButton.click();
		Thread.sleep(30000);
		}
		
		public void AdvSearch(){
			AdvSearchDrpdwn.click();
			Select oSelect = new Select(SRTypeDropdown);
			oSelect.selectByVisibleText("Report Mosquito Problem");
			AdvSearch.click();
		}
		
	

}
