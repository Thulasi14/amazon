package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilityPackage.Locators;
import utilityPackage.PropertyFileRead;


public class Page2 extends Page1 {
	
	WebDriver driver;
	public Page2(WebDriver driver) {
		
		this.driver=driver;	
	}
	
	Locators l1=new Locators(driver);
	
	@Test
	public void search() {
		
		String search = PropertyFileRead.read("searchtext");
		WebElement searchbox = l1.locator(search);
		searchbox.sendKeys("Sanitizer");
		searchbox.sendKeys(Keys.ENTER);	
	}
	
	
}
