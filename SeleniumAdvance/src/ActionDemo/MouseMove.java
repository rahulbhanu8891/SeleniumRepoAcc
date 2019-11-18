package ActionDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MouseMove {
	static WebDriver wd;
	static WebElement element;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "C:/Rahul/chromedriver.exe/");
		wd=new ChromeDriver();
		wd.get("http://demowebshop.tricentis.com/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Actions act=new Actions(wd);
		element=wd.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
		act.moveToElement(element).build().perform();
		Thread.sleep(3000);
		
		element=wd.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
		act.moveToElement(element).click().build().perform();
		Thread.sleep(3000);
		
		Assert.assertEquals(wd.getTitle(),"Demo Web Shop. Desktops");
		System.out.println("Test Status Passed");
		wd.close();
		
	}

}
