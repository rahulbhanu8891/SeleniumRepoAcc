package ActionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",  "C:/Rahul/chromedriver.exe/");
		WebDriver wd=new ChromeDriver();
		wd.get("https://www.google.com");
		wd.findElement(By.name("q")).sendKeys("Accenture");
		wd.findElement(By.name("btnK")).submit();
		
		
	}
	
}
