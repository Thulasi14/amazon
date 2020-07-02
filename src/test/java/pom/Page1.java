package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityPackage.Locators;
import utilityPackage.PropertyFileRead;

public class Page1{
	
	@DataProvider
	public Object[][] testdata() {
		
		Object[][] data= {{"vigneshviswa848@gmail.com","karaikudisaba@123"}};
		
		return data;	
	}
	
	static WebDriver driver;
	
	static Locators l;
	
	@Test(priority=0)
	public void urlLaunch() {
		
		String urlData = PropertyFileRead.read("url");
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.get(urlData);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void login() {
		
		l=new Locators(driver);
		WebElement loginbutton = l.locator("login");
		loginbutton.click();		
	}
	
	@Test(dataProvider="testdata",priority=2)
	public void cred(String uname, String pwd) {
		
		l=new Locators(driver);
		WebElement user = l.locator("username");
		user.sendKeys(uname);
		WebElement sub = l.locator("submit");
		sub.click();
		WebElement passwd = l.locator("password");
		passwd.sendKeys(pwd);
		WebElement lgn = l.locator("submitpwd");
		lgn.submit();
		
	}

	@Test(priority=3)
	public void searchkey() {
		
		l=new Locators(driver);
		String searchtxt = PropertyFileRead.read("searchtext");
		WebElement searchbox = l.locator(searchtxt);
		searchbox.sendKeys("sanitizer",Keys.ENTER);	
	}
	
	/*@Test(priority=4)
	public void checkItem() {
		
		String xpathValue = PropertyFileRead.read("select");
		WebElement link = l.locator(xpathValue);
		link.click();
		
	}
	
	@Test(priority=5)
	public void toCheckItem(){
		
		driver.switchTo().window(driver.getWindowHandle());
		String value = PropertyFileRead.read("addToCart");
		WebElement addtoCart = l.locator(value);
		addtoCart.click();
	}*/
}
