package Assignment1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrokenLink {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://the-internet.herokuapp.com/");
	  driver.manage().window().maximize();
  }

  @Test
  public void f() throws InterruptedException, IOException {
	 List <WebElement> links =  driver.findElements(By.tagName("a"));
	 System.out.println(links.size());
	 Thread.sleep(3000);
	 
	 for(int i = 0; i < links.size(); i++) {
		 
		WebElement element = links.get(i);
		
		String Url = element.getAttribute("href");
		
		URL link = new URL(Url);
		
		HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
		Thread.sleep(2000);
		httpconn.connect();
		
		int resp = httpconn.getResponseCode();
		
		if (resp >= 400)
		{
			System.out.println(Url + " - "+ " is broken link");
		}
		else {
			System.out.println(Url + " - "+ " is valid link");
		}
		 
		 
	 }
	 
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
