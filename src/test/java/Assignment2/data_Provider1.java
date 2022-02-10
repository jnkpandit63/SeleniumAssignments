package Assignment2;
	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class data_Provider1 {
		
		WebDriver driver;
	  	@DataProvider(name = "test-data")
	  	public Object[][] dataProv(){
	        	return new String[][]{
	        		{"Infosys"},{"Pune"},{"Hinjewadi"}
	        	};
	  	}
	  	
	  	@BeforeMethod
		  public void setUpData() {
	       	  System.out.println("Start test");
	       	System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
	      	  driver = new ChromeDriver();
	      	  driver.get("https://www.google.com");
	      	  driver.manage().window().maximize();
	      	 
		  }
	  	
	  	@Test(dataProvider ="test-data")
	  	public void search(String keyWord)throws InterruptedException{
	        	  
	  		      WebElement text = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	        	  text.sendKeys(keyWord);
	        	  Thread.sleep(2500);
	        	 
	  	}
	  	
	  	
	  	@AfterMethod
	  	public void tearDown(){
	        	driver.close();
	  	}

	}


