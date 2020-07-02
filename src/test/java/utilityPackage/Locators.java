package utilityPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators extends PropertyFileRead {
	
	WebDriver d;
	public Locators(WebDriver driver) {
		this.d=driver;	
	}
	
	static WebElement element;
	
	public WebElement locator(String locatorValue) {
	  
	  String locatedElement=read(locatorValue);
	  String[] s=locatedElement.split("#"); 
	  String locator=s[0]; 
	  String value=s[1];
	  
	  if(locator.equalsIgnoreCase("id")) {
		  
		   element = d.findElement(By.id(value));
	  }
	  
	  else if(locator.equalsIgnoreCase("xpath")) {
		  
		  element = d.findElement(By.xpath(value));
	  }
	  
	  return element;  
  }
	

}
