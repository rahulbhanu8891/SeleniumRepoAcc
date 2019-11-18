package SeleniumDay2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Rahul/chromedriver.exe/");
		WebDriver wd= new ChromeDriver();
		wd.get("http://seleniumhq.org/");
		wd.manage().window().maximize();
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,700)");
		js.executeScript("alert('Window has scroll down')");
		Thread.sleep(4000);
		System.out.println(wd.switchTo().alert().getText());
		wd.switchTo().alert().accept();
	}

}
