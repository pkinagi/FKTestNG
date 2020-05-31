import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FlipKartTest
{
	public WebDriver driver;
	public System.setProperty("webdriver.chrome.driver", 
			 "E:\\WorkSapce\\Selenium Jar files\\chromedriver.exe");
	public String MainURL = "https://www.flipkart.com";
	public ExpectedTitle = null;
	public ActualTitle = null;
  @Test
  public void f() 
  {
	  System.out.println("Click on Cart button");
	  driver.findElement(By.partialLinkText("Cart")).click();
	  String ExceptedTitle = "Shopping Cart | Flipkart";
	  String ActualTitle = driver.getTitle();
	  Assert.assertEquals(ActualTitle, ExceptedTitle);
	  
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("Page Title");
	  String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	  String ActualTitle = driver.getTitle();
	  Assert.assertEquals(ActualTitle,ExpectedTitle);
  }

  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("Click on Flipkart and To Check the Page Title");
	  driver.findElement(By.linkText("Flipkart")).click();
  }

  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("Launch the Chrome Browser");
	  driver.get(MainURL);
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("Test Completed Bye");
	  driver.close();
  }

}
