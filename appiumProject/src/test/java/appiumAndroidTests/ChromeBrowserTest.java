/**
 * @author Solomon
 * This test is extending AndroidDriverInit
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
import baseUtilClass.AndroidDriverInit;

public class ChromeBrowserTest extends AndroidDriverInit {
	
	@Test
	public void openUrl() {
		try {
			Reporter.log("=======Login Started=======",true);
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).sendKeys(Keys.RETURN);
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
