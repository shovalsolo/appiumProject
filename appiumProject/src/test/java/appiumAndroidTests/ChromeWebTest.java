/**
 * @author Solomon
 * This is a test on a android mobile calculator - the mobile phone needs to be connected to the PC
 * to get the uidd need to connect the phone and run in cmd the following command
 * adb devices - to get the UIDD of the device
 * 
 * Need to set desired capabilities with the mobile device info:
 *
 * 1. device name
 * 2. uidd
 * 3. platformName
 * 4. platformVersion
 * 
 * 5. appPackage			//is related to the app you are testing 
 * 6. appActivity			//is related to the app you are testing 
 * 
 * http://127.0.0.1:4723/wd/hub
 * 
 * 
 * To run this test need to connect the device and run appium server or studio
 */


package appiumAndroidTests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;


public class ChromeWebTest {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;

	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		cap.setCapability("reportDirectory", reportDirectory);
		cap.setCapability("reportFormat", reportFormat);
		cap.setCapability("testName", testName);
		cap.setCapability("uidd", "LGD802c85901e2");
		cap.setBrowserName(MobileBrowserType.CHROMIUM);
		driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.setLogLevel(Level.INFO);
	}

	@Test
	public void testUntitled() {
		try {
			Reporter.log("=======Login Started=======",true);
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			Reporter.log("=======Login Ended=======",true);
		} catch (InterruptedException e) {
			Reporter.log("=======loginToOrangeHR Failed=======",true);
			System.out.println("Message is " + e.getMessage());
			e.printStackTrace();
			System.out.println("Cause is " + e.getCause());	
		}	
	}
	
	@AfterClass																				//This will run after the class
	public void tearDown() {																//Function to close the browser
		try {
			Reporter.log("=======tearDown Started=======",true);
			driver.close();																	//Closing the browser
			driver.quit();																	//Closing the process 
			System.out.println("Test completed successfully");								//Printing message
			Reporter.log("=======tearDown Ended=======",true);
		} 
		catch (Exception e) {
			Reporter.log("=======tearDown Failed=======",true);
			e.printStackTrace();
			System.out.println("Message is " + e.getMessage());								//Message of the exception
			System.out.println("Cause is " + e.getCause());									//Cause of the exception
		}
	}
}






