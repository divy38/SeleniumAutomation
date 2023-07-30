package org.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.netty.handler.codec.http.multipart.FileUpload;

import org.apache.commons.*;
import org.apache.commons.io.FileUtils;

public class PaymentGatewayTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\praka\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launch the browser
		driver.get("https://demo.guru99.com/");
		driver.findElement(By.xpath("//a[text()='Payment Gateway Project']")).click();
		WebElement buynow = driver.findElement(By.xpath("//input[@type='submit']"));
		buynow.click();
		
	//Alert confirmAlert=driver.switchTo().alert();
	//confirmAlert.dismiss();
		
		driver.findElement(By.id("card_nmuber")).sendKeys("6464313197971212");
		WebElement expMonth = driver.findElement(By.id("month"));
		
		//using index based select to select the option
        Select s =new Select(expMonth);
		s.selectByIndex(3);
		
		WebElement year = driver.findElement(By.id("year"));
	    Select s1=new Select(year);
	    s1.selectByIndex(7);
	    
	    driver.findElement(By.id("cvv_code")).sendKeys("123");
	    driver.findElement(By.name("submit")).click();
	    
	    //Take screenshot of orderID and saved in screenshot folder
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File target=new File(".\\screenshots\\orderpage.png");
	   FileUtils.copyFile(src, target);
	
	}

}

