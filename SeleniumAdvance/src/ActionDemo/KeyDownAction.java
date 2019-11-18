package ActionDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class KeyDownAction {
	static WebDriver wd;
	static WebElement element;
	
	public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver",  "C:/Rahul/chromedriver.exe/");
	wd=new ChromeDriver();
	wd.get("http://demowebshop.tricentis.com/");
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	element=wd.findElement(By.cssSelector("input[value='Search store']"));
	
	Actions act=new Actions(wd);
	
	act.keyDown(element,Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT)
.build().perform();
	
	Thread.sleep(3000);
	
	act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
	Assert.assertTrue(wd.getTitle().contains("Build your own computer"));
	System.out.println("Test is ok");
	}
	
}
