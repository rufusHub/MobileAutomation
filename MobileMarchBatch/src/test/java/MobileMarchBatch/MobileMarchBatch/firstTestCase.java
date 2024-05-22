package MobileMarchBatch.MobileMarchBatch;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class firstTestCase extends Base {
	
	public void simpleEvents() {
		WebElement button = driver.findElement(AppiumBy.accessibilityId("Preference"));
		button.click();
		WebElement preferenceDep = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		preferenceDep.click();
		WebElement checkbox = driver.findElement(By.id("android:id/checkbox")); 
		checkbox.click();
		WebElement wifisetting = driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
		wifisetting.click();
		WebElement text  = driver.findElement(By.id("android:id/edit"));
		text.sendKeys("RodrigoM");
		WebElement ok = driver.findElement(By.id("android:id/button1"));
		ok.click();
	}
	
	public void LongPress() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration",2000)); 
		Thread.sleep(2000);		
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		firstTestCase ob = new firstTestCase();
		ob.configuration();
//		ob.simpleEvents();
		ob.LongPress();		
	}
}
