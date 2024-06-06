package MobileMarchBatch.MobileMarchBatch;

import java.net.MalformedURLException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class secondTestCase_generalStore_HuaweiDevice extends Base_generalStore_HuaweiDevice{

	public void testCase2() throws InterruptedException {
//		Access to the page - select Male - write a name - Let's Shop
		Thread.sleep(5000);
		driver2.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rodrigo");
		driver2.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver2.findElement(By.id("android:id/text1")).click();
		driver2.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
	    driver2.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
	    driver2.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    
//	    Get Toast Message test
//	    driver2.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rodrigo");
//	    String toastMsg = driver2.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//	    System.out.println(toastMsg);
	    
	    
//	    Scroll to item 1 - get price - add it to cart
	    driver2.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))"));
	    String price1 = driver2.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$170.97\"]")).getAttribute("text");
	    System.out.println(price1);
	    driver2.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();

//	    Scroll to item 2 - get price - add it to cart
	    driver2.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))"));
	    String price2 = driver2.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$115.0\"]")).getAttribute("text");
	    System.out.println(price2);
	    driver2.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
	    
//	    Enter to Cart
	    driver2.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    Thread.sleep(4000);
	    String totalPrice = driver2.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")).getAttribute("text");
	    System.out.println(totalPrice);
	    
//	    Sum price1 and price2
	    double num1 = Double.parseDouble(price1.replace("$", ""));
	    double num2 = Double.parseDouble(price2.replace("$", ""));
	    double total = Double.parseDouble(totalPrice.replace("$", ""));
	    double sum = num1 + num2;
	    DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
	    String formattedSum = decimalFormat.format(sum);
	    System.out.println(formattedSum);
	    if (total == sum) {
	    	System.out.println("Prices are the same, test passed!");
	    }
	    else {
	    	System.out.println("Prices are not the same, the is a bug in the APP!");
	    }
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		secondTestCase_generalStore_HuaweiDevice obj = new secondTestCase_generalStore_HuaweiDevice();
		obj.configuration();
		obj.testCase2();
	}
}