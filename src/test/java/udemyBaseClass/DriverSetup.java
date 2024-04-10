package udemyBaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverSetup {
	public static AppiumDriver<MobileElement> driver;
	
	public static AppiumDriver<MobileElement> setDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 7 Pro API 27");
		caps.setCapability("platformName", "Android");
		DriverSetup.driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") ,caps);
		
		return driver;
	}
}
