package SeleniumGridDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

// Create a Hub
///java -jar C:\Rahul\selenium-server-standalone-3.141.59.jar -port 3333 -role hub

//Connect to node
///java -Dwebdriver.chrome.driver="C:\Rahul\chromedriver.exe" -jar C:\Rahul\selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.56.1:3333/grid/register/ -port 8891

//http://192.168.56.1:3333/grid/console
public class GridDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Rahul/chromedriver.exe/");
		
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);
		URL link= new URL("http://192.168.56.1:3333/wd/hub");
		WebDriver wd= new RemoteWebDriver(link,dc);
		
		wd.get("http://demowebshop.tricentis.com/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement element=wd.findElement(By.cssSelector("input[value='Search store']"));
		
		Actions act=new Actions(wd);
		
		act.keyDown(element,Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT)
	.build().perform();
		
		Thread.sleep(3000);
		
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		Assert.assertTrue(wd.getTitle().contains("Build your own computer"));
		System.out.println("Test is ok");

	}

}
