/**
 * @author Solomon
 * This class is a base class init for extent Reports
 */
package baseUtilClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportsInit {

	public static String projectPath = System.getProperty("user.dir");
	ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;

	@BeforeSuite
	public void reportSetup() {
		htmlReporter = new ExtentHtmlReporter(projectPath+"/Reports/"+"MobileReport.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterSuite
	public void reportTearDown() {
		extent.flush();
	}

}
