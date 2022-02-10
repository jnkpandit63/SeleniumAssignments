package Assignment1;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DropDown {
	WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
			
			driver = new ChromeDriver();
					
			driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait 5sec
			//Thread.sleep(2000);
//			
			
	  }
	
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(2000);
	  WebElement slc = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
	  Select dp = new Select(slc);
	  dp.selectByVisibleText("India");	
	 }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


}
