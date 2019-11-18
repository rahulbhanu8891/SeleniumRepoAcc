package ActionDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:/Rahul/chromedriver.exe/");
		WebDriver driver= new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
