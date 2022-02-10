package Assignment1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.AfterMethod;

public class EnterScriptWithoutSendkeys {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
	 driver.get("https://www.phptravels.net/login");
	 driver.manage().window().maximize();
  }

  @Test
  public void Script_Without_SendKeys() throws InterruptedException {
	  WebElement username = driver.findElement(By.name("email"));
	  WebElement pw = driver.findElement(By.name("password"));
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  
	  js.executeScript("arguments[0].value= 'user@phptravels.com'", username);
	  js.executeScript("arguments[0].value= 'demouser'", pw);
	  
	  Thread.sleep(2000);
//	  driver.findElement(By.name("email")).sendKeys("user@phptravels.com");
//	  driver.findElement(By.name("password")).sendKeys("demouser");
//	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button/span[1]")).click();
	
  }
  
  @AfterMethod
  public void afterMethod() {
	  String msg = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2")).getText();
	  System.out.println(msg);
	  driver.close();
  }

}
