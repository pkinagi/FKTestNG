import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FlipKart
{
	public WebDriver driver;
	public String MainURL = "https://www.flipkart.com";
	//public ExpectedTitle = null;
	//public ActualTitle = null;
  @Test
  public void f() 
  {
	  System.out.println("Click on Cart button");
	  System.setProperty("webdriver.chrome.driver",
				 "E:\\WorkSapce\\Selenium Jar files\\chromedriver.exe");
	  driver.findElement(By.partialLinkText("Cart")).click();
	  String ExceptedTitle = "Shopping Cart | Flipkart";
	  String ActualTitle = driver.getTitle();
	  Assert.assertEquals(ActualTitle, ExceptedTitle);
	  
  }
  @BeforeMethod
  public void BeforeMethod()
  {
	  System.out.println("Page Title");
	  String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	  String ActualTitle = driver.getTitle();
	  Assert.assertEquals(ActualTitle,ExpectedTitle);
  }

  @AfterMethod
  public void AfterMethod()
  {
	  System.out.println("Click on Flipkart and To Check the Page Title");
	  driver.findElement(By.linkText("Flipkart")).click();
  }

  @BeforeTest
  public void BeforeTest()
  {
	  System.out.println("Launch the Chrome Browser");
	  f();
	  driver.get(MainURL);
  }

  @AfterTest
  public void AfterTest()
  {
	  System.out.println("Test Completed Bye");
	  driver.close();
  }

}
