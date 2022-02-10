package Assignment1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserSizeSetting {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://jqueryui.com/droppable/");
  }
  
  @Test
  public void BrowserSize() {
	  Dimension before = driver.manage().window().getSize();  
		System.out.println("Browser window size before setting: "+before);
		 driver.manage().window().setSize(new Dimension(1200,900));   
		Dimension after = driver.manage().window().getSize();
		System.out.println("Browser window size after setting: "+after);
		
		
		if(before != after) {
		
			System.out.println("Setting Browser window size successful");  
		
	}
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }

}
