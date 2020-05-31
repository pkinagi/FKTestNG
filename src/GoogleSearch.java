import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch 
{
	public WebDriver driver;
  @Test
  public void f() throws InterruptedException
  {
	 System.setProperty("webdriver.chrome.driver", 
			 "E:\\WorkSapce\\Selenium Jar files\\chromedriver.exe");
	    driver = new ChromeDriver();
	 String MainURL = "https://www.google.com";
	 	driver.get(MainURL);
		WebElement Search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		Search.sendKeys("Sele");
		driver.manage().window().maximize(); // For Window Maximum
		Thread.sleep(20000);
		int i;
		for (i = 0; i < 3; i++)
		{
			Search.sendKeys(Keys.DOWN);
		}
		Search.sendKeys(Keys.ENTER);
		System.out.println(driver.getTitle());
		String ExpectedTitle = "Selenium Interview Questions - Google Search";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	 
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("Starting the Chrome Browser");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
