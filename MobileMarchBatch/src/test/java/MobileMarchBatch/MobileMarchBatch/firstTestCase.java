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
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		firstTestCase obj = new firstTestCase();
		obj.configuration();
//		obj.simpleEvents();
//		obj.LongPress();
//		obj.ScrollingFirstapproach();
//		obj.ScrollingSecondapproach(); //need to change 'height' value.
		obj.swipeGesture();
	}
}
