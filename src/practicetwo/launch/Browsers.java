package practicetwo.launch;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {

	public WebDriver driver = null;
	private FirefoxProfile firefoxprofile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = "C:\\Users\\Administrator\\Desktop\\FireflyAutomation\\trunk";

	public Browsers(BrowsersType browserstype) {
		switch (browserstype) {
		case firefox:
			File firebug = new File(projectpath + "/tool/firebug-2.0.7.xpi");
			File firepath = new File(projectpath
					+ "/tool/FireXPath-0.9.7.1.xpi");
			firefoxprofile = new FirefoxProfile();
			try {
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firepath);
				firefoxprofile.setPreference(
						"webdriver.accept.untrusted.certs", "true");
				firefoxprofile.setPreference(
						"extensions.firebug.currentVersion", "2.0.7");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new FirefoxDriver(firefoxprofile);
			driver.manage().window().maximize();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath
					+ "/tool/IEDriverServer64.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,
					false);
			caps.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			driver.get("javascript:document.getElementById('overridelink').click();");
			driver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectpath
					+ "/tool/chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches",
					Arrays.asList("--start-maximized")); // ���browser
			// capabilities.setCapability("chrome.switches",
			// Arrays.asList("--proxy-server=http://your-proxy-domain:4443"));
			// //���ô���
			driver = new ChromeDriver(caps);
			driver.manage().window().maximize();
			break;
		}

	}
}
