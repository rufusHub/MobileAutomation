package MobileMarchBatch.MobileMarchBatch;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class secondTestCase_generalStore_HuaweiDevice extends Base_generalStore_HuaweiDevice{

	public void testCase2() throws InterruptedException {
		Thread.sleep(5000);
		driver2.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rodrigo");
		driver2.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver2.findElement(By.id("android:id/text1")).click();
		driver2.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
	    driver2.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
	    driver2.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//	    Test_1 without entering the name in line:
//	    	driver2.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rodrigo");
//	    String toastMsg = driver2.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//	    System.out.println(toastMsg);
	    driver2.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))"));
	    String price1 = driver2.findElement(By.xpath("(//android.widget.TextView)[@resourse-id=\"com.androidsample.generalstore:id/productPrice\"and @text=\"$170.97\"]")).getAttribute("name");
	    System.out.println(price1);
//	    driver2.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"))"));
//	    String price2 = driver2.findElement(By.xpath("(//android.widget.TextView)[0]")).getAttribute("name");
//	    System.out.println(price2);
	    
	    
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		secondTestCase_generalStore_HuaweiDevice obj = new secondTestCase_generalStore_HuaweiDevice();
		obj.configuration();
		obj.testCase2();
	}
}