package Assignment1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ScrollPage {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://demo.guru99.com/test/guru99home/");
	  driver.manage().window().maximize();
  }

  @Test
  public void ScrollTest() throws InterruptedException {
	  JavascriptExecutor Scroll = (JavascriptExecutor)driver;
	  
		Scroll.executeScript("window.scrollTo(0,2000)");
	  
	  //Scroll.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
		
	  Thread.sleep(4000);
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
