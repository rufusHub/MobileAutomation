
package MobileMarchBatch.MobileMarchBatch;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base_generalStore_HuaweiDevice {

		public static AndroidDriver  driver2;
	
		public void configuration() throws MalformedURLException {
			
			//<Start Appium server from code>
			File js = new File("/home/rufo/.nvm/versions/node/v20.12.1/lib/node_modules/appium/build/lib/main.js");
			
			AppiumDriverLocalService service =
					  new AppiumServiceBuilder()
					  .withAppiumJS(js)
					  .withIPAddress("0.0.0.0")
					  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
					  .usingPort(4723)
					  .build();
					  service.start();
					  
		    //<Desire capabilities>
			File app = new File("/home/rufo/Documents/GeneralStore.apk");		  
			
			DesiredCapabilities cap = new DesiredCapabilities();		 
			cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability("deviceName", "L4SDU17907000554");
			cap.setCapability("platformName", "Android");
			cap.setCapability("automationName","UiAutomator2"); 
			  
			driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			
		}
}


//Dial *#*#2846579#*#*
//Select background
//Select USB mode
//Select "Google mode"
//Open settings
//Find development options
//Enable ADB over USB.

//File js = new File("/home/rufo/.nvm/versions/node/v20.12.1/lib/node_modules/appium/build/lib/main.js");
//File js = new File("C:\\Users\\bermudez\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

//File app = new File("/home/rufo/Documents/GeneralStore.apk");
//File app = new File("C:\\Users\\bermudez\\Documentos\\Deepak_Chanana\\Zipeados\\ApiDemo.apk");