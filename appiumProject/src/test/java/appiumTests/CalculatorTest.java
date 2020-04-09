/**
 * @author Solomon
 * This is a test on a android mobile calculator - the mobile phone needs to be connected to the PC
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

package appiumTests;
import java.net.URL;

import org.openqa.selenium.WebDriver;
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
	}

}
