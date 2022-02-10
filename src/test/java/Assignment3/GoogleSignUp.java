package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSignUp {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.manage().window().maximize();

	}
	@Test
	public void GoogleAccount() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("ajinkya");
		String firstname= driver.findElement(By.xpath("//*[@id=\"firstName\"]")).getAttribute("id");
		System.out.println("The attribute of first name is: " +firstname);
		Thread.sleep(1500);
		driver.findElement(By.id("lastName")).sendKeys("pandit");
		String lastname= driver.findElement(By.xpath("//*[@id=\"lastName\"]")).getAttribute("id");
		System.out.println("The attribute of first name is: " +lastname);
		Thread.sleep(1500);
		driver.findElement(By.id("username")).sendKeys("ajinkyapandit6363");
		String username= driver.findElement(By.id("username")).getAttribute("id");
		System.out.println("The attribute of username is: " +username);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("abcd@1234");
		String password = driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).getAttribute("type");
		System.out.println("The attribute of username is: "+password);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("abcd@1234");
		String Confirmpassword = driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).getAttribute("aria-label");
		System.out.println("The attribute of username is: "+Confirmpassword);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();
		
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
