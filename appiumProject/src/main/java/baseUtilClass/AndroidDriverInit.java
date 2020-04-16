/**
 * @author Solomon
 * This is a Base class for Android - Need a simulator or a real device to run
 * 
 * Need to set desired capabilities with the mobile device info:
 *
 * 1. platformName
 * 2. platformVersion
 * 3. deviceName
 * 4. browserName
 * 
 */

package baseUtilClass;
import java.io.ObjectInputStream.GetField;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidDriverInit extends extentReportsInit {				//extends extentReportsInit to get extent Reports functionality
	
	public AndroidDriverInit() {										//Empty Constructor without Initializing
	}
	
	static public AppiumDriver <MobileElement> driver;					//Driver for appium and adding an MobileElement
	
	@BeforeTest
	public void setup() {	
		try {
			Reporter.log("=======Setup Started=======",true);
			System.out.println("This is from setup method");
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//cap.setCapability("deviceName", "LG-G2");					//Mobile device related
			//cap.setCapability("uidd", "LGD802c85901e2");				//Mobile device related
			cap.setCapability("platformName", "Android");				//Mobile device related
			//cap.setCapability("platformVersion", "5.0.2");				//Mobile device related
			cap.setCapability("browserName", "chrome");					//Mobile device related will open the browser
			
			
			cap.setCapability("deviceName", "ONEPLUS A3000");			//Mobile device related
			cap.setCapability("uidd", "65875de1");						//Mobile device related
			cap.setCapability("platformVersion", "9");					//Mobile device related
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AppiumDriver<MobileElement>(url, cap);			//Passing DesiredCapabilities to the driver
			Reporter.log("=======Setup Ended=======",true);
		} 
		catch (Exception e) {
			System.out.println("Failed to pass DesiredCapabilities application did not started");
			System.out.println("Cause"+ e.getCause());
			System.out.println("Message"+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown() {
		
		try {
			Reporter.log("=======tearDown Started=======",true);
			System.out.println("This is from tearDown method");
			driver.close();
			driver.quit();
			Reporter.log("=======tearDown Ended=======",true);
		}
		catch (Exception e) {
			System.out.println("Failed at tearDown method");
			System.out.println("Cause"+ e.getCause());
			System.out.println("Message"+ e.getMessage());
			e.printStackTrace();
		}
	}
}
