import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class FlipK
{
	public WebDriver driver;
	public String MainURL = "https://www.flipkart.com";
	String DriverPath = "E:\\WorkSapce\\Selenium Jar files\\chromedriver.exe";
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("Launch the Chrome Browser");
		System.setProperty("webdriver.chrome.driver", DriverPath);
		driver = new ChromeDriver();
		driver.get(MainURL);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		//driver.findElement(By.xpath("//div[@class=\"_3toH2I\"]")).click();
	}
	/*@BeforeMethod
  	public void VerifyBrowserTitle()
  	{
		System.out.println("Page Title");
		String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle,ExpectedTitle);
  	}*/
	@Test(priority = 0)
	public void cart() throws InterruptedException
	{
		System.out.println("Click on Cart button");
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		String ExceptedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExceptedTitle);
	}
	@Test(priority = 1)
	public void Flipkart()
	{
		System.out.println("Click on Flipkart and To Check the Page Title");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]")).click();
	}
	@Test(priority = 2)
	public void VerifyBrowserTitle()
  	{
		System.out.println("Page Title");
		String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle,ExpectedTitle);
  	}
	@Test(priority = 3)
	public void SearchProduct()
	{
		System.out.println("Search for a Product in Flipkart Site");
		WebElement Search = driver.findElement(By.name("q"));
		Search.sendKeys("Samsung Mobile");
		Search.sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//div[contains(text(), \"Search for products, brands and more\")]")).sendKeys("Washing Machine");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		System.out.println(driver.getPageSource());
		driver.navigate().back();
		driver.navigate().refresh();
	}
	/*@AfterMethod
	public void goBackHomePage()
	{
		driver.findElement(By.linkText("Flipkart")).click();
	}*/
	//@AfterTest
	/*public void terminateBrowser()
	{
		driver.close();
	}*/
  }
  
