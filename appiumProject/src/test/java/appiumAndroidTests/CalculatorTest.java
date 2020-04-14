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
 */

package appiumAndroidTests;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	
	//WebDriver driver;															//Can also use WebDriver or android driver
	static AppiumDriver <MobileElement> driver;									//Driver for appium and adding an MobileElement

	public static void main(String[] args) {
		try {
			openCalculator();
		} 
		catch (Exception exp) {
			System.out.println("Cause"+exp.getCause());
			System.out.println("Message"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static void openCalculator() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "ONEPLUS A3000");						//Mobile device related
		cap.setCapability("uidd", "65875de1");									//Mobile device related
		cap.setCapability("platformName", "Android");							//Mobile device related
		cap.setCapability("platformVersion", "9");								//Mobile device related
		cap.setCapability("appPackage", "com.oneplus.calculator");				//is related to the app you are testing 
		cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");	//is related to the app you are testing 
		
		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);					//Passing DesiredCapabilities to the driver
		} 
		catch (Exception exp) {
			System.out.println("Failed to pass DesiredCapabilities application did not started");
			System.out.println("Cause"+exp.getCause());
			System.out.println("Message"+exp.getMessage());
			exp.printStackTrace();
		}

		System.out.println("Application started");
		System.out.println("Getting all the Element");
		
		MobileElement one = driver.findElement(By.id("com.oneplus.calculator:id/digit_1"));
		MobileElement two = driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
		MobileElement three = driver.findElement(By.id("com.oneplus.calculator:id/digit_3"));
		MobileElement four = driver.findElement(By.id("com.oneplus.calculator:id/digit_4"));
		MobileElement five = driver.findElement(By.id("com.oneplus.calculator:id/digit_5"));
		MobileElement six = driver.findElement(By.id("com.oneplus.calculator:id/digit_6"));
		MobileElement seven = driver.findElement(By.id("com.oneplus.calculator:id/digit_7"));
		MobileElement eight  = driver.findElement(By.id("com.oneplus.calculator:id/digit_8"));
		MobileElement nine  = driver.findElement(By.id("com.oneplus.calculator:id/digit_9"));
		MobileElement zero  = driver.findElement(By.id("com.oneplus.calculator:id/digit_0"));
		
		MobileElement point  = driver.findElement(By.id("com.oneplus.calculator:id/dec_point"));
		MobileElement plus  = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
		MobileElement minus  = driver.findElement(By.id("com.oneplus.calculator:id/op_sub"));
		MobileElement multiply  = driver.findElement(By.id("com.oneplus.calculator:id/op_mul"));
		MobileElement divide  = driver.findElement(By.id("com.oneplus.calculator:id/op_div"));
		MobileElement equel  = driver.findElement(By.id("com.oneplus.calculator:id/eq"));
		MobileElement delete  = driver.findElement(By.id("com.oneplus.calculator:id/del"));
		MobileElement result  = driver.findElement(By.id("com.oneplus.calculator:id/result"));
		
		System.out.println("Add action");
		
		two.click();
		plus.click();
		three.click();
		equel.click();
		
		String res = result.getText();
		System.out.println("\n Result is : " + res);
		System.out.println("Completed");	
	}
}
