package DataDrivenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcel1 {

	public static void main(String[] args) throws Exception, IOException {
		String uname, pwd, wbmsg, xlmsg, result;
		FileOutputStream fWrite;
		FileInputStream fRead;
		XSSFWorkbook wb1;
		XSSFSheet sh;

		System.setProperty("webdriver.chrome.driver", "C:/Rahul/chromedriver.exe/");
		WebDriver driver = new ChromeDriver();
		fRead = new FileInputStream("C:\\Rahul\\excelDemo.xlsx");
		wb1 = new XSSFWorkbook(fRead);
		sh = wb1.getSheetAt(0);
		int RowCount = sh.getPhysicalNumberOfRows();
		driver.get("http://demowebshop.tricentis.com/");
		fWrite = new FileOutputStream("C:\\Rahul\\excelDemo.xlsx");

		for (int i = 1; i < RowCount; i++) {
			uname = sh.getRow(i).getCell(0).getStringCellValue();
			pwd = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(uname + " " + pwd);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Log in")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Email")).sendKeys(uname);
			driver.findElement(By.id("Password")).sendKeys(pwd);
			driver.findElement(By.cssSelector("input[value='Log in']")).click();
			Thread.sleep(1000);
			wbmsg = driver.findElement(By.cssSelector("a.account")).getText();
			xlmsg = sh.getRow(1).getCell(2).getStringCellValue();
			result = wbmsg.equals(xlmsg) ? "Test Pass" : "Test Fail";
			driver.findElement(By.linkText("Log out")).click();
			Thread.sleep(1000);
			sh.getRow(i).createCell(3).setCellValue(wbmsg);
			sh.getRow(i).createCell(4).setCellValue(result);
			System.out.println("Login " + uname);
			System.out.println("password " + pwd);
			System.out.println("Web Msg captured " + wbmsg);
			System.out.println(result);
		}
		wb1.write(fWrite);
		driver.close();
		wb1.close();

	}

}
