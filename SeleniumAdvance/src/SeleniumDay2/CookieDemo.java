package SeleniumDay2;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Rahul/chromedriver.exe/");
		WebDriver wd= new ChromeDriver();
		wd.get("http://www.rediff.com/");
		wd.manage().window().maximize();
		Thread.sleep(1000);
		
		Cookie TestCookie1=new Cookie("Username","TestUser");
		wd.manage().addCookie(TestCookie1);
		Cookie TestCookie2= new Cookie("Password","TestPassword");
		wd.manage().addCookie(TestCookie2);
		
		
		Set<Cookie> ck=wd.manage().getCookies();
		for(Cookie c:ck) {
			System.out.println("Name "+c.getName());
			System.out.println("Value "+c.getValue());
			System.out.println("Domain "+c.getDomain());
			System.out.println("Path "+c.getPath());
			System.out.println("Expires "+c.getExpiry());
			
			wd.manage().deleteCookie(TestCookie1);
			
		}
	}

}
