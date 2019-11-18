package ActionDemo;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class RoboScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver",  "C:/Rahul/chromedriver.exe/");
		WebDriver wd= new ChromeDriver();
		
		wd.get("https://postimages.org/");
		wd.manage().window().maximize();
		Thread.sleep(3000);
		
		///Creating Screen Shot
		
		File srcFile1=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1,new File("C:\\Rahul\\Temp\\Demo.png"));
		Thread.sleep(1000);
		wd.findElement(By.id("uploadFile")).click();
		
		//Copying file path to clipboard like Ctrl +C
		
		StringSelection copy= new StringSelection("C:\\Rahul\\Temp\\                                                                                          Demo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy, null);
		Thread.sleep(2000);
		
		//Pasting file Path from Clipboard like Ctrl+V
		
		
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		
		robo.keyPress(KeyEvent.VK_V);
		robo.setAutoDelay(1000);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		
		robo.keyRelease(KeyEvent.VK_V);
		robo.setAutoDelay(1000);
		

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.setAutoDelay(1000);
		
	

	}

}
