import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) {
		WebDriver driver;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
		
		driver = new ChromeDriver();
				
		driver.get("https://mvnrepository.com/");
		
		driver.close();
		
	}

}
