package switchcare;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HealthcareApp.SwitchCareCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwitchCareTest extends SwitchCareCapabilities{
	
	AndroidDriver<AndroidElement> driver;
		
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority = 0, enabled = true)
	public void loginPage() throws InterruptedException {
		
		
		// Allowing Get Notified
		driver.findElement(MobileBy.id("com.mysmitch.care:id/imgNotification")).click();
		driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
		// Allowing Location
		driver.findElement(MobileBy.id("com.mysmitch.care:id/ivLocationCheck")).click();
		driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		
		//Allowing Nearby Device
		driver.findElement(MobileBy.id("com.mysmitch.care:id/ivNearyByCheck")).click();
		driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
		driver.findElement(MobileBy.id("com.mysmitch.care:id/btnNext")).click();
		
		
		// Clicking Login Button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/txtLogin")).click();
		driver.findElement(MobileBy.id("com.mysmitch.care:id/btn_already_have_account")).click();
		
		AndroidElement cancel = driver.findElement(MobileBy.id("com.google.android.gms:id/cancel"));
		cancel.click();
		
		driver.findElement(MobileBy.id("com.mysmitch.care:id/or_login_with_other_methods")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Email\")")).click();
		
		// Entering user_name
		driver.findElement(MobileBy.id("com.mysmitch.care:id/email")).sendKeys("samirs1205@gmail.com");
		
		// Entering password
		driver.findElement(MobileBy.id("com.mysmitch.care:id/password")).sendKeys("Pass@098");
		
		// click continue button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/button_sign_in")).click();
		Thread.sleep(7000);
		
	}
	
	@Test(priority = 1)
	public void selectfood() {
		
		// Clicked login text -- If priority - 1 "true" then comment this
//		driver.findElement(MobileBy.id("com.mysmitch.care:id/txtLogin")).click();
		// Define start to end coordinate
		int startX = 365;
		int startY = 1028;
		int endX = 336;
		int endY = 400;
		
		// Perform a scroll (swip) feature
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, endY))
		.release().perform();
		
		// Click nuration
		driver.findElement(MobileBy.id("com.mysmitch.care:id/nutrition_image")).click();
	}
	
	@Test(priority = 2, enabled = true)
	public void breakfast() throws InterruptedException {
		
		// Select breakfast 
		driver.findElement(MobileBy.id("com.mysmitch.care:id/ivBreakFastNext")).click();
		// Clicking breakfast time
		driver.findElement(MobileBy.id("com.mysmitch.care:id/chipTwo")).click();
		// selecting meal category
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Healthy\")")).click();
		// Select meal prepared
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fresh Foods\")")).click();
	
		// perform scrolling
		int startX = 365;
		int startY = 1220;
		int endX = 365;
		int endY = 450;
		TouchAction scrollAction = new TouchAction(driver);
		scrollAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, endY))
		.release().perform();
		
		// perform swipe right
		AndroidElement  hungryScall = driver.findElement(MobileBy.id("com.mysmitch.care:id/slider"));
		Point scallStartX = hungryScall.getLocation();
		org.openqa.selenium.Dimension size = hungryScall.getSize();	
		System.out.println("Point is: " + scallStartX);
		System.out.println("Dimension is: " + size);
		
		Thread.sleep(2000);
		int HscallX = 71;
		int HscallY = 481;
		int HendscallX = 500;
		int HendscallY = 481;
		TouchAction drag = new TouchAction(driver);
		drag.press(PointOption.point(HscallX, HscallY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(HendscallX, HendscallY)).release().perform();
		
		// Add Foods by Clicking the food name
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fruits\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Nuts & Seeds\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dairy\")")).click();
		
		
		int startX1 = 324;
		int startY1 = 1305;
		int endX2 = 324;
		int endY2 = 465;
		TouchAction scrollAction2 = new TouchAction(driver);
		scrollAction2.press(PointOption.point(startX1, startY1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(endX2, endY2)).release().perform();
		
		// clicked on save button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/btnFinish")).click();
		
		// click back button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/back_arrow")).click();
		
	}
	
	@Test (priority = 3, enabled = true)
	public void Lunch() throws InterruptedException {
		
		// Click nuration
		driver.findElement(MobileBy.id("com.mysmitch.care:id/nutrition_image")).click();
		// select Lunch
		driver.findElement(MobileBy.id("com.mysmitch.care:id/tvLunch")).click();
		// Clicking lunch time
		driver.findElement(MobileBy.id("com.mysmitch.care:id/chipTwo")).click();
		// selecting meal category
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Healthy\")")).click();
		// Select meal prepared
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Home Cooked\")")).click();
		
		/*
		
		*/
		
		Thread.sleep(2000);
		AndroidElement  hungryScall = driver.findElement(MobileBy.id("com.mysmitch.care:id/slider"));
		// Finding coordinate
		int HscallX = 71;
		int HscallY = hungryScall.getLocation().getY() + (hungryScall.getSize().getHeight() / 2);
		System.out.println("X point Location : " + HscallX);
		int HendscallX = 500;

		// perform swipe
		TouchAction drag = new TouchAction(driver);
		drag.press(PointOption.point(HscallX, HscallY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(HendscallX, HscallY)).release().perform();
		
		Thread.sleep(2000);
		// perform scrolling
		int startX = 365;
		int startY = 1220;
		int endX = 365;
		int endY = 500;
		TouchAction scrollAction = new TouchAction(driver);
		scrollAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, endY))
		.release().perform();
		
		// Add Foods name for lunch
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Vegetables\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Grains\")")).click();
		
		
		// perform scrolling
		int startX1 = 324;
		int startY1 = 1305;
		int endX2 = 324; 
		int endY2 = 465;
		TouchAction scrollAction2 = new TouchAction(driver);
		scrollAction2.press(PointOption.point(startX1, startY1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(endX2, endY2)).release().perform();
		
		// clicked on save button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/btnFinish")).click();
		
		// click back button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/back_arrow")).click();
		
		
		
		
	}
	
	
	@Test (priority = 4)
	public void dinner() throws InterruptedException {
		
		// Click nuration
		driver.findElement(MobileBy.id("com.mysmitch.care:id/nutrition_image")).click();
		// select Dinner
		driver.findElement(MobileBy.id("com.mysmitch.care:id/tvDinner")).click();
		
		// perform drag right to left to select another time
		AndroidElement time3 = driver.findElement(MobileBy.id("com.mysmitch.care:id/chipThree"));
		int timeX = time3.getLocation().getX() + time3.getSize().getWidth();
		int timeY = time3.getLocation().getY() + (time3.getSize().getHeight() / 2);
		int timeX1 = time3.getLocation().getX();
		

		
		driver.findElement(MobileBy.id("com.mysmitch.care:id/chipThree")).click();
		// selecting meal category
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Healthy\")")).click();
		// Select meal prepared
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Home Cooked\")")).click();

		
		Thread.sleep(2000);
		AndroidElement  hungryScall = driver.findElement(MobileBy.id("com.mysmitch.care:id/slider"));
		// Finding coordinate
		int HscallX = 71;
		int HscallY = hungryScall.getLocation().getY() + (hungryScall.getSize().getHeight() / 2);
		System.out.println("X point Location : " + HscallX);
		int HendscallX = 500;

		// perform swipe
		TouchAction dragright = new TouchAction(driver);
		dragright.press(PointOption.point(HscallX, HscallY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(HendscallX, HscallY)).release().perform();

		Thread.sleep(2000);
		// perform scrolling down
		int startX = 365;
		int startY = 1220;
		int endX = 365;
		int endY = 500;
		TouchAction scrollAction = new TouchAction(driver);
		scrollAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, endY))
		.release().perform();

		// Add Foods name for Dinner
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Grains\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Vegetables\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dairy\")")).click();


		// perform scrolling
		int startX1 = 324;
		int startY1 = 1305;
		int endX2 = 324; 
		int endY2 = 465;
		TouchAction scrollAction2 = new TouchAction(driver);
		scrollAction2.press(PointOption.point(startX1, startY1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(endX2, endY2)).release().perform();

		// clicked on save button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/btnFinish")).click();

		// click back button
		driver.findElement(MobileBy.id("com.mysmitch.care:id/back_arrow")).click();
	}
	
}
