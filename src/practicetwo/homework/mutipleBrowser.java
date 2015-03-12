package practicetwo.homework;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class mutipleBrowser {

	private WebDriver driver = null;
	private Browsers browser = null;

	@Parameters({ "platform" })
	@BeforeMethod(groups = "browsers")
	public void gllys(String platform) {

		if (platform.equals("chrome"))

			browser = new Browsers(BrowsersType.chrome);
		else if (platform.equals("FF"))
			browser = new Browsers(BrowsersType.firefox);
		else
			browser = new Browsers(BrowsersType.ie);
		driver = browser.driver;

	}

	// @BeforeMethod(groups = "browsers")
	// public void intal() {
	// browser = new Browsers(BrowsersType.firefox);
	// driver = browser.driver;
	//
	// }

	@Test(groups = "group_test")
	public void group_test_one() {
		driver.get("http://www.baidu.com");
		System.out.println("This is a group_test_one");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "group_test1")
	public void group_test_two() {
		driver.get("http://www.piaotai.com");
		System.out.println("This is a group_test_two");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "group_test2")
	public void group_test_three() {
		driver.get("http://www.supply.piaotai.com");
		System.out.println("This is a group_test_three");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "group_test3")
	public void group_test_four() {
		driver.get("http://www.manage.piaotai.com");
		System.out.println("This is a group_test_four");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(groups = "browsers")
	public void unintal() {
		// driver.close();
		driver.quit();
	}

}
