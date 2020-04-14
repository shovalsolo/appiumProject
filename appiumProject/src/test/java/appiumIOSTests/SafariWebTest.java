/**
 * @author Solomon
 * This is a test on a IOS mobile Browse - Need a simulator or a real device to run
 * 
 * Need to set desired capabilities with the mobile device info:
 *
 * 1. platformName
 * 2. platformVersion
 * 3. deviceName
 * 4. CapabilityType.BROWSER_NAME
 * 
 * 
 * http://127.0.0.1:4723/wd/hub
 */

package appiumIOSTests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;

public class SafariWebTest {
	
	
	@Test
	public static void iosFirstTest() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "iOS");						//Mobile device related
		cap.setCapability("platformVersion", "11.4");					//Mobile device related
		cap.setCapability("deviceName", "iPhone 8");					//Mobile device related
		cap.setCapability(CapabilityType.BROWSER_NAME, "safari");		//Mobile device related will open the browser
		
		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			IOSDriver driver = new IOSDriver(url , cap);				//Using IOSDriver
			
		} catch (MalformedURLException e) {
			System.out.println("Failed to pass DesiredCapabilities application did not started");
			System.out.println("Cause"+ e.getCause());
			System.out.println("Message"+ e.getMessage());
			e.printStackTrace();
		}
	}

}
