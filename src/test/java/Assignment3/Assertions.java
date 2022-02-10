package Assignment3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assertions {
	WebDriver driver;
	@BeforeClass
  public void beforeMethod() {
  System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.manage().window().maximize();
  }

 
  
  @Test(dataProvider = "LoginData")
  public void loginTest(String user, String password, String exp) throws InterruptedException {
	  driver.get("https://admin-demo.nopcommerce.com/");
	  WebElement email = driver.findElement(By.id("Email"));
	  email.clear();
	  email.sendKeys(user);
	  WebElement pw = driver.findElement(By.id("Password"));
	  pw.clear();
	  pw.sendKeys(password);
	  
	  driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
	  
	  String expTitle ="Dashboard / nopCommerce administration";
	  
	  String actTitle = driver.getTitle();
	  
	  if (exp.equals("Valid")){
		  if(expTitle.equals(actTitle)) {
			  Thread.sleep(2000);
			  driver.findElement(By.linkText("Logout")).click();
			  Assert.assertTrue(true);
			  
			System.out.println("Passed");
		  }
		  else {
			  Assert.assertTrue(false);
		  }
		  
	  }
	  else if(exp.equals("Invalid"))
	  { 
		  if (expTitle.equals(actTitle)){
			  driver.findElement(By.linkText("Logout")).click();
			  Assert.assertTrue(false);
		  }
		  else {
			  Assert.assertTrue(true);	
		  }
	  }
	  
  }
  @DataProvider(name="LoginData")
 	public String [][] getData()
 	{
 		String loginData[][]= {
 				{"admin@yourstore.com", "admin", "Valid"},
 				{"admin@yourstore.com", "adm", "Invalid"},
 				{"admn@yourstore.com", "admin", "Invalid"},
 				{"admin@yourstore.com", "adm", "Invalid"},
 		};
 			
 		return loginData;		
 	}
  
  @AfterClass
  public void afterMethod() {
	  driver.close();
  }

}
