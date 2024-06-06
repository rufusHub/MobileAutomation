package MobileMarchBatch.MobileMarchBatch;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class thirdTestCase_apiDemo_HuaweiDevice extends Base_apiDemo_HuaweiDevice{
	
	
	public void preferenceXML() {
//		Selects 'Preference' - 'Preference from XML'
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Preferences from XML\"]")).click();
	}
	
	public void preferenceXML_checkbox() {
//		Review Checkbox status & checks the box.

		this.preferenceXML();
		
		String checkbox1 = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).getAttribute("checked");
		System.out.println(checkbox1);
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		String checkbox2 = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).getAttribute("checked");
		System.out.println(checkbox2);
	}
	
	public void preferenceXML_editTextPreference() {
//		Selects Edit text preference , enters a text & selects ACEPTAR/CANCELAR
		this.preferenceXML();
		
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		
		driver.setClipboardText("Tigre de Bengala");
		
		WebElement text = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]"));
		
		text.sendKeys(driver.getClipboardText());
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();	//ACEPTAR
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();	//CANCELAR
	}
	public void PreferenceXML_listPreference() {
		
		this.preferenceXML();
		
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[3]/android.widget.RelativeLayout")).click();
		
		String alpha1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Alpha Option 01\"]")).getAttribute("checked");
		String beta1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Beta Option 02\"]")).getAttribute("checked");
		String charlie1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Charlie Option 03\"]")).getAttribute("checked");
		System.out.println(alpha1);
		System.out.println(beta1);
		System.out.println(charlie1);
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Charlie Option 03\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[3]/android.widget.RelativeLayout")).click();
		
		String alpha2 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Alpha Option 01\"]")).getAttribute("checked");
		String beta2 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Beta Option 02\"]")).getAttribute("checked");
		String charlie2 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Charlie Option 03\"]")).getAttribute("checked");
		System.out.println(alpha2);
		System.out.println(beta2);
		System.out.println(charlie2);
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();
		
	}
	
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		thirdTestCase_apiDemo_HuaweiDevice obj = new thirdTestCase_apiDemo_HuaweiDevice();
		obj.configuration();
//		obj.preferenceXML_checkbox();
//		obj.preferenceXML_editTextPreference();
		obj.PreferenceXML_listPreference();
	}
}

// driver.findElement(By.xpath(""));