package MobileMarchBatch.MobileMarchBatch;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class firstTestCase extends Base {
	
	public void simpleEvents() {
		WebElement button = driver.findElement(AppiumBy.accessibilityId("Preference"));
		button.click();
		WebElement preferenceDep = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"));
		preferenceDep.click();
		
		WebElement checkbox = driver.findElement(By.id("android:id/checkbox")); // select checkbox
		checkbox.click();
		
//		DeviceRotation landScape = new DeviceRotation(0,0,90);	// rotates the device!
//		driver.rotate(landScape);
		
		WebElement wifisetting = driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
		wifisetting.click();
		
		driver.setClipboardText("RodrigoM");	    // COPIE text
		
		WebElement text  = driver.findElement(By.id("android:id/edit"));	// selects 'Wifi Settings'
		
		text.sendKeys(driver.getClipboardText());	// PASTE text.
		
		//text.sendKeys("RodrigoM");				// insert text directly.
		
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));	// Press 'ENTER' key.
		
//		driver.hideKeyboard();
		
		WebElement ok = driver.findElement(By.id("android:id/button1"));
		ok.click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	public void LongPress() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration",2000)); 
		Thread.sleep(2000);		
	}
	
	public void ScrollingFirstapproach() throws InterruptedException{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
	    Thread.sleep(2000);
	}
	
	public void ScrollingSecondapproach() throws InterruptedException{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		boolean canScrollMore;
		
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 400,
			    "direction", "down",
			    "percent", 1.0
			));
		} while(canScrollMore);
	}
	
	public void swipeGesture() throws InterruptedException{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage=driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		swipeAction(firstImage, "left");
	}
	
	public void swipeAction(WebElement element,String direction) throws InterruptedException{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
				"left", 100, "top", 100, "width", 1000, "height", 200,
				"direction", direction,
				"percent", 1.0,"speed",15000
		));	
	}
	
	public void DragAndDrop() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source =  driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 577
			));
		Thread.sleep(5000);
		
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println("Result is " + result);
	}
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		firstTestCase obj = new firstTestCase();
		obj.configuration();
//		obj.simpleEvents();
//		obj.LongPress();
//		obj.ScrollingFirstapproach();
//		obj.ScrollingSecondapproach(); //need to change 'height' value.
//		obj.swipeGesture();
//		obj.DragAndDrop();
		
	}
}
