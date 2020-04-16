/**
 * @author Solomon
 * This test is extending AndroidDriverInit that is extending extentReportsInit
 * A demo for extent Reports on a android mobile test
 * 
 * Need to set desired capabilities with the mobile device info:
 *
 * 1. platformName
 * 2. platformVersion
 * 3. deviceName
 * 4. browserName
 */

package appiumAndroidTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseUtilClass.AndroidDriverInit;

public class ChromeBrowserTest extends AndroidDriverInit {
	
	@Test
	public void openUrlAndLogin() {
		try {
			
			ExtentTest test1 = extent.createTest("Login Test","Open Url And Login");	//Using extent Reports
			
			Reporter.log("=======Login Started=======",true);
			
			test1.log(Status.INFO, "Open URL Started");
			driver.get("https://opensource-demo.orangehrmlive.com/");
			test1.log(Status.PASS, "Open URL passed");
			
			test1.log(Status.INFO, "Send Username");
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			test1.log(Status.PASS, "Send Username passed");
			
			test1.log(Status.INFO, "Send password Started");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			test1.log(Status.PASS, "Send URL passed");
			
			test1.log(Status.INFO, "Send Enter Started");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).sendKeys(Keys.RETURN);
			test1.log(Status.PASS, "Send  Enter passed");
			
			Thread.sleep(5000);
			Reporter.log("=======Login Ended=======",true);
		} 
		catch (InterruptedException e) {
			Reporter.log("=======loginToOrangeHR Failed=======",true);
			System.out.println("Message is " + e.getMessage());
			e.printStackTrace();
			System.out.println("Cause is " + e.getCause());	
		}	
	}
}
