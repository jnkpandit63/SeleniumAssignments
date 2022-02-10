package Assignment3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TakeScreenshot {
 WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://api.jquery.com/dblclick/");
	  driver.manage().window().maximize();
  }

  @Test
  public void f() throws IOException, InterruptedException {
	  TakesScreenshot SS = ((TakesScreenshot) driver);
	  File SSfile = SS.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(SSfile, new File("D:\\workspace\\SS.PNG"));
	  Thread.sleep(2000);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
